package com.gurda.shoppingcart;

public class ShoppingCartException extends Exception {

    private static final long serialVersionUID = -9180395834682760881L;

    public ShoppingCartException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShoppingCartException(String message) {
        super(message);
    }
}
