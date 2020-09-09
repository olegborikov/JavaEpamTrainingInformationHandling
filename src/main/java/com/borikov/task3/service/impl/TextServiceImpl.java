package com.borikov.task3.service.impl;

import com.borikov.task3.comparator.*;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.exception.IncorrectDataException;
import com.borikov.task3.service.TextService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextServiceImpl implements TextService {
    @Override
    public TextComponent sortParagraphsByAmountOfSentences(TextComponent text)
            throws IncorrectDataException {
        if (!text.getTextComponentType().equals(TextComponentType.TEXT)) {
            throw new IncorrectDataException("Incorrect text component type");
        }
        TextComponent sortedText = new TextComposite(TextComponentType.TEXT);
        List<TextComponent> paragraphs = new ArrayList<>(text.getTextComponents());
        paragraphs.sort(new ParagraphSentenceLengthComparator());
        for (TextComponent paragraph : paragraphs) {
            sortedText.add(paragraph);
        }
        return sortedText;
    }

    @Override
    public TextComponent sortSentencesByfWordLength(TextComponent paragraph)
            throws IncorrectDataException {
        if (!paragraph.getTextComponentType().equals(TextComponentType.PARAGRAPH)) {
            throw new IncorrectDataException("Incorrect text component type");
        }
        TextComponent sortedParagraph = new TextComposite(TextComponentType.PARAGRAPH);
        List<TextComponent> sentences = new ArrayList<>(paragraph.getTextComponents());
        sentences.sort(new SentenceWordLengthComparator());
        for (TextComponent sentence : sentences) {
            sortedParagraph.add(sentence);
        }
        return sortedParagraph;
    }

    @Override
    public TextComponent sortSentencesByLexemeLength(TextComponent paragraph)
            throws IncorrectDataException {
        if (!paragraph.getTextComponentType().equals(TextComponentType.PARAGRAPH)) {
            throw new IncorrectDataException("Incorrect text component type");
        }
        TextComponent sortedParagraph = new TextComposite(TextComponentType.PARAGRAPH);
        List<TextComponent> sentences = new ArrayList<>(paragraph.getTextComponents());
        sentences.sort(new SentenceLexemeLengthComparator());
        for (TextComponent sentence : sentences) {
            sortedParagraph.add(sentence);
        }
        return sortedParagraph;
    }

    @Override
    public TextComponent sortLexemesByEntryOfSymbol(TextComponent sentence, char symbol)
            throws IncorrectDataException {
        if (!sentence.getTextComponentType().equals(TextComponentType.SENTENCE)) {
            throw new IncorrectDataException("Incorrect text component type");
        }
        TextComponent sortedParagraph = new TextComposite(TextComponentType.SENTENCE);
        List<TextComponent> lexemes = new ArrayList<>(sentence.getTextComponents());
        lexemes.sort(new LexemeSymbolComparator(symbol).thenComparing(new LexemeAlphabetComparator()));
        for (TextComponent lexeme : lexemes) {
            sortedParagraph.add(lexeme);
        }
        return sortedParagraph;
    }
}
