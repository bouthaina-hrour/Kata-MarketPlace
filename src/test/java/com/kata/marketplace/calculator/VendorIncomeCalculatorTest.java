package com.kata.marketplace.calculator;

import com.kata.marketplace.model.Product;
import com.kata.marketplace.model.Vendor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorIncomeCalculatorTest {
    private List<Product> productSoldData;
    private List<Vendor> productVendorData;

    @BeforeEach
    public void setUp() {

        productSoldData = new ArrayList<>();
        productVendorData = new ArrayList<>();
    }

    @Test
    public void testCalculateGlobalIncomeWithDiscountedProducts() {

        productSoldData.add(new Product("P1", 5, 10.0, true));
        productSoldData.add(new Product("P2", 3, 15.0, true));
        productVendorData.add(new Vendor("P1", "Vendor1"));
        productVendorData.add(new Vendor("P2", "Vendor2"));

        VendorIncomeCalculator calculator = new VendorIncomeCalculator(productSoldData, productVendorData);

        double totalIncome = calculator.calculateGlobalIncome();

        assertEquals(1.9, totalIncome);
    }

    @Test
    public void testCalculateGlobalIncomeWithoutDiscount() {

        productSoldData.add(new Product("P1", 5, 10.0, false));
        productSoldData.add(new Product("P2", 3, 15.0, false));
        productVendorData.add(new Vendor("P1", "Vendor1"));
        productVendorData.add(new Vendor("P2", "Vendor2"));

        VendorIncomeCalculator calculator = new VendorIncomeCalculator(productSoldData, productVendorData);

        double totalIncome = calculator.calculateGlobalIncome();

        assertEquals(4.75, totalIncome);
    }
    @Test
    public void testCalculateGlobalIncomeWithAndWithoutDiscount() {

        productSoldData.add(new Product("P1", 5, 10.0, false));
        productSoldData.add(new Product("P2", 3, 15.0, true));
        productVendorData.add(new Vendor("P1", "Vendor1"));
        productVendorData.add(new Vendor("P2", "Vendor2"));

        VendorIncomeCalculator calculator = new VendorIncomeCalculator(productSoldData, productVendorData);

        double totalIncome = calculator.calculateGlobalIncome();

        assertEquals(3.4, totalIncome);
    }
    @Test
    public void testCalculateGlobalIncomeUsingInterneAndExterneVendors() {

        productSoldData.add(new Product("P1", 5, 10.0, false));
        productSoldData.add(new Product("P2", 3, 15.0, true));
        productVendorData.add(new Vendor("P1", "Vendor1"));
        productVendorData.add(new Vendor("P2", "CB"));

        VendorIncomeCalculator calculator = new VendorIncomeCalculator(productSoldData, productVendorData);

        double totalIncome = calculator.calculateGlobalIncome();

        assertEquals(2.5, totalIncome);
    }
}
