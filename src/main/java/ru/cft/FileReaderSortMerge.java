package ru.cft;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static ru.cft.Constants.*;

public class FileReaderSortMerge extends FileReaderSort<String> {

    @Override
    public void sortByAsc(String outputFile, List<String> inputFiles) {
        FileReaderSort<String> fileReaderSort = new FileReaderSortMerge();
        fileReaderSort.write(PATHNAME + outputFile, inputFiles);
        LOG.info("Sort by ASC");
    }

    @Override
    public void sortByDesc(String outputFile, List<String> inputFiles) {
        asc = false;
        FileReaderSort<String> fileReaderSort = new FileReaderSortMerge();
        fileReaderSort.write(PATHNAME + outputFile, inputFiles);
        LOG.info("Sort by DESC");
    }

    protected void doRead(String fileName, List<String> list) {
        readFile(fileName, list);
    }

    @Override
    protected void doReadFile(String s, List<String> strings) {
        if (s.isEmpty() || s.matches("[^A-Za-z]")) {
            LOG.warning(ARGUMENT_STRING + " " + s);
            JOptionPane.showMessageDialog(null, ARGUMENT_STRING, "Dialog",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            strings.add(s);
        }
    }

    @Override
    protected String[] doSort(List<String> fileNames) {
        String[] arrayTobeSort = super.sort(fileNames);
        MergeSort.mergeSort(arrayTobeSort, 0, arrayTobeSort.length - 1);
        return arrayTobeSort;
    }

    @Override
    public void write(String outputFileName, List<String> inputFiles) {
        String[] sortWords = doSort(inputFiles);
        List<String> lines = Arrays.asList(sortWords);
        Path file = Paths.get(outputFileName);
        try {
            Files.write(file, lines, StandardCharsets.UTF_8);
            LOG.info("Data written successfully");
        } catch (IOException e) {
            LOG.warning(FILE_NOT_EXIST);
            JOptionPane.showMessageDialog(null, FILE_NOT_EXIST, "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
