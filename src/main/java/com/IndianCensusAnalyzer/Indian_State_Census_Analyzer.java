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
            if (csvfilepath.contains("txt")) {
                throw new CensusException("File must be in CSV Format", CensusException.ExceptionTypes.CENSUS_WRONG_FORMAT);
            }
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
        }catch (RuntimeException e) {
                throw new CensusException("Delimiter must be a comma in csv file or Header is incorrect", CensusException.ExceptionTypes.CENSUS_WRONG_DELIMITER_OR_HEADER_INCORRECT);
        }
        return 0;
    }


    public static int load_code_data(String csvfilepath) throws CensusException {
        Reader reader = null;
        try {
            if (csvfilepath.contains("txt")) {
                throw new CensusException("File must be in CSV Format", CensusException.ExceptionTypes.CENSUS_WRONG_FORMAT);
            }
            reader = Files.newBufferedReader(Paths.get(csvfilepath));
            CsvToBean<CSV_Code_File_Format> csvToBean = new CsvToBeanBuilder<CSV_Code_File_Format>(reader)
                    .withType(CSV_Code_File_Format.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSV_Code_File_Format> iterator = csvToBean.iterator();
            int numOfEntries = 0;
            while (iterator.hasNext()) {
                numOfEntries++;
                iterator.next();
            }
            return numOfEntries;
        } catch (IOException e) {
            System.out.println(e);
        }catch (RuntimeException e) {
            throw new CensusException("Delimiter must be a comma in csv file or Header is incorrect", CensusException.ExceptionTypes.CENSUS_WRONG_DELIMITER_OR_HEADER_INCORRECT);
        }
        return 0;
    }
}
