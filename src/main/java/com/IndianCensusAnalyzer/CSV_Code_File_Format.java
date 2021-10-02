package com.IndianCensusAnalyzer;

import com.opencsv.bean.CsvBindByName;

public class CSV_Code_File_Format {

    @CsvBindByName(column = "SrNo")
    public int Serialno;
    @CsvBindByName(column = "State Name")
    public String State;
    @CsvBindByName(column = "TIN")
    public int TIN;
    @CsvBindByName(column = "StateCode")
    public String Statecode;

    @Override
    public String toString() {
        return "CSV_Code_File_Format{" +
                "Serialno=" + Serialno +
                ", State='" + State + '\'' +
                ", TIN=" + TIN +
                ", Statecode='" + Statecode + '\'' +
                '}';
    }
}
