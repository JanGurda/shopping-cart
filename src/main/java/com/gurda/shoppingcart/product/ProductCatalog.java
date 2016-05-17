package com.gurda.shoppingcart.product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.gurda.shoppingcart.pricing.BundleDiscountStrategy;
import com.gurda.shoppingcart.pricing.NoDiscountStrategy;

import static java.lang.String.format;

public class ProductCatalog {

    private Map<String, Product> productsByName = new HashMap<>();

    public ProductCatalog() {
        productsByName.put("Apple", new Product("Apple", 25, new NoDiscountStrategy()));
        productsByName.put("Orange", new Product("Orange", 30, new NoDiscountStrategy()));
        productsByName.put("Banana", new Product("Banana", 15, new NoDiscountStrategy()));
        productsByName.put("Papaya", new Product("Papaya", 25, BundleDiscountStrategy.builder().eligibleSize(3).chargeFor(2).build()));
    }

    public Product getByName(String productName) throws ProductNotFound {
        return Optional.ofNullable(productsByName.get(productName))
                .orElseThrow(() -> new ProductNotFound(format("Product '%s' not found.", productName)));
    }
}
