package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.parser.AbstractParser;

public class SentenceParser extends AbstractParser {
    private final AbstractParser parser = new LexemeParser();
    private static final String SENTENCE_DELIMITER = "\\s";

    @Override
    public TextComponent parse(String sentence) {
        TextComponent sentenceComponent = new TextComposite(TextComponentType.SENTENCE);
        String[] lexemes = sentence.split(SENTENCE_DELIMITER);
        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = parser.parse(lexeme);
            sentenceComponent.add(lexemeComponent);
        }
        return sentenceComponent;
    }
}
