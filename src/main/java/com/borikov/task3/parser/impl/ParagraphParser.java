package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.Component;
import com.borikov.task3.composite.impl.Composite;
import com.borikov.task3.composite.impl.CompositeType;
import com.borikov.task3.parser.AbstractParser;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser extends AbstractParser {
    private final AbstractParser parser = new SentenceParser();
    private static final String PARAGRAPH_DELIMITER = "!|\\?|\\.|\\.\\.\\.";

    @Override
    public List<Component> parse(String paragraph) {
        List<Component> sentences = new ArrayList<>();
        String[] paragraphSentences = paragraph.split(PARAGRAPH_DELIMITER);
        for (String paragraphSentence : paragraphSentences) {
            List<Component> words = parser.parse(paragraphSentence);
            Composite sentence = new Composite(CompositeType.SENTENCE);
            for (Component word : words) {
                sentence.add(word);
            }
            sentences.add(sentence);
        }
        return sentences;
    }
}
