package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.SymbolLeafType;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.SymbolLeaf;
import com.borikov.task3.composite.impl.TextComposite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LexemeParserTest {
    private LexemeParser lexemeParser;

    @BeforeClass
    public void setUp() {
        lexemeParser = LexemeParser.getInstance();
    }

    @AfterClass
    public void tearDown() {
        lexemeParser = null;
    }

    @DataProvider(name = "parsePositiveData")
    public Object[][] createParsePositiveData() {
        TextComponent expected1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('h', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf4 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf5 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        expected1.add(symbolLeaf1);
        expected1.add(symbolLeaf2);
        expected1.add(symbolLeaf3);
        expected1.add(symbolLeaf4);
        expected1.add(symbolLeaf5);
        TextComponent expected2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf6 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('h', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf(',', SymbolLeafType.PUNCTUATION);
        expected2.add(symbolLeaf6);
        expected2.add(symbolLeaf7);
        expected2.add(symbolLeaf8);
        TextComponent expected3 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('.', SymbolLeafType.PUNCTUATION);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf('h', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('i', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf12 = new SymbolLeaf(' ', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf13 = new SymbolLeaf(',', SymbolLeafType.PUNCTUATION);
        expected3.add(symbolLeaf9);
        expected3.add(symbolLeaf10);
        expected3.add(symbolLeaf11);
        expected3.add(symbolLeaf12);
        expected3.add(symbolLeaf13);
        return new Object[][]{
                {"hello", expected1},
                {"oh,", expected2},
                {".hi ,", expected3}
        };
    }

    @Test(dataProvider = "parsePositiveData")
    public void parsePositiveTest(String lexeme, TextComponent expected) {
        TextComponent actual = lexemeParser.parse(lexeme);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "parseNegativeData")
    public Object[][] createParseNegativeData() {
        TextComponent expected1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('h', SymbolLeafType.PUNCTUATION);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf4 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf5 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        expected1.add(symbolLeaf1);
        expected1.add(symbolLeaf2);
        expected1.add(symbolLeaf3);
        expected1.add(symbolLeaf4);
        expected1.add(symbolLeaf5);
        TextComponent expected2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf6 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('h', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf(',', SymbolLeafType.LETTER);
        expected2.add(symbolLeaf6);
        expected2.add(symbolLeaf7);
        expected2.add(symbolLeaf8);
        TextComponent expected3 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('.', SymbolLeafType.PUNCTUATION);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf('h', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('i', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf12 = new SymbolLeaf(' ', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf13 = new SymbolLeaf(',', SymbolLeafType.LETTER);
        expected3.add(symbolLeaf9);
        expected3.add(symbolLeaf10);
        expected3.add(symbolLeaf11);
        expected3.add(symbolLeaf12);
        expected3.add(symbolLeaf13);
        TextComponent expected4 = new TextComposite(TextComponentType.LEXEME);
        return new Object[][]{
                {"hello", expected1},
                {"oh,", expected2},
                {".hi ,", expected3},
                {"qwerty ,", expected4}
        };
    }

    @Test(dataProvider = "parseNegativeData")
    public void parseNegativeTest(String lexeme, TextComponent expected) {
        TextComponent actual = lexemeParser.parse(lexeme);
        assertNotEquals(actual, expected);
    }
}
