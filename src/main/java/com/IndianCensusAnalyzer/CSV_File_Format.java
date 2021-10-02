package com.IndianCensusAnalyzer;

import com.opencsv.bean.CsvBindByName;

public class CSV_File_Format {

    @CsvBindByName(column = "State")
    public String state;

    @CsvBindByName(column = "Population")
    public String population;

    @CsvBindByName(column = "AreaInSqKm")
    public String areainsqKm;

    @CsvBindByName(column = "DensityPerSqKm")
    public String densityPersqKm;

    @Override
    public String toString() {
        return "CSV_File_Format{" +
                "state='" + state + '\'' +
                ", population='" + population + '\'' +
                ", areainsqKm='" + areainsqKm + '\'' +
                ", densityPersqKm='" + densityPersqKm + '\'' +
                '}';
    }
}
