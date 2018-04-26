package com.matritellabs.utama.jbd;
import com.matritellabs.utama.helper.LineByLineReader;

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

    // Player ship placement method.
    public void playerShipPlacement(Player gamePlayer) {
        System.out.println("Admiral " + gamePlayer.getPlayerName() + " prepare your fleet!");
        for (Ship ship : gamePlayer.getListOfShips()) {
            // Place ship
            System.out.println("Place your " + ship.shipType + " on the board!");

            // Set x position
            System.out.println("Set x position:");
            LineByLineReader xInput = new LineByLineReader();
            String xValue = xInput.readLineFromStdIn();

            // Set y position
            System.out.println("Set y position:");
            LineByLineReader yInput = new LineByLineReader();
            String yValue = yInput.readLineFromStdIn();

            System.out.println(ship.shipType + " placed at " + xValue.toUpperCase() + yValue);
            System.out.println("---------------------------");
        }

        System.out.println("All ships deployed to their positions!\n");
    }

    // Player Fire missile
    public void playerFire(Player gamePlayer) {
        // Fire missile!
        System.out.println("You may fire when ready...");

        // Set x position
        System.out.println("Set target x coordinate");
        LineByLineReader xInput = new LineByLineReader();
        String xValue = xInput.readLineFromStdIn();

        // Set y position
        System.out.println("Set target y coordinate:");
        LineByLineReader yInput = new LineByLineReader();
        String yValue = yInput.readLineFromStdIn();

        System.out.println("Rocket fired at " + xValue.toUpperCase() + yValue + "\n");
    }

    // Player turn operations method
    public void playerTurn(Player gamePlayer) {
        System.out.println("Admiral " + gamePlayer.getPlayerName() + ", it's your turn to fire!");
        System.out.println("---------------------------");

        System.out.println("Your Ships: ");
        gamePlayer.getPlayerTable().printTable();

        System.out.println("Enemy Ships: ");
        gamePlayer.getOpponentTable().printTable();

        playerFire(gamePlayer);
    }

    // Clear console view
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

}
