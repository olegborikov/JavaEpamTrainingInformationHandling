package com.borikov.task3.composite.impl;

import com.borikov.task3.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    @Override
    public void operation() {
        for (Component component : components) {
            component.operation();
        }
    }

    @Override
    public void add(Component component) {
        component.add(component);
    }

    @Override
    public void remove(Component component) {
        component.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }
}
