package org.jpr.poker.card;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prabeenjayaraj
 * <p>
 * Class to help in the reading of the given card hand list
 * in the file
 */
public class CardHandFileReader {

    public List<String> cardHandFileReader(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new IOException("Unable to Find the Input File, Pls Pass the correct File Path");
        }

        return toUpperCase(cardHandFileReader(file));
    }

    private List<String> toUpperCase(List<String> cardHandStrList) {
        return cardHandStrList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    private List<String> cardHandFileReader(File file) throws IOException {
        return FileUtils.readLines(file, "UTF-8");
    }

}
