package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.Component;
import com.borikov.task3.composite.impl.Composite;
import com.borikov.task3.composite.impl.CompositeType;
import com.borikov.task3.parser.AbstractParser;

import java.util.ArrayList;
import java.util.List;

public class TextParser extends AbstractParser {
    private final AbstractParser parser = new ParagraphParser();
    private static final String PARAGRAPH_DELIMITER = "\n";

    @Override
    public List<Component> parse(String text) {
        List<Component> paragraphs = new ArrayList<>();
        String[] textParagraphs = text.split(PARAGRAPH_DELIMITER);
        for (String textParagraph : textParagraphs) {
            List<Component> sentences = parser.parse(textParagraph);
            Composite paragraph = new Composite(CompositeType.PARAGRAPH);
            for (Component sentence : sentences) {
                paragraph.add(sentence);
            }
            paragraphs.add(paragraph);
        }
        return paragraphs;
    }
}
