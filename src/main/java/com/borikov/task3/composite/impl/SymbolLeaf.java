package com.borikov.task3.composite.impl;

import com.borikov.task3.composite.SymbolType;
import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SymbolLeaf implements TextComponent {
    private static final Logger LOGGER = LogManager.getLogger();
    private final char symbol;
    private final SymbolType symbolType;

    public SymbolLeaf(char symbol, SymbolType symbolType) {
        this.symbol = symbol;
        this.symbolType = symbolType;
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

    @Override
    public void add(TextComponent textComponent) {
        LOGGER.log(Level.WARN, "Method \"add\" is not supported for this class");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent textComponent) {
        LOGGER.log(Level.WARN, "Method \"remove\" is not supported for this class");
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponent getChild(int index) {
        LOGGER.log(Level.WARN, "Method \"getChild\" is not supported for this class");
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponentType getTextComponentType() {
        LOGGER.log(Level.WARN, "Method \"getTextComponentType\" is not supported for this class");
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getTextComponents() {
        LOGGER.log(Level.WARN, "Method \"getTextComponents\" is not supported for this class");
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SymbolLeaf symbolLeaf = (SymbolLeaf) o;
        if (symbol != symbolLeaf.symbol) {
            return false;
        }
        return symbolType == symbolLeaf.symbolType;
    }

    @Override
    public int hashCode() {
        int result = symbol;
        result = 31 * result + (symbolType != null ? symbolType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
