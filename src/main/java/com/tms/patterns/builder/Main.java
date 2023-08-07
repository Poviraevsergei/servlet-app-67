package com.tms.patterns.builder;

public class Main {
    public static void main(String[] args) {
        House house = new House.HouseBuilder()
                .cost(100)
                .level(2)
                .build();
    }
}
