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

public class SentenceMaxWordLengthComparatorTest {
    private SentenceMaxWordLengthComparator sentenceMaxWordLengthComparator;

    @BeforeClass
    public void setUp() {
        sentenceMaxWordLengthComparator = new SentenceMaxWordLengthComparator();
    }

    @AfterClass
    public void tearDown() {
        sentenceMaxWordLengthComparator = null;
    }

    @DataProvider(name = "comparePositiveData")
    public Object[][] createComparePositiveData() {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('H', SymbolType.LETTER);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e', SymbolType.LETTER);
        textComponent1.add(symbolLeaf1);
        textComponent1.add(symbolLeaf2);
        TextComponent textComponent2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('w', SymbolType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('r', SymbolType.LETTER);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf(',', SymbolType.PUNCTUATION);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('.', SymbolType.PUNCTUATION);
        textComponent2.add(symbolLeaf7);
        textComponent2.add(symbolLeaf8);
        textComponent2.add(symbolLeaf9);
        textComponent2.add(symbolLeaf10);
        textComponent2.add(symbolLeaf11);
        TextComponent textComponent3 = new TextComposite(TextComponentType.SENTENCE);
        textComponent3.add(textComponent1);
        textComponent3.add(textComponent2);
        TextComponent textComponent4 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf13 = new SymbolLeaf('G', SymbolType.LETTER);
        SymbolLeaf symbolLeaf14 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf16 = new SymbolLeaf('d', SymbolType.LETTER);
        SymbolLeaf symbolLeaf20 = new SymbolLeaf(',', SymbolType.PUNCTUATION);
        textComponent4.add(symbolLeaf13);
        textComponent4.add(symbolLeaf14);
        textComponent4.add(symbolLeaf16);
        textComponent4.add(symbolLeaf20);
        TextComponent textComponent5 = new TextComposite(TextComponentType.SENTENCE);
        textComponent5.add(textComponent4);
        TextComponent textComponent6 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf21 = new SymbolLeaf('w', SymbolType.LETTER);
        SymbolLeaf symbolLeaf22 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf23 = new SymbolLeaf('r', SymbolType.LETTER);
        SymbolLeaf symbolLeaf24 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf25 = new SymbolLeaf('.', SymbolType.PUNCTUATION);
        textComponent6.add(symbolLeaf21);
        textComponent6.add(symbolLeaf22);
        textComponent6.add(symbolLeaf23);
        textComponent6.add(symbolLeaf24);
        textComponent6.add(symbolLeaf25);
        TextComponent textComponent7 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf27 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf30 = new SymbolLeaf('h', SymbolType.LETTER);
        textComponent7.add(symbolLeaf27);
        textComponent7.add(symbolLeaf30);
        TextComponent textComponent8 = new TextComposite(TextComponentType.SENTENCE);
        textComponent8.add(textComponent6);
        textComponent8.add(textComponent7);
        return new Object[][]{
                {textComponent3, textComponent5, 0},
                {textComponent3, textComponent3, 0},
                {textComponent3, textComponent8, -1},
                {textComponent8, textComponent3, 1},
        };
    }

    @Test(dataProvider = "comparePositiveData")
    public void comparePositiveTest(TextComponent textComponent1,
                                    TextComponent textComponent2, int expected) {
        int actual = sentenceMaxWordLengthComparator.compare(textComponent1, textComponent2);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "compareNegativeData")
    public Object[][] createCompareNegativeData() {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('H', SymbolType.LETTER);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e', SymbolType.LETTER);
        textComponent1.add(symbolLeaf1);
        textComponent1.add(symbolLeaf2);
        TextComponent textComponent2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('w', SymbolType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('r', SymbolType.LETTER);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf(',', SymbolType.PUNCTUATION);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('.', SymbolType.PUNCTUATION);
        textComponent2.add(symbolLeaf7);
        textComponent2.add(symbolLeaf8);
        textComponent2.add(symbolLeaf9);
        textComponent2.add(symbolLeaf10);
        textComponent2.add(symbolLeaf11);
        TextComponent textComponent3 = new TextComposite(TextComponentType.SENTENCE);
        textComponent3.add(textComponent1);
        textComponent3.add(textComponent2);
        TextComponent textComponent4 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf13 = new SymbolLeaf('G', SymbolType.LETTER);
        SymbolLeaf symbolLeaf14 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf16 = new SymbolLeaf('d', SymbolType.LETTER);
        SymbolLeaf symbolLeaf20 = new SymbolLeaf(',', SymbolType.PUNCTUATION);
        textComponent4.add(symbolLeaf13);
        textComponent4.add(symbolLeaf14);
        textComponent4.add(symbolLeaf16);
        textComponent4.add(symbolLeaf20);
        TextComponent textComponent5 = new TextComposite(TextComponentType.SENTENCE);
        textComponent5.add(textComponent4);
        TextComponent textComponent6 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf21 = new SymbolLeaf('w', SymbolType.LETTER);
        SymbolLeaf symbolLeaf22 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf23 = new SymbolLeaf('r', SymbolType.LETTER);
        SymbolLeaf symbolLeaf24 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf25 = new SymbolLeaf('.', SymbolType.PUNCTUATION);
        textComponent6.add(symbolLeaf21);
        textComponent6.add(symbolLeaf22);
        textComponent6.add(symbolLeaf23);
        textComponent6.add(symbolLeaf24);
        textComponent6.add(symbolLeaf25);
        TextComponent textComponent7 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf27 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf30 = new SymbolLeaf('h', SymbolType.LETTER);
        textComponent7.add(symbolLeaf27);
        textComponent7.add(symbolLeaf30);
        TextComponent textComponent8 = new TextComposite(TextComponentType.SENTENCE);
        textComponent8.add(textComponent6);
        textComponent8.add(textComponent7);
        return new Object[][]{
                {textComponent3, textComponent5, 1},
                {textComponent3, textComponent3, 1},
                {textComponent3, textComponent8, 1},
                {textComponent8, textComponent3, -1},
        };
    }

    @Test(dataProvider = "compareNegativeData")
    public void compareNegativeTest(TextComponent textComponent1,
                                    TextComponent textComponent2, int expected) {
        int actual = sentenceMaxWordLengthComparator.compare(textComponent1, textComponent2);
        assertNotEquals(actual, expected);
    }
}
