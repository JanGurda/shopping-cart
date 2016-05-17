package com.gurda.shoppingcart.product;

import com.gurda.shoppingcart.ShoppingCartException;

public class ProductNotFound extends ShoppingCartException {

    private static final long serialVersionUID = -5957557179921575381L;

    public ProductNotFound(String message) {
        super(message);
    }

}
