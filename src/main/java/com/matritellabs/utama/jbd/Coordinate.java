package com.matritellabs.utama.jbd;

public class Coordinate {

    private int x;
    private int y;

    //Constructor
    public Coordinate(int xCoordinate, int yCoordinate) {
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

    //Decode coordinate like "A" --> 0
    public static int decodeCoordinate(String inputCoordinate) {
        inputCoordinate = inputCoordinate.toUpperCase();
        if (inputCoordinate.charAt(0) != -1){
            switch (inputCoordinate.charAt(0)) {
                case ('A'):
                    return 0;
                case ('B'):
                    return 1;
                case ('C'):
                    return 2;
                case ('D'):
                    return 3;
                case ('E'):
                    return 4;
                case ('F'):
                    return 5;
                case ('G'):
                    return 6;
                case ('H'):
                    return 7;
                case ('I'):
                    return 8;
                case ('J'):
                    return 9;
            }
        } else {
            return -1;
        }
        return -1;
    }
}


