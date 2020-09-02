package com.borikov.task3.composite.impl;

import com.borikov.task3.composite.Component;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Leaf implements Component {
    private static final Logger LOGGER = LogManager.getLogger();
    private char symbol;
    private SymbolType symbolType;

    public Leaf(char symbol, SymbolType symbolType) {
        this.symbol = symbol;
        this.symbolType = symbolType;
    }

    @Override
    public String operation() {
        return toString();
    }

    @Override
    public void add(Component component) {
        LOGGER.log(Level.WARN, "Method \"add\" is not supported for this class");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        LOGGER.log(Level.WARN, "Method \"remove\" is not supported for this class");
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        LOGGER.log(Level.WARN, "Method \"getChild\" is not supported for this class");
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(symbol);
        return sb.toString();
    }
}
