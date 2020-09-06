package com.borikov.task3.service;

import com.borikov.task3.composite.TextComponent;

public interface TextService {
    TextComponent sortParagraphsByAmountOfSentences(TextComponent text);

    TextComponent sortSentencesByAmountOfLexeme(TextComponent text);

    TextComponent sortSentencesByAmountOfWord(TextComponent text);
}
