package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.Component;
import com.borikov.task3.composite.impl.Composite;
import com.borikov.task3.composite.impl.CompositeType;
import com.borikov.task3.parser.AbstractParser;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser extends AbstractParser {
    private final AbstractParser parser = new WordParser();
    private static final String SENTENCE_DELIMITER = "\\s";

    @Override
    public List<Component> parse(String sentence){
        List<Component> words = new ArrayList<>();
        String[] sentenceWords = sentence.split(SENTENCE_DELIMITER);
        for (String sentenceWord : sentenceWords) {
            List<Component> symbols = parser.parse(sentenceWord);
            Composite word = new Composite(CompositeType.WORD);
            for (Component symbol : symbols) {
                word.add(symbol);
            }
            words.add(word);
        }
        return words;
    }
}
