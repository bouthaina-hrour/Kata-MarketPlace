package com.kata.marketplace.services;

import com.kata.marketplace.model.Vendor;
import com.kata.marketplace.utils.CsvReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VendorService {
    private final CsvReader csvReader;
    private final VendorConverter converter;

    public VendorService(CsvReader csvReader, VendorConverter converter) {
        this.csvReader = csvReader;
        this.converter = converter;
    }

    public List<Vendor> readVendors(String filePath) throws IOException, CsvException {
        List<String[]> vendorData = csvReader.readCsv(filePath, ';', 1);
        List<Vendor> vendors = new ArrayList<>();
        for (String[] data : vendorData) {
            Vendor vendor = converter.convert(data);
            vendors.add(vendor);
        }
        return vendors;
    }
}
