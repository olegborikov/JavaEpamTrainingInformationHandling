package com.borikov.task3.parser.impl;

import com.borikov.task3.parser.AbstractParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceParser extends AbstractParser {
    private AbstractParser parser = new WordParser();
    private static final String SENTENCE_DELIMITER = "\\s";

    @Override
    public List<String> parse(List<String> text) {
        List<String> textParsed = new ArrayList<>();
        for (String sentence : text) {
            String[] words = sentence.split(SENTENCE_DELIMITER);
            textParsed.addAll(Arrays.asList(words));
        }
        return parser.parse(textParsed);
    }
}
