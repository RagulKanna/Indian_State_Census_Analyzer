package com.IndianStateCensusAnalyzerTest;

import com.IndianCensusAnalyzer.Indian_State_Census_Analyzer;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyzerTest {
    private String csv_file_path = "./src/main/resources/IndiaStateCensusData.csv";

    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() {
        Indian_State_Census_Analyzer analyzer = new Indian_State_Census_Analyzer();
        int count = Indian_State_Census_Analyzer.load_data(csv_file_path);
        Assert.assertEquals(29,count);
    }
}
