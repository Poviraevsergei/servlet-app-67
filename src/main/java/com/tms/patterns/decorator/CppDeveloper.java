package com.tms.patterns.decorator;

public class CppDeveloper implements Developer {
    @Override
    public void showSkill() {
        System.out.println("I can write C++ ...");
    }
}
