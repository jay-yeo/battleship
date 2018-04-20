package com.matritellabs.utama.jbd;

import java.util.ArrayList;
import java.util.List;

public class Ship {


    private String shipIdentifier;
    private int shipSize;
    private boolean shipSunk;
    private int shipMaxHits;
    private List<int[]> shipCoordinates;

    public Ship(String shipIdentifier2, int shipSize2) {
        shipIdentifier = shipIdentifier2;
        shipSize = shipSize2;
        shipSunk = false;
        shipMaxHits = shipSize2;
        shipCoordinates = new ArrayList<>();
    }

    public String getShipIdentifier() {
        return shipIdentifier;
    }

    public void setShipIdentifier(String shipIdentifier) {
        this.shipIdentifier = shipIdentifier;
    }

    public int getShipSize() {
        return shipSize;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }

    public boolean isShipSunk() {
        return shipSunk;
    }

    public void setShipSunk(boolean shipSunk) {
        this.shipSunk = shipSunk;
    }

    public int getShipMaxHits() {
        return shipMaxHits;
    }

    public void setShipMaxHits(int shipMaxHits) {
        this.shipMaxHits = shipMaxHits;
    }

    public List<int[]> getShipCoordinates() {
        return shipCoordinates;
    }

    public void setShipCoordinates(List<int[]> shipCoordinates) {
        this.shipCoordinates = shipCoordinates;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipIdentifier='" + shipIdentifier + '\'' +
                ", shipSize=" + shipSize +
                ", shipSunk=" + shipSunk +
                ", shipMaxHits=" + shipMaxHits +
                ", shipCoordinates=" + shipCoordinates +
                '}';
    }
}
