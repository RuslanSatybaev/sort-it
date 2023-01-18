package ru.cft;

import java.util.List;

public interface Sort {
    void sortByAsc(String outputFile, List<String> inputFiles);

    void sortByDesc(String outputFile, List<String> inputFiles);

    List<?> read(List<String> fileNames);

    void write(String outputFileName, List<String> list);
}
