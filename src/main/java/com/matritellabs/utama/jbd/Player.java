package com.matritellabs.utama.jbd;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private int playerID;
    private Table playerTable;
    private Table opponentTable;
    private List<Ship> listOfShips;
    private List<Ship> sunkenShip;


    // Constructor
    public Player(String nameOfPlayer, int playerNumber) {
        playerName = nameOfPlayer;
        playerID = playerNumber;
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

    // Get player ID - eg. Player 1 or Player 2
    public int getPlayerID() {
        return playerID;
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
            if (isPlacingPossibleHorizontally(shipType, inputCoordinate)){
                for (int i = 0; i < shipType.shipSize ; i++) {
                    int xValue = inputCoordinate.getX();
                    int yValue = inputCoordinate.getY() + i;
//                    int[] coordinateArray = {xValue,yValue};

                        playerTable.setTableField(xValue, yValue);
                        shipType.shipCoordinates.add(new Coordinate(xValue, yValue));
                }
            }
        }
        else if (orientation.toUpperCase().equals("V")) {
            // Set ship in vertical position
            if (isPlacingPossibleVertically(shipType, inputCoordinate)){

                for (int i = 0; i < shipType.shipSize ; i++) {
                    int xValue = inputCoordinate.getX() + i;
                    int yValue = inputCoordinate.getY();
//                    int[] coordinateArray = {xValue,yValue};
                    playerTable.setTableField(xValue, yValue);
                    shipType.shipCoordinates.add(new Coordinate(xValue, yValue));
                }
            }
        }

    }

    public  boolean isPlacingPossibleHorizontally(Ship shipType, Coordinate inputCoordinate) {
        int counter = 0;
        if (inputCoordinate.getY() + shipType.shipSize  < playerTable.getTableSize()
                && playerTable.tableArray[inputCoordinate.getX()][inputCoordinate.getY()] == 0) {
            for (int i = 0; i < shipType.shipSize; i++) {
               if (playerTable.tableArray[inputCoordinate.getX()][inputCoordinate.getY() + i] == 0){
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
        if (inputCoordinate.getX() + shipType.shipSize  < playerTable.getTableSize()
                && playerTable.tableArray[inputCoordinate.getX()][inputCoordinate.getY()] == 0) {
            for (int i = 0; i < shipType.shipSize; i++) {
                if (playerTable.tableArray[inputCoordinate.getX() + i][inputCoordinate.getY()] == 0){
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


    // Fire Missile
    public void fire(Coordinate coordinateToFire, Player playerOpponent) {
        if (opponentTable.tableArray[coordinateToFire.getX()][coordinateToFire.getY()] == 0) {
            if (playerOpponent.playerTable.tableArray[coordinateToFire.getX()][coordinateToFire.getY()] == 0) {
                opponentTable.tableArray[coordinateToFire.getX()][coordinateToFire.getY()] = 9;
                playerTable.tableArray[coordinateToFire.getX()][coordinateToFire.getY()] = 9;
            }
            else if (playerOpponent.playerTable.tableArray[coordinateToFire.getX()][coordinateToFire.getY()] == 1) {
                opponentTable.tableArray[coordinateToFire.getX()][coordinateToFire.getY()] = 8;
                playerOpponent.playerTable.tableArray[coordinateToFire.getX()][coordinateToFire.getY()] = 8;
                for (Ship ship : playerOpponent.listOfShips) {
                    for (Coordinate coordinate : ship.shipCoordinates) {
                        if (coordinate.getX() == coordinateToFire.getX() && coordinate.getY() == coordinateToFire.getY()) {
                            ship.shipMaxHits -= 1;
                            if (ship.shipMaxHits == 0) {
                                ship.shipSunk = true;
                                System.out.println(" hit and sunk");
                            }else {
                                System.out.println("Nice, that's a hit!");
                            }
                        }
                    }
                }
            }
        }else {
            System.out.println("You already fired here, try again!");
        }
    }
}







