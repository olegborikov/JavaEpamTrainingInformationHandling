package com.borikov.task3.composite.impl;

import com.borikov.task3.composite.Component;

public class Leaf implements Component {
    @Override
    public void operation() {

    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }
}
