package ru.cft;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static ru.cft.Constants.LOG;
import static ru.cft.Constants.MESSAGE_ARGUMENTS;

public class Main {

    public static void main(String... args) {
        List<String> inputFilesList = new ArrayList<>();
        for (int i = 3; i < args.length; ) {
            inputFilesList.add(args[i++]);
        }
        selectSort(args[0], args[1], args[2], inputFilesList);
        JOptionPane.showMessageDialog(null, "Data successfully sorted and written");
    }

    private static Sort sort(String secondSymbol) {
        Sort sort = null;
        switch (secondSymbol) {
            case "-i":
                sort = new FileDigitReader();
                break;
            case "-s":
                sort = new FileReaderSortMerge();
                break;
            default:
                LOG.warning(MESSAGE_ARGUMENTS);
                JOptionPane.showMessageDialog(null, MESSAGE_ARGUMENTS, "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                break;
        }
        return sort;
    }

    private static void selectSort(String firstSymbol, String secondSymbol, String outputFile, List<String> inputFiles) {
        Sort sort = sort(secondSymbol);
        switch (firstSymbol) {
            case "-a":
                sort.sortByAsc(outputFile, inputFiles);
                break;
            case "-d":
                sort.sortByDesc(outputFile, inputFiles);
                break;
        }
    }
}
