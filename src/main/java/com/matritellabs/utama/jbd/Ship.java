package com.matritellabs.utama.jbd;

import java.util.ArrayList;
import java.util.List;

// Ship Super Class
public class Ship {

    // Ship fields
    public String shipType;
    public int shipSize;
    public boolean shipSunk;
    public int shipMaxHits;
    public List<Coordinate> shipCoordinates;

    // Ship constructor
    public Ship(String shipPiece, int shipCapacity) {
        shipType = shipPiece;
        shipSize = shipCapacity;
        shipSunk = false;
        shipMaxHits = shipSize;
        shipCoordinates = new ArrayList<>();
    }

    // Ship toString
    public String toString() {
        return "SHIP [" +
                "Type: " + shipType +
                ", Size: " + shipSize +
                ", Sunk: " + shipSunk +
                ", Damage: " + shipMaxHits +
                "]";
    }

    // Get ship damage
    public String getShipDamage() {
        float shipDamage = ((float)(shipMaxHits) / (float)shipSize) * 100f;
        return shipDamage + "%";
    }

    
    // Add damage to ship
    public void shipHit() {
        this.shipMaxHits--;
    }
}