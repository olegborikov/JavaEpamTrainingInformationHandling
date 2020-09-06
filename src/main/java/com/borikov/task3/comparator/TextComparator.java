package com.borikov.task3.comparator;

import com.borikov.task3.composite.TextComponent;

import java.util.Comparator;

public class TextComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return Integer.compare(o1.getTextComponents().size(),
                o2.getTextComponents().size());
    }
}
