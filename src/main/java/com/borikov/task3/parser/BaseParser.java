package com.borikov.task3.parser;

import com.borikov.task3.composite.TextComponent;

public interface BaseParser {
    TextComponent parse(String text);
}
