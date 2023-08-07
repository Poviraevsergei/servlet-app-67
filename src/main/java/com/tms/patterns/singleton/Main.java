package com.tms.patterns.singleton;

public class Main {
    public static void main(String[] args) {
        Sun sunFirst = Sun.makeInstance("Yellow");
        Sun sunSecond = Sun.makeInstance("Red");

        System.out.println(sunFirst);
        System.out.println(sunSecond);
    }
}
