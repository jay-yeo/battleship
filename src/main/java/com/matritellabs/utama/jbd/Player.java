package com.matritellabs.utama.jbd;

import java.util.List;

public class Player {
    private String playerName;
    private Table myTable;
    private Table opponentTable;
    private List<Ship> listOfShip;
    private List<Ship> sunkenShip;

    //constructor
    public Player(String playerN) {
        playerName = playerN;
        myTable = new Table();
        opponentTable = new Table();
        listOfShip = new List<Ship>();
        sunkenShip = new List<Ship>();
    }

    //Getters


    public String getPlayerName() {
        return playerName;
    }

    public Table getMyTable() {
        return myTable;
    }

    public Table getOpponentTable() {
        return opponentTable;
    }

    public List<Ship> getListOfShip() {
        return listOfShip;
    }

    public List<Ship> getSunkenShip() {
        return sunkenShip;
    }

    //setters

    public void setListOfShip(List<Ship> listOfShip) {
        this.listOfShip = listOfShip;
    }

    public void setSunkenShip(List<Ship> sunkenShip) {
        this.sunkenShip = sunkenShip;
    }
}
