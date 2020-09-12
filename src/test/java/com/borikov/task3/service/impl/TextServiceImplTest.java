package com.borikov.task3.service.impl;

import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.exception.IncorrectDataException;
import com.borikov.task3.parser.impl.ParagraphParser;
import com.borikov.task3.parser.impl.SentenceParser;
import com.borikov.task3.parser.impl.TextParser;
import com.borikov.task3.service.TextService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextServiceImplTest {
    private TextService textService;

    @BeforeClass
    public void setUp() {
        textService = new TextServiceImpl();
    }

    @AfterClass
    public void tearDown() {
        textService = null;
    }

    @DataProvider(name = "sortParagraphsByAmountOfSentencesPositiveData")
    public Object[][] createSortParagraphsByAmountOfSentencesPositiveData() {
        TextParser textParser = TextParser.getInstance();
        String text1 = "World hello. How are you? Im fine.\nOK?\nYes. Very ok!";
        String sortedText1 = "OK? \nYes. Very ok! \nWorld hello. " +
                "How are you? Im fine. \n";
        TextComponent textComponent1 = textParser.parse(text1);
        String text2 = "World hello. How are you?\nOK?\nYes. Very ok!";
        String sortedText2 = "OK? \nWorld hello. How are you? \nYes. Very ok! \n";
        TextComponent textComponent2 = textParser.parse(text2);
        String text3 = "World hello. How are you? Im fine.";
        String sortedText3 = "World hello. How are you? Im fine. \n";
        TextComponent textComponent3 = textParser.parse(text3);
        return new Object[][]{
                {textComponent1, sortedText1},
                {textComponent2, sortedText2},
                {textComponent3, sortedText3}
        };
    }

    @Test(dataProvider = "sortParagraphsByAmountOfSentencesPositiveData")
    public void sortParagraphsByAmountOfSentencesPositiveTest(
            TextComponent textComponent, String expected) {
        try {
            TextComponent actual =
                    textService.sortParagraphsByAmountOfSentences(textComponent);
            assertEquals(actual.toString(), expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect input");
        }
    }

    @DataProvider(name = "sortParagraphsByAmountOfSentencesNegativeData")
    public Object[][] createSortParagraphsByAmountOfSentencesNegativeData() {
        TextParser textParser = TextParser.getInstance();
        String text1 = "World hello. How are you? Im fine.\nOK?\nYes. Very ok!";
        String sortedText1 = "OK? \nYes. Very ok!\nWorld hello. " +
                "How are you? Im fine. \n";
        TextComponent textComponent1 = textParser.parse(text1);
        String text2 = "World hello. How are you?\nOK?\nYes. Very ok!";
        String sortedText2 = "OK? \nWorld hello. How are you? \nYes.Very ok! \n";
        TextComponent textComponent2 = textParser.parse(text2);
        String text3 = "World hello. How are you? Im fine.";
        String sortedText3 = "World hello. How are you? Im fine.";
        TextComponent textComponent3 = textParser.parse(text3);
        return new Object[][]{
                {textComponent1, sortedText1},
                {textComponent2, sortedText2},
                {textComponent3, sortedText3}
        };
    }

    @Test(dataProvider = "sortParagraphsByAmountOfSentencesNegativeData")
    public void sortParagraphsByAmountOfSentencesNegativeTest(
            TextComponent textComponent, String expected) {
        try {
            TextComponent actual =
                    textService.sortParagraphsByAmountOfSentences(textComponent);
            assertNotEquals(actual.toString(), expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void sortParagraphsByAmountOfSentencesExceptionTest()
            throws IncorrectDataException {
        TextComponent textComponent = new TextComposite(TextComponentType.PARAGRAPH);
        textService.sortParagraphsByAmountOfSentences(textComponent);
    }

    @DataProvider(name = "sortSentencesByMaxWordLengthPositiveData")
    public Object[][] createSortSentencesByMaxWordLengthPositiveData() {
        ParagraphParser textParser = ParagraphParser.getInstance();
        String text1 = "World hello. How are you? Im fine...";
        String sortedText1 = "How are you? Im fine... World hello. ";
        TextComponent textComponent1 = textParser.parse(text1);
        String text2 = "World hello. How are you? Im aaa...";
        String sortedText2 = "How are you? Im aaa... World hello. ";
        TextComponent textComponent2 = textParser.parse(text2);
        String text3 = "Im fine.";
        String sortedText3 = "Im fine. ";
        TextComponent textComponent3 = textParser.parse(text3);
        return new Object[][]{
                {textComponent1, sortedText1},
                {textComponent2, sortedText2},
                {textComponent3, sortedText3}
        };
    }

    @Test(dataProvider = "sortSentencesByMaxWordLengthPositiveData")
    public void sortSentencesByMaxWordLengthPositiveTest(
            TextComponent textComponent, String expected) {
        try {
            TextComponent actual =
                    textService.sortSentencesByMaxWordLength(textComponent);
            assertEquals(actual.toString(), expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect input");
        }
    }

    @DataProvider(name = "sortSentencesByMaxWordLengthNegativeData")
    public Object[][] createSortSentencesByMaxWordLengthNegativeData() {
        ParagraphParser textParser = ParagraphParser.getInstance();
        String text1 = "World hello. How are you? Im fine...";
        String sortedText1 = "How are you? World hello. Im fine... ";
        TextComponent textComponent1 = textParser.parse(text1);
        String text2 = "World hello. How are you? Im aaa...";
        String sortedText2 = "How are you? Im aaa... World hello.\n";
        TextComponent textComponent2 = textParser.parse(text2);
        String text3 = "Im fine.";
        String sortedText3 = "Im fine.";
        TextComponent textComponent3 = textParser.parse(text3);
        return new Object[][]{
                {textComponent1, sortedText1},
                {textComponent2, sortedText2},
                {textComponent3, sortedText3}
        };
    }

    @Test(dataProvider = "sortSentencesByMaxWordLengthNegativeData")
    public void sortSentencesByMaxWordLengthNegativeTest(
            TextComponent textComponent, String expected) {
        try {
            TextComponent actual =
                    textService.sortSentencesByMaxWordLength(textComponent);
            assertNotEquals(actual.toString(), expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void sortSentencesByMaxWordLengthExceptionTest()
            throws IncorrectDataException {
        TextComponent textComponent = new TextComposite(TextComponentType.SENTENCE);
        textService.sortSentencesByMaxWordLength(textComponent);
    }

    @DataProvider(name = "sortSentencesByMaxLexemeLengthPositiveData")
    public Object[][] createSortSentencesByMaxLexemeLengthPositiveData() {
        ParagraphParser textParser = ParagraphParser.getInstance();
        String text1 = "World hello. How are you? Im fine...";
        String sortedText1 = "How are you? World hello. Im fine... ";
        TextComponent textComponent1 = textParser.parse(text1);
        String text2 = "World hello. How are you? Im aaa...";
        String sortedText2 = "How are you? World hello. Im aaa... ";
        TextComponent textComponent2 = textParser.parse(text2);
        String text3 = "Im fine.";
        String sortedText3 = "Im fine. ";
        TextComponent textComponent3 = textParser.parse(text3);
        return new Object[][]{
                {textComponent1, sortedText1},
                {textComponent2, sortedText2},
                {textComponent3, sortedText3}
        };
    }

    @Test(dataProvider = "sortSentencesByMaxLexemeLengthPositiveData")
    public void sortSentencesByMaxLexemeLengthPositiveTest(
            TextComponent textComponent, String expected) {
        try {
            TextComponent actual =
                    textService.sortSentencesByMaxLexemeLength(textComponent);
            assertEquals(actual.toString(), expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect input");
        }
    }

    @DataProvider(name = "sortSentencesByMaxLexemeLengthNegativeData")
    public Object[][] createSortSentencesByMaxLexemeLengthNegativeData() {
        ParagraphParser textParser = ParagraphParser.getInstance();
        String text1 = "World hello. How are you? Im fine...";
        String sortedText1 = "How are you? Im fine... World hello. ";
        TextComponent textComponent1 = textParser.parse(text1);
        String text2 = "World hello. How are you? Im aaa...";
        String sortedText2 = "How are you? World hello. Im aaa...\n";
        TextComponent textComponent2 = textParser.parse(text2);
        String text3 = "Im fine.";
        String sortedText3 = "Im fine.";
        TextComponent textComponent3 = textParser.parse(text3);
        return new Object[][]{
                {textComponent1, sortedText1},
                {textComponent2, sortedText2},
                {textComponent3, sortedText3}
        };
    }

    @Test(dataProvider = "sortSentencesByMaxLexemeLengthNegativeData")
    public void sortSentencesByMaxLexemeLengthNegativeTest(
            TextComponent textComponent, String expected) {
        try {
            TextComponent actual =
                    textService.sortSentencesByMaxLexemeLength(textComponent);
            assertNotEquals(actual.toString(), expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void sortSentencesByMaxLexemeLengthExceptionTest()
            throws IncorrectDataException {
        TextComponent textComponent = new TextComposite(TextComponentType.SENTENCE);
        textService.sortSentencesByMaxLexemeLength(textComponent);
    }

    @DataProvider(name = "sortLexemesByEntryOfSymbolPositiveData")
    public Object[][] createSortLexemesByEntryOfSymbolPositiveData() {
        SentenceParser textParser = SentenceParser.getInstance();
        String text1 = "World hello world";
        String sortedText1 = "hello World world ";
        TextComponent textComponent1 = textParser.parse(text1);
        String text2 = "a aAa baa aaa Aaa";
        String sortedText2 = "aaa Aaa aAa baa a ";
        TextComponent textComponent2 = textParser.parse(text2);
        String text3 = "Im fine";
        String sortedText3 = "fine Im ";
        TextComponent textComponent3 = textParser.parse(text3);
        return new Object[][]{
                {textComponent1, 'l', sortedText1},
                {textComponent2, 'a', sortedText2},
                {textComponent3, 'e', sortedText3}
        };
    }

    @Test(dataProvider = "sortLexemesByEntryOfSymbolPositiveData")
    public void sortLexemesByEntryOfSymbolPositiveTest(
            TextComponent textComponent, char symbol, String expected) {
        try {
            TextComponent actual =
                    textService.sortLexemesByEntryOfSymbol(textComponent, symbol);
            assertEquals(actual.toString(), expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect input");
        }
    }

    @DataProvider(name = "sortLexemesByEntryOfSymbolNegativeData")
    public Object[][] createSortLexemesByEntryOfSymbolNegativeData() {
        SentenceParser textParser = SentenceParser.getInstance();
        String text1 = "World hello world";
        String sortedText1 = "hello World world";
        TextComponent textComponent1 = textParser.parse(text1);
        String text2 = "a aAa baa aaa Aaa";
        String sortedText2 = "aaa Aaa aAa baa a\n";
        TextComponent textComponent2 = textParser.parse(text2);
        String text3 = "Im fine.";
        String sortedText3 = "fine Im ";
        TextComponent textComponent3 = textParser.parse(text3);
        return new Object[][]{
                {textComponent1, 'l', sortedText1},
                {textComponent2, 'a', sortedText2},
                {textComponent3, 'e', sortedText3}
        };
    }

    @Test(dataProvider = "sortLexemesByEntryOfSymbolNegativeData")
    public void sortLexemesByEntryOfSymbolNegativeTest(
            TextComponent textComponent, char symbol, String expected) {
        try {
            TextComponent actual =
                    textService.sortLexemesByEntryOfSymbol(textComponent, symbol);
            assertNotEquals(actual.toString(), expected);
        } catch (IncorrectDataException e) {
            fail("Incorrect input");
        }
    }

    @Test(expectedExceptions = IncorrectDataException.class)
    public void sortLexemesByEntryOfSymbolExceptionTest()
            throws IncorrectDataException {
        TextComponent textComponent = new TextComposite(TextComponentType.LEXEME);
        textService.sortLexemesByEntryOfSymbol(textComponent, 'a');
    }
}
