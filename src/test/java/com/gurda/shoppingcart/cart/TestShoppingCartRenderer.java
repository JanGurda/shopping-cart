package com.gurda.shoppingcart.cart;

import com.gurda.shoppingcart.product.ProductCatalog;
import com.gurda.shoppingcart.product.ProductNotFound;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestShoppingCartRenderer {

    private ShoppingCart cart;
    private ShoppingCartRenderer renderer;

    @Before
    public void setup() throws Exception {
        cart = prepareShopingCart();
        renderer = new ShoppingCartRenderer(cart);
    }

    @Test
    public void shouldRenderCart() throws Exception {
        // when
        String cartText = renderer.render();
        // then
        assertTrue(cartText.contains("Total price: |$2.75"));
        assertTrue(cartText.contains("Get 3 pay for 2. (- $0.50)"));
    }

    @Test
    public void shouldRenderEmptyCart() throws Exception {
        // given
        renderer = new ShoppingCartRenderer(new ShoppingCart());
        // when
        String cartText = renderer.render();
        // then
        assertTrue(cartText.contains("Total price: |$0.00"));
    }

    private ShoppingCart prepareShopingCart() throws ProductNotFound {
        ProductCatalog productCatalog = new ProductCatalog();
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(productCatalog.getByName("Apple"));
        cart.addProduct(productCatalog.getByName("Apple"));
        cart.addProduct(productCatalog.getByName("Apple"));
        cart.addProduct(productCatalog.getByName("Banana"));
        cart.addProduct(productCatalog.getByName("Banana"));
        cart.addProduct(productCatalog.getByName("Banana"));
        cart.addProduct(productCatalog.getByName("Banana"));
        cart.addProduct(productCatalog.getByName("Banana"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        cart.addProduct(productCatalog.getByName("Papaya"));
        return cart;
    }

}
