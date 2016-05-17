package com.gurda.shoppingcart.pricing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBundleDiscountStrategy {

    private BundleDiscountStrategy strategy = BundleDiscountStrategy.builder().eligibleSize(5).chargeFor(2).build();

    @Test
    public void shouldReturnNoDiscount() throws Exception {
        // when
        int discount = strategy.getDiscount(1000, 2);
        // then
        assertEquals(0, discount);
    }

    @Test
    public void shouldReturnCorrectDiscountName() throws Exception {
        // when
        String name = strategy.getName();
        // then
        assertEquals("Get 5 pay for 2.", name);
    }

    @Test
    public void shouldApplyDiscountOnce() throws Exception {
        // when
        int discount = strategy.getDiscount(1000, 6);
        // then
        assertEquals(3000, discount);
    }

    @Test
    public void shouldApplyDiscountTwice() throws Exception {
        // when
        int discount = strategy.getDiscount(1000, 13);
        // then
        assertEquals(6000, discount);
    }

}
