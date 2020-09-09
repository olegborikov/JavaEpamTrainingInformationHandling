package com.borikov.task3.main;

import com.borikov.task3.composite.SymbolType;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.SymbolLeaf;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.exception.IncorrectDataException;
import com.borikov.task3.service.TextService;
import com.borikov.task3.service.impl.TextServiceImpl;

public class Main {
    public static void main(String[] args) throws IncorrectDataException {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('H', SymbolType.LETTER);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e', SymbolType.LETTER);
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf4 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf5 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf6 = new SymbolLeaf(',', SymbolType.PUNCTUATION);
        textComponent1.add(symbolLeaf1);
        textComponent1.add(symbolLeaf2);
        textComponent1.add(symbolLeaf3);
        textComponent1.add(symbolLeaf4);
        textComponent1.add(symbolLeaf5);
        textComponent1.add(symbolLeaf6);
        TextComponent textComponent2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('a', SymbolType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('d', SymbolType.LETTER);
        SymbolLeaf symbolLeaf12 = new SymbolLeaf('.', SymbolType.PUNCTUATION);
        textComponent2.add(symbolLeaf7);
        textComponent2.add(symbolLeaf8);
        textComponent2.add(symbolLeaf9);
        textComponent2.add(symbolLeaf10);
        textComponent2.add(symbolLeaf11);
        textComponent2.add(symbolLeaf12);
        TextComponent textComponent3 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf13 = new SymbolLeaf('w', SymbolType.LETTER);
        SymbolLeaf symbolLeaf14 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf15 = new SymbolLeaf('r', SymbolType.LETTER);
        SymbolLeaf symbolLeaf16 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf17 = new SymbolLeaf('d', SymbolType.LETTER);
        textComponent3.add(symbolLeaf13);
        textComponent3.add(symbolLeaf14);
        textComponent3.add(symbolLeaf15);
        textComponent3.add(symbolLeaf16);
        textComponent3.add(symbolLeaf17);
        TextComponent expected = new TextComposite(TextComponentType.SENTENCE);
        expected.add(textComponent1);
        expected.add(textComponent2);
        expected.add(textComponent3);
        TextService textService = new TextServiceImpl();
        System.out.println(textService.sortLexemesByEntryOfSymbol(expected, 'l'));
    }
}
