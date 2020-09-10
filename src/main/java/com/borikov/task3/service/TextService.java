package com.borikov.task3.service;

import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.exception.IncorrectDataException;

public interface TextService {
    TextComponent sortParagraphsByAmountOfSentences(TextComponent text)
            throws IncorrectDataException;

    TextComponent sortSentencesByMaxWordLength(TextComponent paragraph)
            throws IncorrectDataException;

    TextComponent sortSentencesByMaxLexemeLength(TextComponent paragraph)
            throws IncorrectDataException;

    TextComponent sortLexemesByEntryOfSymbol(TextComponent sentence, char symbol)
            throws IncorrectDataException;
}
