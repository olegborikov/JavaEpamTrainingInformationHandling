package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.SymbolLeafType;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.SymbolLeaf;
import com.borikov.task3.composite.impl.TextComposite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParagraphParserTest {
    private ParagraphParser paragraphParser;

    @BeforeClass
    public void setUp() {
        paragraphParser = ParagraphParser.getInstance();
    }

    @AfterClass
    public void tearDown() {
        paragraphParser = null;
    }

    @Test
    public void parsePositiveTest() {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('H', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf4 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf5 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf6 = new SymbolLeaf(',', SymbolLeafType.PUNCTUATION);
        textComponent1.add(symbolLeaf1);
        textComponent1.add(symbolLeaf2);
        textComponent1.add(symbolLeaf3);
        textComponent1.add(symbolLeaf4);
        textComponent1.add(symbolLeaf5);
        textComponent1.add(symbolLeaf6);
        TextComponent textComponent2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('w', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('r', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('d', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf12 = new SymbolLeaf('.', SymbolLeafType.PUNCTUATION);
        textComponent2.add(symbolLeaf7);
        textComponent2.add(symbolLeaf8);
        textComponent2.add(symbolLeaf9);
        textComponent2.add(symbolLeaf10);
        textComponent2.add(symbolLeaf11);
        textComponent2.add(symbolLeaf12);
        TextComponent textComponent3 = new TextComposite(TextComponentType.SENTENCE);
        textComponent3.add(textComponent1);
        textComponent3.add(textComponent2);
        TextComponent textComponent4 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf13 = new SymbolLeaf('G', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf14 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf15 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf16 = new SymbolLeaf('d', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf17 = new SymbolLeaf('b', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf18 = new SymbolLeaf('y', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf19 = new SymbolLeaf('e', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf20 = new SymbolLeaf(',', SymbolLeafType.PUNCTUATION);
        textComponent4.add(symbolLeaf13);
        textComponent4.add(symbolLeaf14);
        textComponent4.add(symbolLeaf15);
        textComponent4.add(symbolLeaf16);
        textComponent4.add(symbolLeaf17);
        textComponent4.add(symbolLeaf18);
        textComponent4.add(symbolLeaf19);
        textComponent4.add(symbolLeaf20);
        TextComponent textComponent5 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf21 = new SymbolLeaf('w', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf22 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf23 = new SymbolLeaf('r', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf24 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf25 = new SymbolLeaf('d', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf26 = new SymbolLeaf('!', SymbolLeafType.PUNCTUATION);
        textComponent5.add(symbolLeaf21);
        textComponent5.add(symbolLeaf22);
        textComponent5.add(symbolLeaf23);
        textComponent5.add(symbolLeaf24);
        textComponent5.add(symbolLeaf25);
        textComponent5.add(symbolLeaf26);
        TextComponent textComponent6 = new TextComposite(TextComponentType.SENTENCE);
        textComponent6.add(textComponent4);
        textComponent6.add(textComponent5);
        TextComponent expected = new TextComposite(TextComponentType.PARAGRAPH);
        expected.add(textComponent3);
        expected.add(textComponent6);
        String paragraph = "Hello, world. Goodbye, world!";
        TextComponent actual = paragraphParser.parse(paragraph);
        assertEquals(actual, expected);
    }

    @Test
    public void parseNegativeTest() {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('H', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf4 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf5 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf6 = new SymbolLeaf(',', SymbolLeafType.PUNCTUATION);
        textComponent1.add(symbolLeaf1);
        textComponent1.add(symbolLeaf2);
        textComponent1.add(symbolLeaf3);
        textComponent1.add(symbolLeaf4);
        textComponent1.add(symbolLeaf5);
        textComponent1.add(symbolLeaf6);
        TextComponent textComponent2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('w', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('r', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('d', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf12 = new SymbolLeaf('.', SymbolLeafType.PUNCTUATION);
        textComponent2.add(symbolLeaf7);
        textComponent2.add(symbolLeaf8);
        textComponent2.add(symbolLeaf9);
        textComponent2.add(symbolLeaf10);
        textComponent2.add(symbolLeaf11);
        textComponent2.add(symbolLeaf12);
        TextComponent textComponent3 = new TextComposite(TextComponentType.SENTENCE);
        textComponent3.add(textComponent1);
        textComponent3.add(textComponent2);
        TextComponent textComponent4 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf13 = new SymbolLeaf('G', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf14 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf15 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf16 = new SymbolLeaf('d', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf17 = new SymbolLeaf('b', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf18 = new SymbolLeaf('y', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf19 = new SymbolLeaf('e', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf20 = new SymbolLeaf(',', SymbolLeafType.PUNCTUATION);
        textComponent4.add(symbolLeaf13);
        textComponent4.add(symbolLeaf14);
        textComponent4.add(symbolLeaf15);
        textComponent4.add(symbolLeaf16);
        textComponent4.add(symbolLeaf17);
        textComponent4.add(symbolLeaf18);
        textComponent4.add(symbolLeaf19);
        textComponent4.add(symbolLeaf20);
        TextComponent textComponent5 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf21 = new SymbolLeaf('w', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf22 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf23 = new SymbolLeaf('r', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf24 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf25 = new SymbolLeaf('d', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf26 = new SymbolLeaf('!', SymbolLeafType.PUNCTUATION);
        textComponent5.add(symbolLeaf21);
        textComponent5.add(symbolLeaf22);
        textComponent5.add(symbolLeaf23);
        textComponent5.add(symbolLeaf24);
        textComponent5.add(symbolLeaf25);
        textComponent5.add(symbolLeaf26);
        TextComponent textComponent6 = new TextComposite(TextComponentType.SENTENCE);
        textComponent6.add(textComponent4);
        textComponent6.add(textComponent5);
        TextComponent expected = new TextComposite(TextComponentType.TEXT);
        expected.add(textComponent3);
        expected.add(textComponent6);
        String paragraph = "Hello, world. Goodbye, world!";
        TextComponent actual = paragraphParser.parse(paragraph);
        assertNotEquals(actual, expected);
    }
}
