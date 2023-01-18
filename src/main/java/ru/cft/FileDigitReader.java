package ru.cft;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static ru.cft.Constants.*;

public class FileDigitReader extends FileReaderSort<Integer> {

    @Override
    public void sortByAsc(String outputFile, List<String> inputFiles) {
        FileReaderSort<Integer> fileReaderSort = new FileDigitReader();
        fileReaderSort.
                write(PATHNAME + outputFile, inputFiles);
        LOG.info("Sort by ASC");
    }

    @Override
    public void sortByDesc(String outputFile, List<String> inputFiles) {
        asc = false;
        FileReaderSort<Integer> fileReaderSort = new FileDigitReader();
        fileReaderSort.
                write(PATHNAME + outputFile, inputFiles);
        LOG.info("Sort by DESC");
    }

    @Override
    protected void doRead(String fileName, List<Integer> list) {
        readFile(fileName, list);
    }

    @Override
    protected void doReadFile(String s, List<Integer> numberList) {
        if (s.isEmpty() || !s.matches("-?\\d+(\\.\\d+)?")) {
            LOG.warning(ARGUMENT_DIGIT + " " + s);
            JOptionPane.showMessageDialog(null, ARGUMENT_DIGIT, "Dialog",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            int number = Integer.parseInt(s);
            numberList.add(number);
        }
    }

    @Override
    protected Integer[] doSort(List<String> fileNames) {
        return null;
    }

    private int[] sortIn(List<String> inputFiles) {
        List<Integer> list = read(inputFiles);
        int[] arrayTobeSort = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arrayTobeSort[i] = list.get(i);
        }
        MergeSortDigit.mergeSort(arrayTobeSort, arrayTobeSort.length);
        return arrayTobeSort;
    }

    @Override
    public void write(String outputFileName, List<String> inputFiles) {
        int[] ints = sortIn(inputFiles);
        try (PrintWriter writer = new PrintWriter(outputFileName, UTF_8)) {
            for (int anInt : ints) {
                writer.println(anInt);
            }
            LOG.info("Data written successfully");
        } catch (IOException e) {
            LOG.warning(FILE_NOT_EXIST);
            JOptionPane.showMessageDialog(null, FILE_NOT_EXIST, "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
