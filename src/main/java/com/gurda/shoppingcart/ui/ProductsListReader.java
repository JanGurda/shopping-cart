package com.gurda.shoppingcart.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.gurda.shoppingcart.ShoppingCartException;
import org.apache.commons.io.IOUtils;

public final class ProductsListReader {

    private ProductsListReader() {
        super();
    }

    @SuppressWarnings("unchecked")
    public static List<String> read(String filename) throws ShoppingCartException {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                throw new ShoppingCartException(String.format("File '%s' not found.", filename));
            }
            return IOUtils.readLines(new FileInputStream(file));
        } catch (IOException | RuntimeException e) {
            throw new ShoppingCartException("Unable to read products list file.", e);
        }
    }
}
