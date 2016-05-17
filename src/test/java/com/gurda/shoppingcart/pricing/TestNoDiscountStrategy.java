package com.gurda.shoppingcart.pricing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestNoDiscountStrategy {

    private NoDiscountStrategy strategy = new NoDiscountStrategy();

    @Test
    public void shouldReturnEmptyDiscount() throws Exception {
        // when
        int discount = strategy.getDiscount(10, 100);
        // then
        assertEquals(0, discount);
    }
}
