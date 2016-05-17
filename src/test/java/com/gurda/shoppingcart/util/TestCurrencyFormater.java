package com.gurda.shoppingcart.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCurrencyFormater {

    @Test
    public void shouldFormatZeroValue() throws Exception {
        // when
        String formatted = CurrencyFormater.formatCurrency(0);
        // then
        assertEquals("$0.00", formatted);
    }

    @Test
    public void shouldAppendZeros() throws Exception {
        // when
        String formatted = CurrencyFormater.formatCurrency(200);
        // then
        assertEquals("$2.00", formatted);
    }

    @Test
    public void shouldFormatNonZeroValue() throws Exception {
        // when
        String formatted = CurrencyFormater.formatCurrency(123456789);
        // then
        assertEquals("$1,234,567.89", formatted);
    }
}
