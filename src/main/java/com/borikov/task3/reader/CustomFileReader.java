package com.borikov.task3.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String TEXT_DELIMITER = "\n";

    public String readText(String fileName) {
        Path path = Paths.get(fileName);
        try (Stream<String> linedTextStream = Files.lines(path)) {
            String text = linedTextStream.collect(Collectors.joining(TEXT_DELIMITER));
            return text;
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "File is not exists", e);
            throw new RuntimeException("File is not exists", e);
        }
    }
}
