package com.borikov.task3.service;

import com.borikov.task3.composite.TextComponent;

public interface TextService {
    TextComponent sortParagraphsByAmountOfSentences(TextComponent text);

    TextComponent sortParagraphsByAmountOfLexeme(TextComponent text);

    TextComponent sortParagraphsByAmountOfWord(TextComponent text);
}
