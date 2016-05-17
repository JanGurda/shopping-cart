package com.gurda.shoppingcart.pricing;

public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public int getDiscount(int unitPrice, int quantity) {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }

}
