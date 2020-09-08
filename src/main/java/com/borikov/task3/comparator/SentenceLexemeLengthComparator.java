package com.borikov.task3.comparator;

import com.borikov.task3.composite.TextComponent;

import java.util.Comparator;
import java.util.List;

public class SentenceLexemeLengthComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        List<TextComponent> lexemes1 = o1.getTextComponents();
        List<TextComponent> lexemes2 = o2.getTextComponents();
        TextComponent maxLexeme1 = lexemes1.stream().
                max(Comparator.comparing(textComponent ->
                        textComponent.getTextComponents().size())).get();
        TextComponent maxLexeme2 = lexemes2.stream().
                max(Comparator.comparing(textComponent ->
                        textComponent.getTextComponents().size())).get();
        return Integer.compare(maxLexeme1.getTextComponents().size(),
                maxLexeme2.getTextComponents().size());
    }
}
