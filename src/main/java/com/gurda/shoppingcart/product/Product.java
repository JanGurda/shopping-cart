package com.gurda.shoppingcart.product;

import com.gurda.shoppingcart.pricing.DiscountStrategy;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import static com.gurda.shoppingcart.util.CurrencyFormater.formatCurrency;
import static java.lang.String.format;

@AllArgsConstructor
@EqualsAndHashCode(exclude = { "unitPrice", "discountStrategy" })
public class Product {

    private String name;
    private int unitPrice;
    private DiscountStrategy discountStrategy;

    public int getPriceForQuantity(int quantity) {
        int priceWithoutDiscount = unitPrice * quantity;
        int discount = getDiscount(quantity);
        return priceWithoutDiscount - discount;
    }

    private int getDiscount(int quantity) {
        return discountStrategy.getDiscount(unitPrice, quantity);
    }

    public String renderProductLine(int quantity) {
        return String.format("%-20s|%-12s|%-10d|%-40s|%-10s\n",
                name,
                formatCurrency(unitPrice),
                quantity,
                getDiscountString(quantity),
                formatCurrency(getPriceForQuantity(quantity)));
    }

    String getDiscountString(int quantity) {
        int discount = getDiscount(quantity);
        if (discount > 0) {
            return format("%s (- %s)", discountStrategy.getName(), formatCurrency(discount));
        }
        return "";
    }

}
