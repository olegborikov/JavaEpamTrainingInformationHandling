package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.SymbolLeafType;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.SymbolLeaf;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.interpreter.LexemeInterpreter;
import com.borikov.task3.parser.BaseParser;

public class LexemeParser implements BaseParser {
    private static final LexemeParser INSTANCE = new LexemeParser();
    private static final String PUNCTUATION_REGEX = "\\p{Punct}";
    private final LexemeInterpreter lexemeInterpreter = new LexemeInterpreter();

    private LexemeParser() {
    }

    public static LexemeParser getInstance() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String lexeme) {
        TextComponent sentenceComponent = new TextComposite(TextComponentType.LEXEME);
        String expressionSolution = lexemeInterpreter.interpretLexeme(lexeme);
        char[] symbols = expressionSolution.toCharArray();
        for (char symbol : symbols) {
            SymbolLeaf symbolLeaf;
            if (String.valueOf(symbol).matches(PUNCTUATION_REGEX)) {
                symbolLeaf = new SymbolLeaf(symbol, SymbolLeafType.PUNCTUATION);
            } else {
                symbolLeaf = new SymbolLeaf(symbol, SymbolLeafType.LETTER);
            }
            sentenceComponent.add(symbolLeaf);
        }
        return sentenceComponent;
    }
}
