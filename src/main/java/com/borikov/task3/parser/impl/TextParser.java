package com.borikov.task3.parser.impl;

import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;
import com.borikov.task3.composite.impl.TextComposite;
import com.borikov.task3.parser.AbstractParser;

public class TextParser extends AbstractParser {
    private final AbstractParser parser = new ParagraphParser();
    private static final String TEXT_DELIMITER = "\n\\s*";

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = text.split(TEXT_DELIMITER);
        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = parser.parse(paragraph);
            textComponent.add(paragraphComponent);
        }
        return textComponent;
    }
}
