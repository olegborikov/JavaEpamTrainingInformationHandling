package com.borikov.task3.composite.impl;

import com.borikov.task3.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();
    private CompositeType compositeType;

    public Composite(CompositeType compositeType) {
        this.compositeType = compositeType;
    }

    @Override
    public String operation() {
        StringBuilder a = new StringBuilder();
        for (Component component : components) {
            a.append(component.operation());
        }
        return a.toString();
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }
}
