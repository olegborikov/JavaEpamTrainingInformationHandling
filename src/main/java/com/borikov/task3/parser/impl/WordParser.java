package com.borikov.task3.parser.impl;

import com.borikov.task3.parser.AbstractParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordParser extends AbstractParser {
    private static final String WORD_DELIMITER = ".";
    @Override
    public List<String> parse(List<String> text) {
        List<String> textParsed = new ArrayList<>();
        for (String word : text) {
            String[] letters = word.split("");
            textParsed.addAll(Arrays.asList(letters));
        }
        return textParsed;
    }
}
