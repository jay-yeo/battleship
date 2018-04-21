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

}