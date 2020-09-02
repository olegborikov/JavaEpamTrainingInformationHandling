package com.borikov.task3.parser.impl;

import com.borikov.task3.parser.AbstractParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextParser extends AbstractParser {
    private AbstractParser parser = new SentenceParser();
    private static final String TEXT_DELIMITER = "!|\\?|\\.|\\.\\.\\.";

    @Override
    public List<String> parse(List<String> text) {
        List<String> textParsed = new ArrayList<>();
        for (String paragraph : text) {
            String[] sentences = paragraph.split(TEXT_DELIMITER);
            textParsed.addAll(Arrays.asList(sentences));
        }
        return parser.parse(textParsed);
    }
}
