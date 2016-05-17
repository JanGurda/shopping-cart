package com.gurda.shoppingcart.pricing;

import lombok.Builder;

import static java.lang.String.format;

@Builder
public class BundleDiscountStrategy implements DiscountStrategy {

    private int eligibleSize;
    private int chargeFor;

    @Override
    public int getDiscount(int unitPrice, int quantity) {
        int numberOfBundles = quantity / eligibleSize;
        return numberOfBundles * unitPrice * (eligibleSize - chargeFor);
    }

    @Override
    public String getName() {
        return format("Get %d pay for %d.", eligibleSize, chargeFor);
    }

}
