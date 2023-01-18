package ru.cft;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static ru.cft.Constants.*;

public abstract class FileReaderSort<SK> implements Sort {

    protected abstract void doRead(String fileName, List<SK> list);

    protected abstract SK[] doSort(List<String> list);

    protected abstract void doReadFile(String s, List<SK> list);

    protected void readFile(String fileName, List<SK> strings) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName), UTF_8);
            lines.forEach(s -> doReadFile(s, strings));
            LOG.info("Data read successfully");
        } catch (IOException e) {
            LOG.warning("File " + fileName + " not exist");
            JOptionPane.showMessageDialog(null, FILE_NOT_EXIST, "Dialog",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<SK> read(List<String> fileNames) {
        List<SK> numberList = new ArrayList<>();
        for (String fileName : fileNames) {
            doRead(PATHNAME + fileName, numberList);
        }
        return numberList;
    }

    public SK[] sort(List<String> inputFiles) {
        List<SK> list = read(inputFiles);
        return (SK[]) list.toArray(new String[0]);
    }
}
