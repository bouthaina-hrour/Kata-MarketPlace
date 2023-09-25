package com.kata.marketplace.services;

import com.kata.marketplace.model.Vendor;

public class VendorConverter {
    public Vendor convert(String[] data) {
        if (data.length < 2) {
            throw new IllegalArgumentException("Invalid data array for Vendor conversion.");
        }

        Vendor vendor = new Vendor();
        vendor.setVendorProductId(data[0]);
        vendor.setVendorName(data[1]);

        return vendor;
    }
}
