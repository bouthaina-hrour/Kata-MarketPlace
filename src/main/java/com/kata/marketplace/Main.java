package com.kata.marketplace;


import com.kata.marketplace.calculator.VendorIncomeCalculator;
import com.kata.marketplace.model.Product;
import com.kata.marketplace.model.Vendor;
import com.kata.marketplace.services.ProductConverter;
import com.kata.marketplace.services.ProductService;
import com.kata.marketplace.services.VendorConverter;
import com.kata.marketplace.services.VendorService;
import com.kata.marketplace.utils.CsvReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String productSoldFilePath = "src/main/resources/product-sold.csv";
        String productVendorFilePath = "src/main/resources/product-vendor.csv";
        CsvReader csvReader = new CsvReader();

        ProductConverter productConverter = new ProductConverter();
        VendorConverter vendorConverter = new VendorConverter();

        ProductService productService = new ProductService(csvReader, productConverter);
        VendorService vendorService = new VendorService(csvReader, vendorConverter);
        try {
            List<Product> productSoldData = productService.readProducts(productSoldFilePath);
            List<Vendor> productVendorData = vendorService.readVendors(productVendorFilePath);

            VendorIncomeCalculator vendorIncomeCalculator = new VendorIncomeCalculator(productSoldData, productVendorData);

            double totalIncome = vendorIncomeCalculator.calculateGlobalIncome();

            System.out.println("Total Global Income: $" + totalIncome);

        } catch (IOException | CsvException e) {
            e.printStackTrace();

        }


    }
}
