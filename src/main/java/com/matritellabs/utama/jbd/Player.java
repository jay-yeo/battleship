package com.matritellabs.utama.jbd;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private Table playerTable;
    private Table opponentTable;
    private List<Ship> listOfShips;
    private List<Ship> sunkenShip;


    // Constructor
    public Player(String nameOfPlayer) {
        playerName = nameOfPlayer;
        playerTable = new Table();
        opponentTable = new Table();
        listOfShips = new ArrayList<>();
        sunkenShip = new ArrayList<>();
        createShips();

    }

    // Player toString
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerTable=" + playerTable +
                ", opponentTable=" + opponentTable +
                ", listOfShips=" + listOfShips +
                ", sunkenShip=" + sunkenShip +
                '}';
    }

    // Get player name
    public String getPlayerName() {
        return playerName;
    }

    // Get player's list of ships
    public List<Ship> getListOfShips() {
        return listOfShips;
    }

    // Get player view
    public Table getPlayerTable() {
        return playerTable;
    }

    // Get opponent view
    public Table getOpponentTable() {
        return opponentTable;
    }

    // Create player's ship pieces and add to listOfShips
    public void createShips() {

        // Create Battleship
        Battleship battleship = new Battleship();
        listOfShips.add(battleship);

        // Create Cruiser
        Cruiser cruiser = new Cruiser();
        listOfShips.add(cruiser);

        // Create Carrier
        Carrier carrier = new Carrier();
        listOfShips.add(carrier);

        // Create Submarine
        Submarine submarine = new Submarine();
        listOfShips.add(submarine);

        // Create Destroyer
        Destroyer destroyer = new Destroyer();
        listOfShips.add(destroyer);

    }

    // Get ship
    public Ship getShip(String shipType) {
        for (Ship ship : listOfShips) {
            if (ship.shipType == shipType) {
                return ship;
            }
        }

        return null;
    }


    // Place player ship
    public void placeShip(Ship shipType, Coordinate inputCoordinate, String orientation) {

        if (orientation.toUpperCase().equals("H")) {
            // Set ship in horizontal position
            for (int i = 0; i < shipType.shipSize ; i++) {
                int xValue = inputCoordinate.getX();
                int yValue = inputCoordinate.getY() + i;
                int[] coordinateArray = {xValue,yValue};
                if (isPlacingPossibleHorizontally(shipType, inputCoordinate)){
                    playerTable.setTableField(xValue, yValue);
                    shipType.shipCoordinates.add(coordinateArray);
                }

            }
        } else if (orientation.toUpperCase().equals("V")) {
            // Set ship in vertical position
            for (int i = 0; i < shipType.shipSize ; i++) {
                int xValue = inputCoordinate.getX() + i;
                int yValue = inputCoordinate.getY();
                int[] coordinateArray = {xValue,yValue};
                if (isPlacingPossibleVertically(shipType, inputCoordinate)){
                    playerTable.setTableField(xValue, yValue);
                    shipType.shipCoordinates.add(coordinateArray);
                }

            }
        }

    }

    public  boolean isPlacingPossibleHorizontally(Ship shipType, Coordinate inputCoordinate) {
        int counter = 0;
        if ((inputCoordinate.getX() + 1) + shipType.shipSize + 1 <= playerTable.getTableSize()) {
           for (int i = inputCoordinate.getX(); i < shipType.shipSize; i++) {
               if (playerTable.tableArray[i][inputCoordinate.getY() - 1] == 0){
                   counter++;
               }
           }
           if (counter == shipType.shipSize) {
               return true;
           }
        }else {
            return false;
        }
        return false;
    }

    public  boolean isPlacingPossibleVertically(Ship shipType, Coordinate inputCoordinate) {
        int counter = 0;
        if ((inputCoordinate.getY() + 1) + shipType.shipSize + 1 <= playerTable.getTableSize()) {
            for (int i = inputCoordinate.getY(); i < shipType.shipSize; i++) {
                if (playerTable.tableArray[inputCoordinate.getX() - 1][i] == 0){
                    counter++;
                }
            }
            if (counter == shipType.shipSize) {
                return true;
            }
        }else {
            return false;
        }
        return false;
    }


}