package com.IndianCensusAnalyzer;

public class CensusException extends Exception {
    private static final long serialVersionUID = 1L;

    public enum ExceptionTypes {
        CENSUS_FILE_INCORRECT;
    }

    public ExceptionTypes type;

    public CensusException(String message, ExceptionTypes type) {
        super(message);
        this.type = type;
    }
}
