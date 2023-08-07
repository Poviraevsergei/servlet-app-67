package com.tms.patterns.singleton;

public class Sun {
    private String color;
    private static Sun sun;

    private Sun(String color) {
        this.color = color;
    }

    public static Sun makeInstance(String color) {
        if (sun == null) {
            sun = new Sun(color);
        }
        return sun;
    }

    @Override
    public String toString() {
        return "Sun{" +
                "color='" + color + '\'' +
                '}';
    }
}
