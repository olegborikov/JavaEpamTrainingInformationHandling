package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.parser.BaseParser;

public class SentenceParser implements BaseParser {
    private static final SentenceParser INSTANCE = new SentenceParser();
    private final LexemeParser lexemeParser = LexemeParser.getInstance();
    private static final String SENTENCE_DELIMITER = "\\s+";

    private SentenceParser() {
    }

    public static SentenceParser getInstance() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String sentence) {
        TextComponent sentenceComponent = new TextComposite(TextComponentType.SENTENCE);
        String[] lexemes = sentence.split(SENTENCE_DELIMITER);
        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = lexemeParser.parse(lexeme);
            sentenceComponent.add(lexemeComponent);
        }
        return sentenceComponent;
    }
}
