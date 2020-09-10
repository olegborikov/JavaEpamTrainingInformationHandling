package com.borikov.task3.comparator;

import com.borikov.task3.composite.SymbolType;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.SymbolLeaf;
import com.borikov.task3.composite.impl.TextComposite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LexemeSymbolEntranceComparatorTest {
    @DataProvider(name = "comparePositiveData")
    public Object[][] createComparePositiveData() {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('h', SymbolType.LETTER);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e', SymbolType.LETTER);
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf4 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf5 = new SymbolLeaf('o', SymbolType.LETTER);
        textComponent1.add(symbolLeaf1);
        textComponent1.add(symbolLeaf2);
        textComponent1.add(symbolLeaf3);
        textComponent1.add(symbolLeaf4);
        textComponent1.add(symbolLeaf5);
        TextComponent textComponent2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf6 = new SymbolLeaf('h', SymbolType.LETTER);
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('h', SymbolType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('0', SymbolType.LETTER);
        textComponent2.add(symbolLeaf6);
        textComponent2.add(symbolLeaf7);
        textComponent2.add(symbolLeaf8);
        TextComponent textComponent3 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('A', SymbolType.LETTER);
        textComponent3.add(symbolLeaf9);
        TextComponent textComponent4 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf(',', SymbolType.PUNCTUATION);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf(',', SymbolType.PUNCTUATION);
        textComponent4.add(symbolLeaf10);
        textComponent4.add(symbolLeaf11);
        return new Object[][]{
                {textComponent1, textComponent1, 'h', 0},
                {textComponent1, textComponent1, 'z', 0},
                {textComponent1, textComponent2, 'h', -1},
                {textComponent1, textComponent3, 'h', 1},
                {textComponent1, textComponent4, ',', -1},
        };
    }

    @Test(dataProvider = "comparePositiveData")
    public void comparePositiveTest(
            TextComponent textComponent1, TextComponent textComponent2, char symbol, int expected) {
        LexemeSymbolEntranceComparator lexemeSymbolEntranceComparator = new LexemeSymbolEntranceComparator(symbol);
        int actual = lexemeSymbolEntranceComparator.compare(textComponent1, textComponent2);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "compareNegativeData")
    public Object[][] createCompareNegativeData() {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('h', SymbolType.LETTER);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e', SymbolType.LETTER);
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf4 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf5 = new SymbolLeaf('o', SymbolType.LETTER);
        textComponent1.add(symbolLeaf1);
        textComponent1.add(symbolLeaf2);
        textComponent1.add(symbolLeaf3);
        textComponent1.add(symbolLeaf4);
        textComponent1.add(symbolLeaf5);
        TextComponent textComponent2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf6 = new SymbolLeaf('h', SymbolType.LETTER);
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('h', SymbolType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('0', SymbolType.LETTER);
        textComponent2.add(symbolLeaf6);
        textComponent2.add(symbolLeaf7);
        textComponent2.add(symbolLeaf8);
        TextComponent textComponent3 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('A', SymbolType.LETTER);
        textComponent3.add(symbolLeaf9);
        TextComponent textComponent4 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf(',', SymbolType.PUNCTUATION);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf(',', SymbolType.PUNCTUATION);
        textComponent4.add(symbolLeaf10);
        textComponent4.add(symbolLeaf11);
        return new Object[][]{
                {textComponent1, textComponent1, 'h', 1},
                {textComponent1, textComponent2, 'h', 1},
                {textComponent1, textComponent3, 'h', 0},
                {textComponent1, textComponent4, ',', 1},
        };
    }

    @Test(dataProvider = "compareNegativeData")
    public void compareNegativeTest(
            TextComponent textComponent1, TextComponent textComponent2, char symbol, int expected) {
        LexemeSymbolEntranceComparator lexemeSymbolEntranceComparator = new LexemeSymbolEntranceComparator(symbol);
        int actual = lexemeSymbolEntranceComparator.compare(textComponent1, textComponent2);
        assertNotEquals(actual, expected);
    }
}