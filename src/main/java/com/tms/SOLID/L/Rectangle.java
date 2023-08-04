package com.tms.SOLID.L;

public class Rectangle {
    protected int x;
    protected int y;

    public long perimeter(){
        return (x* 2L) + (y* 2L);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
