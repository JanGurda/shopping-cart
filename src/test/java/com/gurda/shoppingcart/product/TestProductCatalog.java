package com.gurda.shoppingcart.product;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestProductCatalog {

    private ProductCatalog catalog = new ProductCatalog();

    @Test
    public void shouldGetProductByName() throws Exception {
        // when
        Product product = catalog.getByName("Apple");
        // then
        assertNotNull(product);
    }

    @Test(expected = ProductNotFound.class)
    public void shouldThrowExceptionWhenProductNotFound() throws Exception {
        // when
        catalog.getByName("NotExistaing");
        // then
    }
}
