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
    private String incorrect_csv_file_path = "./src/main/resources/IndiaStateCensusData.txt";

    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws CensusException {
        Indian_State_Census_Analyzer analyzer = new Indian_State_Census_Analyzer();
        int count = Indian_State_Census_Analyzer.load_data(csv_file_path);
        Assert.assertEquals(29, count);
    }

    @Test
    public void givenIndianCensusWrongCSVFile_WhenLoad_ShouldReturnException() throws CensusException{
        try {
            Indian_State_Census_Analyzer analyzer = new Indian_State_Census_Analyzer();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            Indian_State_Census_Analyzer.load_data(wrong_csv_file_path);
        } catch (CensusException e) {
            Assert.assertEquals(CensusException.ExceptionTypes.CENSUS_FILE_INCORRECT,e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianCensusCSVFile_When_given_InCorrect_file_ShouldReturnException() {

        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusException.class);
            Indian_State_Census_Analyzer.load_data(incorrect_csv_file_path);
        } catch (CensusException e) {
            Assert.assertEquals(CENSUS_WRONG_FORMAT, e.type);
        }
    }
}
