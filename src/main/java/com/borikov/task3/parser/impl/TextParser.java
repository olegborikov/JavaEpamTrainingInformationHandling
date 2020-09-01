package com.borikov.task3.parser.impl;

import com.borikov.task3.parser.AbstractParser;

import java.util.List;

public class TextParser extends AbstractParser {
    private AbstractParser parser = new SentenceParser();

    @Override
    public List<String> parse() {
        return parser.parse();
    }
}
