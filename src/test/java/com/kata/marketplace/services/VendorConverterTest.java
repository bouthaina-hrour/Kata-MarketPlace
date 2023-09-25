package com.kata.marketplace.services;

import com.kata.marketplace.model.Vendor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VendorConverterTest {
    @Test
    public void testConvertValidData() {
        String[] validData = {"V1", "Vendor1"};

        VendorConverter vendorConverter = new VendorConverter();

        Vendor vendor = vendorConverter.convert(validData);

        assertEquals("V1", vendor.getVendorProductId());
        assertEquals("Vendor1", vendor.getVendorName());
    }

    @Test
    public void testConvertInvalidData() {
        String[] invalidData = {"V1"};

        VendorConverter vendorConverter = new VendorConverter();

        assertThrows(IllegalArgumentException.class, () -> {
            vendorConverter.convert(invalidData);
        });
    }
}
