package com.kata.marketplace.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReader {
    public CsvReader() {
    }

    public List<String[]> readCsv(String filePath, char separator, int skipLines) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new com.opencsv.CSVParserBuilder().withSeparator(separator).build())
                .withSkipLines(skipLines)
                .build()) {
            return csvReader.readAll();
        }
    }
}
