package com.IndianStateCensusAnalyzerTest;

import com.IndianCensusAnalyzer.CensusException;
import com.IndianCensusAnalyzer.Indian_State_Census_Analyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyzerTest {
    private String csv_file_path = "./src/main/resources/IndiaStateCensusData.csv";

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
            Indian_State_Census_Analyzer.load_data(csv_file_path);
        } catch (CensusException e) {
            Assert.assertEquals(e.type, CensusException.ExceptionTypes.CENSUS_FILE_INCORRECT);
            e.printStackTrace();
        }
    }
}
