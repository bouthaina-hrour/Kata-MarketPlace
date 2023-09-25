package com.kata.marketplace.model;

import com.kata.marketplace.enums.InterneVendors;

public class Vendor {
    private String vendorProductId;
    private String vendorName;

    public Vendor() {

    }

    public Vendor(String vendorProductId, String vendorName) {
        this.vendorProductId=vendorProductId;
        this.vendorName=vendorName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorProductId() {
        return vendorProductId;
    }

    public void setVendorProductId(String vendorProductId) {
        this.vendorProductId = vendorProductId;
    }
    public boolean isInterne() {
        for (InterneVendors vendor : InterneVendors.values()) {
            if (vendor.name().equals(vendorName)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vendor vendor = (Vendor) o;

        if (vendorProductId != null ? !vendorProductId.equals(vendor.vendorProductId) : vendor.vendorProductId != null) return false;
        return vendorName != null ? vendorName.equals(vendor.vendorName) : vendor.vendorName == null;
    }
}
