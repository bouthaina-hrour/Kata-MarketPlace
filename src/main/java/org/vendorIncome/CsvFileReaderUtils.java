package org.vendorIncome;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvFileReaderUtils  {
    public static List<String[]> loadDataFromFile(String FilePath) {
        CSVReader csvReader = null;
        List<String[]> data = null;
        try {
            csvReader = new CSVReaderBuilder(new FileReader(FilePath))
                    .withCSVParser(new com.opencsv.CSVParserBuilder().withSeparator(';').build())
                    .withSkipLines(1)
                    .build();
            data = csvReader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

}
