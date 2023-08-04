package com.tms.SOLID.S;

public class Book {
    public String name;
    public String author;
    public String text;

    //getters, setters, constructors

    public void changeWordsInTheText(String first, String second) {
        text = text.replaceAll(first, second);
    }
}
