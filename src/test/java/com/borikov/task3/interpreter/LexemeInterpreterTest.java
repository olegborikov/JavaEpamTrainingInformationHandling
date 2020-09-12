package com.borikov.task3.interpreter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LexemeInterpreterTest {
    private LexemeInterpreter lexemeInterpreter;

    @BeforeClass
    public void setUp() {
        lexemeInterpreter = new LexemeInterpreter();
    }

    @AfterClass
    public void tearDown() {
        lexemeInterpreter = null;
    }

    @DataProvider(name = "interpretLexemePositiveData")
    public Object[][] createInterpretLexemePositiveData() {
        return new Object[][]{
                {"3+5", "8"},
                {"g3+5", "g3+5"},
                {"(((2+3)*5)+6)", "31"},
                {"-1-2+3*5", "12"},
                {"3++ +5", "3++ +5"},
                {"3 + 5", "8"},
                {"abc", "abc"},
                {"(3+2", "(3+2"}
        };
    }

    @Test(dataProvider = "interpretLexemePositiveData")
    public void interpretLexemePositiveTest(String lexeme, String expected) {
        String actual = lexemeInterpreter.interpretLexeme(lexeme);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "interpretLexemeNegativeData")
    public Object[][] createInterpretLexemeNegativeData() {
        return new Object[][]{
                {"3+5", "3+5"},
                {"g3+5", "8"},
                {"(2+3)*5", "(2+3)*5"},
                {"-1-2+3*5", "-12"},
                {"3++ +5", "9"},
                {"3 + 5", "3 + 5"},
                {"abc", "a"},
                {"(3+2", "5"}
        };
    }

    @Test(dataProvider = "interpretLexemeNegativeData")
    public void interpretLexemeNegativeTest(String lexeme, String expected) {
        String actual = lexemeInterpreter.interpretLexeme(lexeme);
        assertNotEquals(actual, expected);
    }
}
