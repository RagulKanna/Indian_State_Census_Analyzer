package com.IndianCensusAnalyzer;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class Indian_State_Census_Analyzer {
    public static int load_data(String csvfilepath) throws CensusException {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(csvfilepath));
            CsvToBean<CSV_File_Format> csvToBean = new CsvToBeanBuilder<CSV_File_Format>(reader)
                    .withType(CSV_File_Format.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSV_File_Format> iterator = csvToBean.iterator();
            int numOfEntries = 0;
            while (iterator.hasNext()) {
                numOfEntries++;
                iterator.next();
            }
            return numOfEntries;
        } catch (IOException e) {
            System.out.println(e);
        }
        return 0;
    }
}
