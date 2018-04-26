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

    //Decode coordinate like "A1" --> 00
    public static void decodeCoordinate(String inputCoordinate) {
        if ((inputCoordinate.length() > 3 && inputCoordinate.length() < 0)
                && "ABCDEFGHIJabcdefghij".charAt(inputCoordinate.indexOf(0)) == -1
                && inputCoordinate.indexOf(2) != 0
                && Integer.parseInt(inputCoordinate.substring(1)) < 11) {
            System.out.println("Coordinate you typed " + inputCoordinate + " is not valid. " +
                    "Letter(a-j), Number(1-10). Please try again. ");
        } else {
            switch (inputCoordinate.charAt(0)) {
                case ('A' | 'a'):
                    new Coordinate(0, Character.getNumericValue(inputCoordinate.charAt(1)) - 1);
                    break;
                case ('B' | 'b'):
                    new Coordinate(1, Character.getNumericValue(inputCoordinate.charAt(1)) - 1);
                    break;
                case ('C' | 'c'):
                    new Coordinate(2, Character.getNumericValue(inputCoordinate.charAt(1)) - 1);
                    break;
                case ('D' | 'd'):
                    new Coordinate(3, Character.getNumericValue(inputCoordinate.charAt(1)) - 1);
                    break;
                case ('E' | 'e'):
                    new Coordinate(4, Character.getNumericValue(inputCoordinate.charAt(1)) - 1);
                    break;
                case ('F' | 'f'):
                    new Coordinate(5, Character.getNumericValue(inputCoordinate.charAt(1)) - 1);
                    break;
                case ('G' | 'g'):
                    new Coordinate(6, Character.getNumericValue(inputCoordinate.charAt(1)) - 1);
                    break;
                case ('H' | 'h'):
                    new Coordinate(7, Character.getNumericValue(inputCoordinate.charAt(1)) - 1);
                    break;
                case ('I' | 'i'):
                    new Coordinate(8, Character.getNumericValue(inputCoordinate.charAt(1)) - 1);
                    break;
                case ('J' | 'j'):
                    new Coordinate(9, Character.getNumericValue(inputCoordinate.charAt(1)) - 1);
                    break;
            }
        }

    }


}
