package com.borikov.task3.main;


import com.borikov.task3.parser.impl.TextParser;
import com.borikov.task3.reader.CustomFileReader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CustomFileReader customFileReader = new CustomFileReader();
        String text = customFileReader.readText("input/data.txt");
        TextParser textParser = new TextParser();
        System.out.println(textParser.parse(text));
    }
}
