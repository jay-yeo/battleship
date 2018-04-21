package com.matritellabs.utama.jbd;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String gameName;
    private Player playerOne;
    private Player playerTwo;

    // Constructor
    public Game() {
        gameName = "BattleShip";

    }

    // Game toString
    public String toString() {
        return "Game {" +
                "gameName='" + gameName + '\'' +
                ", playerOne=" + playerOne +
                ", playerTwo=" + playerTwo +
                '}';
    }

    // Create and log new players
    public void setGamePlayer(int playerNumber, String playerName) {

        if (playerNumber == 1) {
            // Create new playerOne
            Player newPlayer = new Player(playerName);
            playerOne = newPlayer;

        } else if (playerNumber == 2) {
            // Create playerTwo
            Player newPlayer = new Player(playerName);
            playerTwo = newPlayer;
        } else {
            System.out.println("Invalid player number. Please select player one or two.");
        }

    }

    // Get Player One
    public Player getPlayerOne() {
        return playerOne;
    }

    // Get Player Two
    public Player getPlayerTwo() {
        return playerTwo;
    }

}
