package com.tms.patterns.factory_method;

public class JavaDeveloper implements Developer {

    @Override
    public String getLanguage() {
        return "Java";
    }

    @Override
    public void makeCode() {
        System.out.println("Make best code in the world on Java!");
    }
}
