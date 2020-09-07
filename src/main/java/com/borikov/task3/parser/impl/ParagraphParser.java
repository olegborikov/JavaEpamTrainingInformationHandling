package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.parser.AbstractParser;

public class ParagraphParser extends AbstractParser {
    private final AbstractParser parser = new SentenceParser();
    private static final String PARAGRAPH_DELIMITER = "(?<=\\.)\\s|(?<=\\?)\\s|(?<=!)\\s|(?<=\\.{3})\\s+";

    @Override
    public TextComponent parse(String paragraph) {
        TextComponent paragraphComponent = new TextComposite(TextComponentType.PARAGRAPH);
        String[] sentences = paragraph.split(PARAGRAPH_DELIMITER);
        for (String sentence : sentences) {
            TextComponent sentenceComponent = parser.parse(sentence);
            paragraphComponent.add(sentenceComponent);
        }
        return paragraphComponent;
    }
}
