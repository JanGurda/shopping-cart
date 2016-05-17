package com.gurda.shoppingcart.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Responsibility: Formats "pennies representation" of amount to user-readable value.
 */
public final class CurrencyFormater {

    private static final Locale LOCALE = new Locale("en", "US");

    private CurrencyFormater() {
        super();
    }

    public static String formatCurrency(int amount) {
        BigDecimal decimalValue = new BigDecimal(amount);
        decimalValue = decimalValue.movePointLeft(2);
        return NumberFormat.getCurrencyInstance(LOCALE).format(decimalValue);
    }
}
