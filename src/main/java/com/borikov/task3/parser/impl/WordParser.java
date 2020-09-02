package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.Component;
import com.borikov.task3.composite.impl.Leaf;
import com.borikov.task3.composite.impl.SymbolType;
import com.borikov.task3.parser.AbstractParser;

import java.util.ArrayList;
import java.util.List;

public class WordParser extends AbstractParser {
    @Override
    public List<Component> parse(String word) {
        List<Component> symbols = new ArrayList<>();
        char[] wordSymbols = word.toCharArray();
        for (char wordSymbol : wordSymbols) {
            Leaf leaf = new Leaf(wordSymbol, SymbolType.LETTER);
            symbols.add(leaf);
        }
        return symbols;
    }
}
