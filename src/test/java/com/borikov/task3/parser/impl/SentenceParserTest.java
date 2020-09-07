package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.SymbolType;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.SymbolLeaf;
import com.borikov.task3.composite.impl.TextComposite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SentenceParserTest {
    private SentenceParser sentenceParser;

    @BeforeClass
    public void setUp() {
        sentenceParser = new SentenceParser();
    }

    @AfterClass
    public void tearDown() {
        sentenceParser = null;
    }

    @Test
    public void parsePositiveText() {
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
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('w', SymbolType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('r', SymbolType.LETTER);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('d', SymbolType.LETTER);
        SymbolLeaf symbolLeaf12 = new SymbolLeaf('.', SymbolType.PUNCTUATION);
        textComponent2.add(symbolLeaf7);
        textComponent2.add(symbolLeaf8);
        textComponent2.add(symbolLeaf9);
        textComponent2.add(symbolLeaf10);
        textComponent2.add(symbolLeaf11);
        textComponent2.add(symbolLeaf12);
        TextComponent expected = new TextComposite(TextComponentType.SENTENCE);
        expected.add(textComponent1);
        expected.add(textComponent2);
        String sentence = "Hello, world.";
        TextComponent actual = sentenceParser.parse(sentence);
        assertEquals(actual, expected);
    }

    @Test
    public void parseNegativeText() {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('H', SymbolType.LETTER);
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
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('w', SymbolType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('o', SymbolType.LETTER);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('r', SymbolType.LETTER);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf('l', SymbolType.LETTER);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('d', SymbolType.LETTER);
        textComponent2.add(symbolLeaf7);
        textComponent2.add(symbolLeaf8);
        textComponent2.add(symbolLeaf9);
        textComponent2.add(symbolLeaf10);
        textComponent2.add(symbolLeaf11);
        TextComponent expected = new TextComposite(TextComponentType.SENTENCE);
        expected.add(textComponent1);
        expected.add(textComponent2);
        String sentence = "Hello, world";
        TextComponent actual = sentenceParser.parse(sentence);
        assertNotEquals(actual, expected);
    }
}