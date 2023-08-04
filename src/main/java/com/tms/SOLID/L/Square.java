package com.tms.SOLID.L;

public class Square extends Rectangle {
    @Override
    public void setX(int x) {
        this.x = x;
        this.y = x;
    }

    @Override
    public void setY(int y) {
        this.x = y;
        this.y = y;
    }
}
