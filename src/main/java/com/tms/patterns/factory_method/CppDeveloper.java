package com.tms.patterns.factory_method;

public class CppDeveloper implements Developer {

    @Override
    public String getLanguage() {
        return "C++";
    }

    @Override
    public void makeCode() {
        System.out.println("Can write code mostly like Java on C++!");
    }
}
