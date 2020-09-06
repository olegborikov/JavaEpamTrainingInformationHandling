package com.borikov.task3.service.impl;

import com.borikov.task3.comparator.TextComparator;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.service.TextService;

import java.util.ArrayList;
import java.util.List;

public class TextServiceImpl implements TextService {
    @Override
    public TextComponent sortParagraphsByAmountOfSentences(TextComponent text) {
        TextComponent sortedText = new TextComposite(TextComponentType.TEXT);
        if (text.getTextComponentType().equals(TextComponentType.TEXT)) {
            List<TextComponent> paragraphs = new ArrayList<>(text.getTextComponents());
            paragraphs.sort(new TextComparator());
            for (TextComponent paragraph : paragraphs) {
                sortedText.add(paragraph);
            }
        }
        return sortedText;
    }

    @Override
    public TextComponent sortSentencesByAmountOfLexeme(TextComponent text) {
        TextComponent sortedText = new TextComposite(TextComponentType.PARAGRAPH);
        if (text.getTextComponentType().equals(TextComponentType.PARAGRAPH)) {
            List<TextComponent> sentences = new ArrayList<>(text.getTextComponents());
            sentences.sort(new TextComparator());
            for (TextComponent sentence : sentences) {
                sortedText.add(sentence);
            }
        }
        return sortedText;
    }

    @Override
    public TextComponent sortSentencesByAmountOfWord(TextComponent text) {
        return null;
    }
}
