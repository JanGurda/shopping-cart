package com.gurda.shoppingcart.cart;

import com.gurda.shoppingcart.product.Product;

import static com.gurda.shoppingcart.util.CurrencyFormater.formatCurrency;

public class ShoppingCartRenderer {

    private static final String SEPARATOR = "-------------------------------------------------------------------------------------------------------------------\n";
    private ShoppingCart shoppingCart;

    public ShoppingCartRenderer(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String render() {
        StringBuilder textualRepresentation = new StringBuilder();
        textualRepresentation.append(getHeader());
        for (Product product : shoppingCart.quantities.keySet()) {
            textualRepresentation.append(product.renderProductLine(shoppingCart.quantities.get(product)));
        }
        textualRepresentation.append(getFooter());
        return textualRepresentation.toString();
    }

    private String getHeader() {
        StringBuilder headerBuilder = new StringBuilder();
        headerBuilder
                .append(String.format("%-20s|%-12s|%-10s|%-40s|%-10s\n", "Product name", "Unit price", "Quantity", "Discounts", "Price"));
        headerBuilder.append(SEPARATOR);
        return headerBuilder.toString();
    }

    private String getFooter() {
        StringBuilder footerBuilder = new StringBuilder();
        footerBuilder.append(SEPARATOR);
        footerBuilder.append(String.format("%85s|%-10s\n", "Total price: ", formatCurrency(shoppingCart.getTotalPrice())));
        return footerBuilder.toString();
    }
}
