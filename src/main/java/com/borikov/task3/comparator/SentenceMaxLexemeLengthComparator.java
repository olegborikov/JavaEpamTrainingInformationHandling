package com.borikov.task3.comparator;

import com.borikov.task3.composite.TextComponent;

import java.util.Comparator;
import java.util.List;

public class SentenceMaxLexemeLengthComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        List<TextComponent> lexemes1 = o1.getTextComponents();
        List<TextComponent> lexemes2 = o2.getTextComponents();
        TextComponent maxLexeme1 = getMaxLexeme(lexemes1);
        TextComponent maxLexeme2 = getMaxLexeme(lexemes2);
        return Integer.compare(maxLexeme1.getTextComponents().size(),
                maxLexeme2.getTextComponents().size());
    }

    private TextComponent getMaxLexeme(List<TextComponent> lexemes) {
        TextComponent maxLexeme = lexemes.stream().
                max(Comparator.comparing(t -> t.getTextComponents().size())).get();
        return maxLexeme;
    }
}
