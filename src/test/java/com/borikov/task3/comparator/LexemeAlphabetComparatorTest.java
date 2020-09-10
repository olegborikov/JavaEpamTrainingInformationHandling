package com.borikov.task3.comparator;

import com.borikov.task3.composite.SymbolType;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.SymbolLeaf;
import com.borikov.task3.composite.impl.TextComposite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LexemeAlphabetComparatorTest {
    private LexemeAlphabetComparator lexemeAlphabetComparator;

    @BeforeClass
    public void setUp() {
        lexemeAlphabetComparator = new LexemeAlphabetComparator();
    }

    @AfterClass
    public void tearDown() {
        lexemeAlphabetComparator = null;
    }

    @DataProvider(name = "comparePositiveData")
    public Object[][] createComparePositiveData() {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('a', SymbolType.LETTER);
        textComponent1.add(symbolLeaf1);
        TextComponent textComponent2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('b', SymbolType.LETTER);
        textComponent2.add(symbolLeaf2);
        TextComponent textComponent3 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('A', SymbolType.LETTER);
        textComponent3.add(symbolLeaf3);
        TextComponent textComponent4 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf4 = new SymbolLeaf(',', SymbolType.PUNCTUATION);
        textComponent4.add(symbolLeaf4);
        return new Object[][]{
                {textComponent1, textComponent1, 0},
                {textComponent1, textComponent2, -1},
                {textComponent1, textComponent3, 32},
                {textComponent1, textComponent4, 53},
                {textComponent3, textComponent1, -32}
        };
    }

    @Test(dataProvider = "comparePositiveData")
    public void comparePositiveTest(
            TextComponent textComponent1, TextComponent textComponent2, int expected) {
        int actual = lexemeAlphabetComparator.compare(textComponent1, textComponent2);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "compareNegativeData")
    public Object[][] createCompareNegativeData() {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('a', SymbolType.LETTER);
        textComponent1.add(symbolLeaf1);
        TextComponent textComponent2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('b', SymbolType.LETTER);
        textComponent2.add(symbolLeaf2);
        TextComponent textComponent3 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('A', SymbolType.LETTER);
        textComponent3.add(symbolLeaf3);
        TextComponent textComponent4 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf4 = new SymbolLeaf(',', SymbolType.PUNCTUATION);
        textComponent4.add(symbolLeaf4);
        return new Object[][]{
                {textComponent1, textComponent1, 1},
                {textComponent1, textComponent2, 1},
                {textComponent1, textComponent3, -1},
                {textComponent1, textComponent4, -1},
        };
    }

    @Test(dataProvider = "compareNegativeData")
    public void compareNegativeTest(
            TextComponent textComponent1, TextComponent textComponent2, int expected) {
        int actual = lexemeAlphabetComparator.compare(textComponent1, textComponent2);
        assertNotEquals(actual, expected);
    }
}