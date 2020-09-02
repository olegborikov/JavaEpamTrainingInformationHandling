package com.borikov.task3.parser;

import com.borikov.task3.composite.Component;

import java.util.List;

public abstract class AbstractParser {
    public abstract List<Component> parse(String text);
}
