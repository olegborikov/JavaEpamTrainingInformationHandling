package com.borikov.task3.comparator;

import com.borikov.task3.composite.SymbolType;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.impl.SymbolLeaf;

import java.util.Comparator;
import java.util.List;

public class SentenceMaxWordLengthComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        List<TextComponent> lexemes1 = o1.getTextComponents();
        List<TextComponent> lexemes2 = o2.getTextComponents();
        TextComponent maxWord1 = getMaxWord(lexemes1);
        TextComponent maxWord2 = getMaxWord(lexemes2);
        int wordLength1 = getWordLength(maxWord1);
        int wordLength2 = getWordLength(maxWord2);
        return Integer.compare(wordLength1, wordLength2);
    }

    private TextComponent getMaxWord(List<TextComponent> lexemes) {
        TextComponent maxWord = lexemes.stream().
                max(Comparator.comparing(t -> t.getTextComponents()
                        .stream().filter(t1 -> t1 instanceof SymbolLeaf)
                        .map(t2 -> (SymbolLeaf) t2)
                        .filter(t3 -> t3.getSymbolType() == SymbolType.LETTER)
                        .count())).get();
        return maxWord;
    }

    private int getWordLength(TextComponent word) {
        int length = (int) word.getTextComponents().stream()
                .filter(t1 -> t1 instanceof SymbolLeaf)
                .map(t2 -> (SymbolLeaf) t2)
                .filter(t3 -> t3.getSymbolType() == SymbolType.LETTER)
                .count();
        return length;
    }
}
