package com.kata.marketplace.utils;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

public class CsvReaderTest {

    @Mock
    private CSVReaderBuilder csvReaderBuilder;

    @Mock
    private CSVReader csvReader;

    @Mock
    private CSVParser csvParser;

    private CsvReader customCsvReader;

    public CsvReaderTest() {
        MockitoAnnotations.openMocks(this);
        customCsvReader = new CsvReader();
    }

    @Test
    public void testReadCsv() throws IOException, CsvException {
        String filePath = "src/test/resources/test.csv";
        char separator = ';';
        int skipLines = 1;

        List<String[]> csvData = createMockCsvData();
        when(csvReader.readAll()).thenReturn(csvData);
        when(csvReaderBuilder.build()).thenReturn(csvReader);
        when(csvReaderBuilder.withCSVParser(csvParser)).thenReturn(csvReaderBuilder);

        List<String[]> result = customCsvReader.readCsv(filePath, separator, skipLines);

        for (int i = 0; i < csvData.size(); i++) {
            assertArrayEquals(csvData.get(i), result.get(i));
        }
    }

    private List<String[]> createMockCsvData() {
        List<String[]> csvData = new ArrayList<>();
        csvData.add(new String[]{"Value1", "Value2"});
        return csvData;
    }
}
