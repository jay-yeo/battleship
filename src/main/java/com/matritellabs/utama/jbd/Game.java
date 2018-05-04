package com.matritellabs.utama.jbd;
import com.matritellabs.utama.helper.LineByLineReader;

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
            Player newPlayer = new Player(playerName, 1);
            playerOne = newPlayer;

        } else if (playerNumber == 2) {
            // Create new playerTwo
            Player newPlayer = new Player(playerName, 2);
            playerTwo = newPlayer;
        } else {
            System.out.println("Invalid player number. Please select player 1 or 2.");
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

            while (ship.shipCoordinates.size() == 0) {
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

                // Set orientation Value
                System.out.println("Set orientation (H or V):");
                LineByLineReader orientationInput = new LineByLineReader();
                String orientation = orientationInput.readLineFromStdIn();

                // Set ship position
                gamePlayer.placeShip(ship, new Coordinate(xValue, yValue), orientation.toUpperCase());
                System.out.println(ship.shipType + " placed at " + xValue.toUpperCase() + yValue);
            }


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

        // Create coordinate object for firing missile
        Coordinate fireCoordinate = new Coordinate(xValue, yValue);

        // Fire missile method
        gamePlayer.fire(fireCoordinate, getPlayerOpponent(gamePlayer));

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

    // Determine opponent
    public Player getPlayerOpponent(Player gamePlayer) {
        if (gamePlayer.getPlayerID() == 1) {
            return playerTwo;
        } else if (gamePlayer.getPlayerID() == 2) {
            return playerOne;
        } else {
            return null;
        }
    }

    //check valid hits by letter
    public boolean checkValidLetter(String inputLetter) {
        if (inputLetter.toUpperCase().equals("A") ||
                inputLetter.toUpperCase().equals("B") ||
                inputLetter.toUpperCase().equals("C") ||
                inputLetter.toUpperCase().equals("D") ||
                inputLetter.toUpperCase().equals("E") ||
                inputLetter.toUpperCase().equals("F") ||
                inputLetter.toUpperCase().equals("G") ||
                inputLetter.toUpperCase().equals("H") ||
                inputLetter.toUpperCase().equals("I") ||
                inputLetter.toUpperCase().equals("J") ) {
            return true;
        } else {
            return false;
        }
    }

    //check valid hits by number
    public boolean checkValidNumber(String inputNumber) {
        if (inputNumber.equals("1") ||
                inputNumber.equals("2") ||
                inputNumber.equals("3") ||
                inputNumber.equals("4") ||
                inputNumber.equals("5") ||
                inputNumber.equals("6") ||
                inputNumber.equals("7") ||
                inputNumber.equals("8") ||
                inputNumber.equals("9") ||
                inputNumber.equals("10") ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkValidOrientation(String orientation) {
        if (orientation.toUpperCase().equals("H") ||
                orientation.toUpperCase().equals("V")) {
            return true;
        }
        return false;
    }

}
