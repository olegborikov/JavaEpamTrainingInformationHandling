package com.borikov.task3.comparator;

import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.impl.SymbolLeaf;

import java.util.Comparator;

public class LexemeSymbolComparator implements Comparator<TextComponent> {
    private final char symbol;

    public LexemeSymbolComparator(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int amountOfEntrance1 = findAmountOfEntrance(o1);
        int amountOfEntrance2 = findAmountOfEntrance(o2);
        return Integer.compare(amountOfEntrance1, amountOfEntrance2);
    }

    private int findAmountOfEntrance(TextComponent textComponent) {
        int amountOfEntrance = (int) textComponent.getTextComponents()
                .stream().filter(t1 -> t1 instanceof SymbolLeaf)
                .map(t2 -> (SymbolLeaf) t2)
                .filter(t -> t.getSymbol() == symbol).count();
        return amountOfEntrance;
    }
}
