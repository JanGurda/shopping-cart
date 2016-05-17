package com.gurda.shoppingcart.product;

import com.gurda.shoppingcart.pricing.DiscountStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class TestProduct {

    @Mock
    private DiscountStrategy discountStrategy;

    private Product product;

    @Before
    public void setup() throws Exception {
        product = new Product("Some Name", 1000, discountStrategy);
    }

    @Test
    public void shouldReturnpriceWhenNoDiscount() throws Exception {
        // given
        given(discountStrategy.getDiscount(anyInt(), anyInt())).willReturn(0);
        // when
        int price = product.getPriceForQuantity(12);
        // then
        assertEquals(12000, price);
    }

    @Test
    public void shouldReducePriceByDiscount() throws Exception {
        // given
        given(discountStrategy.getDiscount(anyInt(), anyInt())).willReturn(3000);
        // when
        int price = product.getPriceForQuantity(12);
        // then
        assertEquals(9000, price);
    }

    @Test
    public void shouldRenderWithDiscount() throws Exception {
        // given
        given(discountStrategy.getDiscount(anyInt(), anyInt())).willReturn(3000);
        given(discountStrategy.getName()).willReturn("Some discount");
        // when
        String productString = product.renderProductLine(19);
        // then
        assertEquals("Some Name           |$10.00      |19        |Some discount (- $30.00)                |$160.00   \n", productString);
    }

    @Test
    public void shouldRenderWithoutDiscount() throws Exception {
        // given
        given(discountStrategy.getDiscount(anyInt(), anyInt())).willReturn(0);
        // when
        String productString = product.renderProductLine(19);
        // then
        assertEquals("Some Name           |$10.00      |19        |                                        |$190.00   \n", productString);
    }

}
