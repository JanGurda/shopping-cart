package com.gurda.shoppingcart.cart;

import java.util.HashMap;
import java.util.Map;

import com.gurda.shoppingcart.product.Product;

public class ShoppingCart {

    Map<Product, Integer> quantities = new HashMap<>();

    public void addProduct(Product product) {
        int currentQuantity = getCurrentQuantity(product);
        quantities.put(product, currentQuantity + 1);
    }

    private int getCurrentQuantity(Product product) {
        return quantities.get(product) == null ? 0 : quantities.get(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : quantities.keySet()) {
            totalPrice += product.getPriceForQuantity(quantities.get(product));
        }
        return totalPrice;
    }

}
