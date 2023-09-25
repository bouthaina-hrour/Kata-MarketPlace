package com.kata.marketplace.services;

import com.kata.marketplace.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductConverterTest {
    @Test
    public void testConvertValidData() {

        String[] validData = {"P1", "5", "10.0", "true", "comment"};

        ProductConverter productConverter = new ProductConverter();

        Product product = productConverter.convert(validData);

        assertEquals("P1", product.getProductId());
        assertEquals(5, product.getQuantity());
        assertEquals(10.0, product.getUnitaryPrice(), 0.01);
        assertTrue(product.isDiscounted());
    }

    @Test
    public void testConvertInvalidData() {

        String[] invalidData = {"P1", "5", "10.0", "true"};

        ProductConverter productConverter = new ProductConverter();

        assertThrows(IllegalArgumentException.class, () -> {
            productConverter.convert(invalidData);
        });
    }
}
