package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.SymbolType;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.SymbolLeaf;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.parser.BaseParser;

public class LexemeParser implements BaseParser {
    private static final String PUNCTUATION = "\\p{Punct}";

    @Override
    public TextComponent parse(String lexeme) {
        TextComponent sentenceComponent = new TextComposite(TextComponentType.LEXEME);
        char[] symbols = lexeme.toCharArray();
        for (char symbol : symbols) {
            SymbolLeaf symbolLeaf;
            if (String.valueOf(symbol).matches(PUNCTUATION)) {
                symbolLeaf = new SymbolLeaf(symbol, SymbolType.PUNCTUATION);
            } else {
                symbolLeaf = new SymbolLeaf(symbol, SymbolType.LETTER);
            }
            sentenceComponent.add(symbolLeaf);
        }
        return sentenceComponent;
    }
}
