package com.borikov.task3.service.impl;

import com.borikov.task3.comparator.ParagraphSentenceLengthComparator;
import com.borikov.task3.comparator.SentenceLexemeLengthComparator;
import com.borikov.task3.comparator.SentenceWordLengthComparator;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.exception.IncorrectDataException;
import com.borikov.task3.service.TextService;

import java.util.ArrayList;
import java.util.List;

public class TextServiceImpl implements TextService {
    @Override
    public TextComponent sortParagraphsByAmountOfSentences(TextComponent text)
            throws IncorrectDataException {
        TextComponent sortedText = new TextComposite(TextComponentType.TEXT);
    /*    if(){
            throw new IncorrectDataException("");
        }*/
        if (text.getTextComponentType().equals(TextComponentType.TEXT)) {
            List<TextComponent> paragraphs = new ArrayList<>(text.getTextComponents());
            paragraphs.sort(new ParagraphSentenceLengthComparator());
            for (TextComponent paragraph : paragraphs) {
                sortedText.add(paragraph);
            }
        }
        return sortedText;
    }

    @Override
    public TextComponent sortSentencesByfWordLength(TextComponent paragraph) {
        TextComponent sortedParagraph = new TextComposite(TextComponentType.PARAGRAPH);
        if (paragraph.getTextComponentType().equals(TextComponentType.PARAGRAPH)) {
            List<TextComponent> sentences = new ArrayList<>(paragraph.getTextComponents());
            sentences.sort(new SentenceWordLengthComparator());
            for (TextComponent sentence : sentences) {
                sortedParagraph.add(sentence);
            }
        }
        return sortedParagraph;
    }

    @Override
    public TextComponent sortSentencesByLexemeLength(TextComponent paragraph) {
        TextComponent sortedParagraph = new TextComposite(TextComponentType.PARAGRAPH);
        if (paragraph.getTextComponentType().equals(TextComponentType.PARAGRAPH)) {
            List<TextComponent> sentences = new ArrayList<>(paragraph.getTextComponents());
            sentences.sort(new SentenceLexemeLengthComparator());
            for (TextComponent sentence : sentences) {
                sortedParagraph.add(sentence);
            }
        }
        return sortedParagraph;
    }

    @Override
    public TextComponent sortLexemesByEntryOfSymbol(TextComponent sentence, char symbol) {
        return null;
    }
}
