package com.kata.marketplace.services;

import com.kata.marketplace.model.Product;

public class ProductConverter {
    public Product convert(String[] data) {
        if (data.length < 5) {
            return null;
        }

        Product product = new Product();
        product.setProductId(data[0]);
        product.setQuantity(Integer.parseInt(data[1]));
        product.setUnitaryPrice(Double.parseDouble(data[2]));
        product.setDiscounted(Boolean.parseBoolean(data[3]));

        return product;
    }
}
