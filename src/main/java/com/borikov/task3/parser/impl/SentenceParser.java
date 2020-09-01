package com.borikov.task3.parser.impl;

import com.borikov.task3.parser.AbstractParser;

import java.util.List;

public class SentenceParser extends AbstractParser {
    private AbstractParser parser = new WordParser();

    @Override
    public List<String> parse() {
        return parser.parse();
    }
}
