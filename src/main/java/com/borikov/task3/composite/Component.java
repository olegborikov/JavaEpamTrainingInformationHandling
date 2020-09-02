package com.borikov.task3.composite;

public interface Component {
    String operation();

    void add(Component component);

    void remove(Component component);

    Component getChild(int index);
}
