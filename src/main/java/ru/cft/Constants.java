package ru.cft;

import java.util.logging.Logger;

public class Constants {

    public static final Logger LOG = Logger.getLogger(FileReaderSortMerge.class.getName());
    public static final String PATHNAME = "C:/java_test/";
    public static final String MESSAGE_ARGUMENTS = "Argument must be i for digit, " +
            "s for ascending strings, d for descending strings";
    public static final String FILE_NOT_EXIST = "File not exist";
    public static final String ARGUMENT_DIGIT = "The argument must be a number, not a string or symbol";
    public static final String ARGUMENT_STRING = "The argument must be a string, not a digit";

    public static boolean asc = true;

    private Constants() {
    }
}
