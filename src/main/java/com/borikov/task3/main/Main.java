package com.borikov.task3.main;


import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.parser.impl.TextParser;
import com.borikov.task3.reader.CustomFileReader;
import com.borikov.task3.service.TextService;
import com.borikov.task3.service.impl.TextServiceImpl;

public class Main {
    public static void main(String[] args) {
        CustomFileReader customFileReader = new CustomFileReader();
        String text = customFileReader.readText("input/data.txt");
        TextParser textParser = new TextParser();
        TextComponent textComponent = textParser.parse(text);
        System.out.println(textComponent);
        TextService textService = new TextServiceImpl();
        System.out.println(textService.sortSentencesByAmountOfLexeme(textComponent.getChild(3)));
    }
}
