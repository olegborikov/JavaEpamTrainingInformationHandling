package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.interpreter.LexemeInterpreter;
import com.borikov.task3.parser.BaseParser;

public class SentenceParser implements BaseParser {
    private final BaseParser parser = new LexemeParser();
    private final LexemeInterpreter interpreter = new LexemeInterpreter();
    private static final String SENTENCE_DELIMITER = "\\s+";

    @Override
    public TextComponent parse(String sentence) {
        TextComponent sentenceComponent = new TextComposite(TextComponentType.SENTENCE);
        String[] lexemes = sentence.split(SENTENCE_DELIMITER);
        for (String lexeme : lexemes) {
            String expressionSolution = interpreter.interpretLexeme(lexeme);
            TextComponent lexemeComponent = parser.parse(expressionSolution);
            sentenceComponent.add(lexemeComponent);
        }
        return sentenceComponent;
    }
}
