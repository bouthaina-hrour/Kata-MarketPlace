package com.kata.marketplace.services;

import com.kata.marketplace.model.Product;
import com.opencsv.exceptions.CsvException;
import com.kata.marketplace.utils.CsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private CsvReader csvReader;

    @Mock
    private ProductConverter converter;

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(csvReader, converter);
    }

    @Test
    public void testReadProducts() throws IOException, CsvException {

        List<String[]> csvData = new ArrayList<>();
        csvData.add(new String[]{"1", "5", "10.0", "true"});
        csvData.add(new String[]{"2", "3", "15.0", "false"});
        when(csvReader.readCsv(anyString(), eq(';'), eq(1))).thenReturn(csvData);

        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product("1", 5, 10.0, true));
        expectedProducts.add(new Product("2", 3, 15.0, false));

        when(converter.convert(any())).thenAnswer(invocation -> {
            String[] data = invocation.getArgument(0);

            return new Product(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]), Boolean.parseBoolean(data[3]));
        });

        List<Product> actualProducts = productService.readProducts("test.csv");

        verify(csvReader).readCsv("test.csv", ';', 1);
        verify(converter, times(2)).convert(any());

        assertEquals(expectedProducts, actualProducts);
    }
}
