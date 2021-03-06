package com.IndianStateCensusAnalyzerTest;

import com.IndianCensusAnalyzer.CensusException;
import com.IndianCensusAnalyzer.Indian_State_Census_Analyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.IndianCensusAnalyzer.CensusException.ExceptionTypes.CENSUS_WRONG_FORMAT;

public class CensusAnalyzerTest {

    private String csv_file_path = "./src/main/resources/IndiaStateCensusData.csv";
    private String wrong_csv_file_path = "./src/main/resources/IndiaStateCensusData.csv";
    private String incorrect_format_csv_file_path = "./src/main/resources/IndiaStateCensusData.txt";
    private String incorrect_delimiter_csv_file_path = "./src/main/resources/IndiaStateCensusDataWrongDelimiter.csv";
    private String incorrect_header_csv_file_path = "./src/main/resources/IndiaStateCensusDataWrongHeader.csv";

    private String csv_code_file_path = "./src/main/resources/IndiaStateCode.csv";
    private String wrong_csv_code_file_path = "./src/main/resources/IndiaStateCode.csv";
    private String incorrect_format_csv_code_file_path = "./src/main/resources/IndiaStateCode.txt";
    private String incorrect_delimiter_csv_code_file_path = "./src/main/resources/IndiaStateCodeWrongDelimiter.csv";
    private String incorrect_header_csv_code_file_path = "./src/main/resources/IndiaStateCodeWrongHeader.csv";

    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws CensusException {
        int count = Indian_State_Census_Analyzer.load_data(csv_file_path);
        Assert.assertEquals(29, count);
    }

    @Test
    public void givenIndianCensusWrongCSVFile_WhenLoad_ShouldReturnException() throws CensusException {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            Indian_State_Census_Analyzer.load_data(wrong_csv_file_path);
        } catch (CensusException e) {
            Assert.assertEquals(CensusException.ExceptionTypes.CENSUS_FILE_INCORRECT, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianCensusCSVFile_When_given_InCorrect_file_ShouldReturnException() {

        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            Indian_State_Census_Analyzer.load_data(incorrect_format_csv_file_path);
        } catch (CensusException e) {
            Assert.assertEquals(CENSUS_WRONG_FORMAT, e.type);
        }
    }
    @Test
    public void givenIndianCensusCSVFile_WhenWrongDelimiter_ShouldThrowException() {

        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            Indian_State_Census_Analyzer.load_data(incorrect_delimiter_csv_file_path);
        } catch (CensusException e) {
            Assert.assertEquals(CensusException.ExceptionTypes.CENSUS_WRONG_DELIMITER_OR_HEADER_INCORRECT, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianCensusCSVFile_WhenWrongHeader_ShouldThrowException() {

        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            Indian_State_Census_Analyzer.load_data(incorrect_header_csv_file_path);
        } catch (CensusException e) {
            Assert.assertEquals(CensusException.ExceptionTypes.CENSUS_WRONG_DELIMITER_OR_HEADER_INCORRECT, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianCodeCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws CensusException {
        int count = Indian_State_Census_Analyzer.load_data(csv_code_file_path);
        Assert.assertEquals(37, count);
    }

    @Test
    public void givenIndianCodeWrongCSVFile_WhenLoad_ShouldReturnException() throws CensusException {
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            Indian_State_Census_Analyzer.load_code_data(wrong_csv_code_file_path);
        } catch (CensusException e) {
            Assert.assertEquals(CensusException.ExceptionTypes.CENSUS_FILE_INCORRECT, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianCodeCSVFile_When_given_InCorrect_file_ShouldReturnException() {

        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            Indian_State_Census_Analyzer.load_code_data(incorrect_format_csv_code_file_path);
        } catch (CensusException e) {
            Assert.assertEquals(CENSUS_WRONG_FORMAT, e.type);
        }
    }
    @Test
    public void givenIndianCodeCSVFile_WhenWrongDelimiter_ShouldThrowException() {

        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            Indian_State_Census_Analyzer.load_code_data(incorrect_delimiter_csv_code_file_path);
        } catch (CensusException e) {
            Assert.assertEquals(CensusException.ExceptionTypes.CENSUS_WRONG_DELIMITER_OR_HEADER_INCORRECT, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianCodeCSVFile_WhenWrongHeader_ShouldThrowException() {

        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            Indian_State_Census_Analyzer.load_code_data(incorrect_header_csv_code_file_path);
        } catch (CensusException e) {
            Assert.assertEquals(CensusException.ExceptionTypes.CENSUS_WRONG_DELIMITER_OR_HEADER_INCORRECT, e.type);
            e.printStackTrace();
        }
    }
}
