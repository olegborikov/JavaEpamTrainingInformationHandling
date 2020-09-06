package com.borikov.task3.composite.impl;

import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.composite.TextComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private final List<TextComponent> textComponents;
    private final TextComponentType textComponentType;
    private static final String PARAGRAPH_DELIMITER = "\n";
    private static final String SENTENCE_DELIMITER = ".";
    private static final String LEXEME_DELIMITER = " ";

    public TextComposite(TextComponentType textComponentType) {
        this.textComponentType = textComponentType;
        textComponents = new ArrayList<>();
    }

    public TextComponentType getTextComponentType() {
        return textComponentType;
    }

    @Override
    public void add(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        textComponents.remove(textComponent);
    }

    @Override
    public TextComponent getChild(int index) {
        return textComponents.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextComposite textComposite = (TextComposite) o;
        if (textComponents != null
                ? !textComponents.equals(textComposite.textComponents)
                : textComposite.textComponents != null) {
            return false;
        }
        return textComponentType == textComposite.textComponentType;
    }

    @Override
    public int hashCode() {
        int result = textComponents != null ? textComponents.hashCode() : 0;
        result = 31 * result + (textComponentType != null ? textComponentType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (TextComponent textComponent : textComponents) {
            sb.append(textComponent.toString());
            if (textComponent instanceof TextComposite) {
                switch (textComponent.getTextComponentType()) {
                    case PARAGRAPH:
                        sb.append(PARAGRAPH_DELIMITER);
                        break;
                    case SENTENCE:
                        sb.append(SENTENCE_DELIMITER);
                        break;
                    case LEXEME:
                        sb.append(LEXEME_DELIMITER);
                        break;
                }
            }
        }
        return sb.toString();
    }
}
