package com.gurda.shoppingcart.pricing;

public interface DiscountStrategy {

    int getDiscount(int unitPrice, int quantity);

    String getName();

}
