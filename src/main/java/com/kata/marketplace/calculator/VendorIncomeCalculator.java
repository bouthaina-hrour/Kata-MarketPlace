package com.kata.marketplace.calculator;

import com.kata.marketplace.model.Product;
import com.kata.marketplace.model.Vendor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendorIncomeCalculator {

    List<Product> productSoldData;
    List<Vendor> productVendorData;

    public VendorIncomeCalculator(List<Product> productSoldData, List<Vendor> productVendorData) {
        this.productSoldData = productSoldData;
        this.productVendorData = productVendorData;
    }

    public double calculateGlobalIncome() {
        double totalIncome = 0.0;

        Map<String, Vendor> vendorMap = new HashMap<>();
        for (Vendor vendor : productVendorData) {
            vendorMap.put(vendor.getVendorProductId(), vendor);
        }

        for (Product productSold : productSoldData) {
            String productId = productSold.getProductId();
            int quantity = productSold.getQuantity();
            double unitaryPrice = productSold.getUnitaryPrice();
            boolean isDiscounted = productSold.isDiscounted();

            Vendor vendor = vendorMap.get(productId);

            if (vendor != null && !vendor.isInterne()) {
                double operationAmount = quantity * unitaryPrice;
                double income = isDiscounted ? (0.02 * operationAmount) : (0.05 * operationAmount);
                totalIncome += income;
            }
        }


        return totalIncome;
    }


}
