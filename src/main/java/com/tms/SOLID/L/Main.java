package com.tms.SOLID.L;

public class Main {
    public static void main(String[] args) {
        Square rectangle = new Square();
        rectangle.setX(5);
        rectangle.setY(5);
        System.out.println(rectangle.perimeter());
    }
}
