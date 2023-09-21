package org.vendorIncome;


import java.util.List;

import static org.vendorIncome.CsvFileReaderUtils.loadDataFromFile;


public class Main {
    public static void main(String[] args) {
        String productSoldFilePath = "src/main/resources/product-sold.csv";
        String productVendorFilePath = "src/main/resources/product-vendor.csv";

        List<String[]> productSoldData =loadDataFromFile(productSoldFilePath);

        List<String[]> productVendorData = loadDataFromFile(productVendorFilePath);
        VendorIncomeCalculator vendorIncomeCalculator = new VendorIncomeCalculator(productSoldData,productVendorData);

        double totalIncome = vendorIncomeCalculator.calculateGlobalIncome();

        System.out.println("Total Global Income: $" + totalIncome);

    }
}
