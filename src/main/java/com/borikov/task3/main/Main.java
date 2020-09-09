package com.borikov.task3.main;


import com.borikov.task3.composite.TextComponent;
import com.borikov.task3.exception.IncorrectDataException;
import com.borikov.task3.parser.impl.TextParser;
import com.borikov.task3.reader.CustomFileReader;

public class Main {
    public static void main(String[] args) throws IncorrectDataException {
        CustomFileReader customFileReader = new CustomFileReader();
        String text = customFileReader.readText("input/dataMath.txt");
        TextParser textParser = new TextParser();
        TextComponent textComponent = textParser.parse(text);
        System.out.println(textComponent);
    }
}
