package com.engine.rule.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import com.engine.rule.model.Product;

public class ProductServiceIntegrationTest {
	private ProductService productService;
	
	
    @Before
    public void setup() {
        productService = new ProductService();
    }


    @Test
    public void whenProductTypeElectronic_ThenLabelBarcode() {
        Product product = new Product("Microwave", "Electronic");
        product = productService.applyLabelToProduct(product);
        assertEquals("BarCode", product.getLabel());
    }

    @Test
    public void whenProductTypeBook_ThenLabelIsbn() {
        Product product = new Product("AutoBiography", "Book");
        product = productService.applyLabelToProduct(product);
        assertEquals("ISBN", product.getLabel());
    }
}
