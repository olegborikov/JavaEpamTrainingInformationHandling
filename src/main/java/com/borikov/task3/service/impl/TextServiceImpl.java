package com.borikov.task3.service.impl;

import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.service.TextService;

public class TextServiceImpl implements TextService {
    @Override
    public TextComponent sortParagraphsByAmountOfSentences(TextComponent text) {
        TextComponent sortedText = new TextComposite(TextComponentType.TEXT);
        if(text.getTextComponentType().equals(TextComponentType.TEXT)){

        }
        return sortedText;
    }

    @Override
    public TextComponent sortParagraphsByAmountOfLexeme(TextComponent text) {
        return null;
    }

    @Override
    public TextComponent sortParagraphsByAmountOfWord(TextComponent text) {
        return null;
    }
}
