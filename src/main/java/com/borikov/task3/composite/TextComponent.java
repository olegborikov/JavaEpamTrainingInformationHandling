package com.borikov.task3.composite;

public interface TextComponent {
    void add(TextComponent textComponent);

    void remove(TextComponent textComponent);

    TextComponent getChild(int index);

    TextComponentType getTextComponentType();
}
