package com.kata.marketplace.services;

import com.kata.marketplace.model.Vendor;
import com.kata.marketplace.utils.CsvReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class VendorServiceTest {
    @Mock
    private CsvReader csvReader;

    @Mock
    private VendorConverter converter;

    private VendorService vendorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        vendorService = new VendorService(csvReader, converter);
    }

    @Test
    public void testReadVendors() throws IOException, CsvException {
        // Mock CSV data and conversion
        List<String[]> csvData = new ArrayList<>();
        csvData.add(new String[]{"V1", "Vendor1"});
        csvData.add(new String[]{"V2", "Vendor2"});
        when(csvReader.readCsv(anyString(), eq(';'), eq(1))).thenReturn(csvData);

        List<Vendor> expectedVendors = new ArrayList<>();
        expectedVendors.add(new Vendor("V1", "Vendor1"));
        expectedVendors.add(new Vendor("V2", "Vendor2"));

        when(converter.convert(any())).thenAnswer(invocation -> {
            String[] data = invocation.getArgument(0);

            return new Vendor(data[0], data[1]);
        });

        List<Vendor> actualVendors = vendorService.readVendors("vendors.csv");

        verify(csvReader).readCsv("vendors.csv", ';', 1);
        verify(converter, times(2)).convert(any());

        assertEquals(expectedVendors, actualVendors);
    }
}
