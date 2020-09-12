package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.parser.BaseParser;

public class TextParser implements BaseParser {
    private static final TextParser INSTANCE = new TextParser();
    private final ParagraphParser paragraphParser = ParagraphParser.getInstance();
    private static final String TEXT_DELIMITER = "\n\\s*";

    private TextParser() {
    }

    public static TextParser getInstance() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = text.split(TEXT_DELIMITER);
        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = paragraphParser.parse(paragraph);
            textComponent.add(paragraphComponent);
        }
        return textComponent;
    }
}
