package com.borikov.task3.main;

import com.borikov.task3.composite.Component;
import com.borikov.task3.parser.impl.ParagraphParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*ParagraphParser textParser = new ParagraphParser();
        CustomFileReader customFileReader = new CustomFileReader();
        List<String> text = customFileReader.readText("input/data.txt");
        List<String> t = textParser.parse(text);
        for (String s : t) {
            System.out.println(s);
        }
        System.out.println(String.valueOf('d'));*/

        ParagraphParser paragraphParser = new ParagraphParser();
        List<Component> components = paragraphParser.parse("Олег Бориков, GJgfjgfj ");
        for (Component component : components) {
            System.out.println(component.operation());
        }
    }
}
