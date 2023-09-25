package com.kata.marketplace.services;

import com.kata.marketplace.model.Product;
import com.kata.marketplace.utils.CsvReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final CsvReader csvReader;
    private final ProductConverter converter;

    public ProductService(CsvReader csvReader, ProductConverter converter) {
        this.csvReader = csvReader;
        this.converter = converter;
    }

    public List<Product> readProducts(String filePath) throws IOException, CsvException {
        List<String[]> productData = csvReader.readCsv(filePath, ';', 1);
        List<Product> products = new ArrayList<>();
        for (String[] data : productData) {
            Product product = converter.convert(data);
            products.add(product);
        }
        return products;
    }
}
