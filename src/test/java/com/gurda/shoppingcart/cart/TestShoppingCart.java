package com.gurda.shoppingcart.cart;

import com.gurda.shoppingcart.pricing.BundleDiscountStrategy;
import com.gurda.shoppingcart.pricing.DiscountStrategy;
import com.gurda.shoppingcart.pricing.NoDiscountStrategy;
import com.gurda.shoppingcart.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestShoppingCart {

    private ShoppingCart cart = new ShoppingCart();

    @Mock
    private DiscountStrategy discountStrategy;

    private Product product1 = new Product("Name1", 1000, new NoDiscountStrategy());
    private Product product2 = new Product("Name2", 300, BundleDiscountStrategy.builder().eligibleSize(2).chargeFor(1).build());

    @Test
    public void shouldAddNewProduct() throws Exception {
        // when
        cart.addProduct(product1);
        // then
        assertEquals(1, cart.quantities.get(product1).intValue());

    }

    @Test
    public void shouldIncreaseQuantityOfAlreadyAddedProduct() throws Exception {
        // given
        cart.addProduct(product1);
        // when
        cart.addProduct(product1);
        // then
        assertEquals(2, cart.quantities.get(product1).intValue());
    }

    @Test
    public void shouldTotalPriceBeZeroWhenCartEmpty() throws Exception {
        // when
        int totalPrice = cart.getTotalPrice();
        // then
        assertEquals(0, totalPrice);
    }

    @Test
    public void shouldCalculateTotalPriceForCart() throws Exception {
        // given
        cart.addProduct(product1);
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product2);
        cart.addProduct(product2);
        // when
        int totalPrice = cart.getTotalPrice();
        // then
        assertEquals(2600, totalPrice);
    }
}
