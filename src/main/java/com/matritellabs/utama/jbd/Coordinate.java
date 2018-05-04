package com.matritellabs.utama.jbd;

public class Coordinate {

    private int x;
    private int y;

    //Constructor with Integer coordinates
    public Coordinate(int xCoordinate, int yCoordinate) {
        x = xCoordinate;
        y = yCoordinate;
    }

    // Constructor with String coordinates
    public Coordinate(String xCoordinate, String yCoordinate) {
        y = decodeCoordinate(xCoordinate);
        x = decodeCoordinate(yCoordinate);
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
    public int decodeCoordinate(String inputCoordinate) {
        inputCoordinate = inputCoordinate.toUpperCase();
            switch (inputCoordinate) {
                case ("A"):
                    return 0;
                case ("B"):
                    return 1;
                case ("C"):
                    return 2;
                case ("D"):
                    return 3;
                case ("E"):
                    return 4;
                case ("F"):
                    return 5;
                case ("G"):
                    return 6;
                case ("H"):
                    return 7;
                case ("I"):
                    return 8;
                case ("J"):
                    return 9;
                case ("1"):
                    return 0;
                case ("2"):
                    return 1;
                case ("3"):
                    return 2;
                case ("4"):
                    return 3;
                case ("5"):
                    return 4;
                case ("6"):
                    return 5;
                case ("7"):
                    return 6;
                case ("8"):
                    return 7;
                case ("9"):
                    return 8;
                case ("10"):
                    return 9;
                default:
                    return -1;
            }
    }
}


