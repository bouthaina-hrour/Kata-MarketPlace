package org.vendorIncome;

import java.util.List;

public class VendorIncomeCalculator {

    List<String[]> productSoldData;
    List<String[]> productVendorData;

    public VendorIncomeCalculator(List<String[]> productSoldData, List<String[]> productVendorData) {
        this.productSoldData = productSoldData;
        this.productVendorData = productVendorData;
    }


    public double calculateGlobalIncome() {
        double totalIncome = 0.0;

        int productIdIndex = 0;
        int quantityIndex = 1;
        int unitaryPriceIndex = 2;
        int isDiscountIndex = 3;

        for (String[] productSoldRow : productSoldData) {
            String productId = productSoldRow[productIdIndex];
            int quantity = Integer.parseInt(productSoldRow[quantityIndex]);
            double unitaryPrice = Double.parseDouble(productSoldRow[unitaryPriceIndex]);
            boolean isDiscounted = Boolean.parseBoolean(productSoldRow[isDiscountIndex]);

            for (String[] productVendorRow : productVendorData) {

                String vendorProductId = productVendorRow[0];
                String vendorName = productVendorRow[1];

                if (productId.equals(vendorProductId) && isExterne(vendorName)) {
                    double operationAmount = quantity * unitaryPrice;
                    double income = isDiscounted ? (0.02 * operationAmount) : (0.05 * operationAmount);
                    totalIncome += income;
                    break;
                }

            }
        }
        return totalIncome;
    }

    public boolean isExterne(String vendorName) {
        for (ExterneVendors vendor : ExterneVendors.values()) {
            if (vendor.name().equals(vendorName)) {
                return true;
            }
        }
        return false;
    }


}
