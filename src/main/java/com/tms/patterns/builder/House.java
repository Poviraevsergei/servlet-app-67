package com.tms.patterns.builder;

public class House {
    private Integer cost;
    private String color;
    private Double square;
    private Integer level;
    private Integer weight;

    public static class Builder {
        private House house;

        public Builder() {
            this.house = new House();
        }

        public Builder setCost(Integer cost) {
            this.house.cost = cost;
            return this;
        }

        public Builder setColor(String color) {
            this.house.color = color;
            return this;
        }

        public Builder setSquare(Double square) {
            this.house.square = square;
            return this;
        }

        public Builder setLevel(Integer level) {
            this.house.level = level;
            return this;
        }

        public Builder setWeight(Integer weight) {
            this.house.weight = weight;
            return this;
        }

        public House build() {
            return house;
        }
    }
}
