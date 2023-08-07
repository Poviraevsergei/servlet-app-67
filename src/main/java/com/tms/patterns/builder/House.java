package com.tms.patterns.builder;

import lombok.Builder;

@Builder
public class House {
    private Integer cost;
    private String color;
    private Double square;
    private Integer level;
    private Integer weight;

    @Override
    public String toString() {
        return "House{" +
                "cost=" + cost +
                ", color='" + color + '\'' +
                ", square=" + square +
                ", level=" + level +
                ", weight=" + weight +
                '}';
    }
}
