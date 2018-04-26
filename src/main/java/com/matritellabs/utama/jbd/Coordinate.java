package com.matritellabs.utama.jbd;

public class Coordinate {

    private int x;
    private int y;

    //Constructor
    public Coordinate (int xCoordinate, int yCoordinate) {
        x = xCoordinate;
        y = yCoordinate;
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
