package com.matritellabs.utama.jbd;
import com.matritellabs.utama.helper.LineByLineReader;

// Battleship Game
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

    // Game Menu
    public void gameMenu() {

        // ANSI colour set
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_WHITE = "\u001B[37m";


        // Setup New Game
        System.out.println("▀█████████▄     ▄████████     ███         ███      ▄█          ▄████████    ▄████████    ▄█    █▄     ▄█     ▄███████▄ \n" +
                "  ███    ███   ███    ███ ▀█████████▄ ▀█████████▄ ███         ███    ███   ███    ███   ███    ███   ███    ███    ███ \n" +
                "  ███    ███   ███    ███    ▀███▀▀██    ▀███▀▀██ ███         ███    █▀    ███    █▀    ███    ███   ███▌   ███    ███ \n" +
                " ▄███▄▄▄██▀    ███    ███     ███   ▀     ███   ▀ ███        ▄███▄▄▄       ███         ▄███▄▄▄▄███▄▄ ███▌   ███    ███ \n" +
                "▀▀███▀▀▀██▄  ▀███████████     ███         ███     ███       ▀▀███▀▀▀     ▀███████████ ▀▀███▀▀▀▀███▀  ███▌ ▀█████████▀  \n" +
                "  ███    ██▄   ███    ███     ███         ███     ███         ███    █▄           ███   ███    ███   ███    ███        \n" +
                "  ███    ███   ███    ███     ███         ███     ███▌    ▄   ███    ███    ▄█    ███   ███    ███   ███    ███        \n" +
                "▄█████████▀    ███    █▀     ▄████▀      ▄████▀   █████▄▄██   ██████████  ▄████████▀    ███    █▀    █▀    ▄████▀      \n" +
                "                                                  ▀                                                                    \nby torpedoTeam-2");
        System.out.println("---------------------------");
        System.out.println("Starting new Battleship game...\n");
    }

    // Create and log new players
    public void setGamePlayers() {

        // Create player one
        System.out.println("\nPlayer 1: (Enter Name)");
        LineByLineReader playerOneNameInput = new LineByLineReader();
        String playerOneName = playerOneNameInput.readLineFromStdIn();

        // playerOne initialization and assignment
        Player player1 = new Player(playerOneName, 1);
        playerOne = player1;

        // Create player two
        System.out.println("\nPlayer 2: (Enter Name)");
        LineByLineReader playerTwoNameInput = new LineByLineReader();
        String playerTwoName = playerTwoNameInput.readLineFromStdIn();

        // playerTwo initialization and assignment
        Player player2 = new Player(playerTwoName, 2);
        playerTwo = player2;

        // End setGamePlayers
        System.out.println("\nPlayer Setup Complete!\n");

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

        System.out.println("\n" + gamePlayer.getPlayerName().toUpperCase() + ", prepare your fleet!");
        System.out.println("---------------------------");

        for (Ship ship : gamePlayer.getListOfShips()) {

            while (ship.shipCoordinates.size() == 0) {
                // Place ship
                System.out.println("Place your " + ship.shipType.toUpperCase() + " (" + "Size: " + ship.shipSize + ")" + " on the board!");

                // X and Y values
                String xValue = "";
                String yValue = "";
                String orientation = "";

                // Set x position
                while (checkValidLetter(xValue) == false) {
                    // Get user input
                    System.out.println("\nSet X position:");
                    LineByLineReader xInput = new LineByLineReader();
                    xValue = xInput.readLineFromStdIn();

                    // Error message
                    if (!checkValidLetter(xValue)) {
                        System.out.println("\nInvalid x position. Please use letters [A-J] and try again...\n");
                    }
                }

                // Set y position
                while (checkValidNumber(yValue) == false) {
                    // Get user input
                    System.out.println("\nSet Y position:");
                    LineByLineReader yInput = new LineByLineReader();
                    yValue = yInput.readLineFromStdIn();

                    // Error message
                    if (!checkValidNumber(yValue)) {
                        System.out.println("\nInvalid y position. Please use numbers [1-10] and try again...\n");
                    }
                }

                // Set orientation position
                while (checkValidOrientation(orientation) == false) {
                    // Get user input
                    System.out.println("\nSet orientation (H or V):");
                    LineByLineReader orientationInput = new LineByLineReader();
                    orientation = orientationInput.readLineFromStdIn();

                    // Error message
                    if (!checkValidOrientation(orientation)) {
                        System.out.println("\nInvalid orientation. Please use 'V' for vertical and 'H' for horizontal and try again...\n");
                    }

                }

                // Set ship position
                if (gamePlayer.placeShip(ship, new Coordinate(xValue, yValue), orientation.toUpperCase())) {
                    System.out.println("\n" + ship.shipType.toUpperCase() + " placed at " + xValue.toUpperCase() + yValue + "\n");

                }else {
                    System.out.println("Try again!" + "\n");
                }

                System.out.println("\nYour Ships: \n");
                gamePlayer.getPlayerTable().printTable();
                System.out.println("---------------------------");
            }

        }

        // Placing ships finished
        System.out.println("\n" + gamePlayer.getPlayerName().toUpperCase() + ":" );
        System.out.println("All ships have been deployed to their positions!\n");
    }

    public void setGameShips() {

        // Setup playerOne ships
        this.playerShipPlacement(playerOne);
        System.out.println("\n" + playerOne.getPlayerName().toUpperCase() + ", press enter to continue!");
        pressEnter();

        // Privacy Linefeed
        clearConsole();

        // Setup playerTwo ships
        this.playerShipPlacement(playerTwo);
        System.out.println("\n" + playerTwo.getPlayerName().toUpperCase() + ", press enter to continue!");
        pressEnter();

        // Privacy Linefeed
        clearConsole();

    }

    public void gamePlay() {
        // Play game until either player has zero ships remaining
        while (playerOne.getListOfSunkenShips().size() != 6 || playerTwo.getListOfSunkenShips().size() != 6) {


            // Player one turn
            System.out.println(playerOne.getPlayerName().toUpperCase() + ", press enter to start turn!");
            pressEnter();

            System.out.println(playerOne.getListOfSunkenShips());
            this.playerTurn(playerOne);
            playerOne.getOpponentTable().printTable();
            if (playerTwo.getListOfSunkenShips().size() == 5) {
                System.out.println("Congrats, " + playerOne.getPlayerName() + " won!");
                break;
            }
            System.out.println(playerOne.getPlayerName().toUpperCase() + ", press enter to pass turn!");
            pressEnter();

            // Privacy line-feed
            clearConsole();

            // // Player two turn
            System.out.println(playerTwo.getPlayerName().toUpperCase() + ", press enter to start turn!");
            pressEnter();

            System.out.println(playerTwo.getListOfSunkenShips());
            this.playerTurn(playerTwo);
            playerTwo.getOpponentTable().printTable();
            if (playerOne.getListOfSunkenShips().size() == 5) {
                System.out.println("Congrats, " + playerTwo.getPlayerName() + " won!" + "\n");
                break;
            }
            System.out.println(playerTwo.getPlayerName().toUpperCase() + ", press enter to continue!");
            pressEnter();

            // Privacy line-feed
            clearConsole();

        }

        System.out.println("GAME OVER!");
    }

    // Player Fire missile
    public void playerFire(Player gamePlayer) {

        // Fire missile!
        System.out.println("\n" + gamePlayer.getPlayerName().toUpperCase() + ", you may fire when ready...");

        // Set x position
        System.out.println("Set target x coordinate");
        LineByLineReader xInput = new LineByLineReader();
        String xValue = xInput.readLineFromStdIn();
        while (!checkValidLetter(xValue)) {
            System.out.println("Invalid x position. Please use letters [A-J] and try again...");
            xValue = xInput.readLineFromStdIn();
        }

        // Set y position
        System.out.println("Set target y coordinate:");
        LineByLineReader yInput = new LineByLineReader();
        String yValue = yInput.readLineFromStdIn();
        while (!checkValidNumber(yValue)) {
            System.out.println("Invalid y coordinate. Please use numbers [1-10] and try again...");
            yValue = yInput.readLineFromStdIn();
        }
        // Create coordinate object for firing missile
        Coordinate fireCoordinate = new Coordinate(xValue, yValue);
        while (gamePlayer.getOpponentTable().tableArray[fireCoordinate.getX()][fireCoordinate.getY()] != 0) {
            System.out.println("You already fired here, try again!" + "\n");
            // Set x position
            System.out.println("Set target x coordinate");
            xInput = new LineByLineReader();
            xValue = xInput.readLineFromStdIn();
            while (!checkValidLetter(xValue)) {
                System.out.println("Invalid x position. Please use letters [A-J] and try again...");
                xValue = xInput.readLineFromStdIn();
            }

            // Set y position
            System.out.println("Set target y coordinate:");
            yInput = new LineByLineReader();
            yValue = yInput.readLineFromStdIn();
            while (!checkValidNumber(yValue)) {
                System.out.println("Invalid y coordinate. Please use numbers [1-10] and try again...");
                yValue = yInput.readLineFromStdIn();
            }
            fireCoordinate = new Coordinate(xValue, yValue);
        }
        // Fire missile method
        System.out.println("Rocket fired at " + xValue.toUpperCase() + yValue + "\n");
        gamePlayer.fire(fireCoordinate, getPlayerOpponent(gamePlayer));
    }

    // Player turn operations method
    public void playerTurn(Player gamePlayer) {
        System.out.println("\n" + gamePlayer.getPlayerName().toUpperCase() + ", it's your turn to fire!");
        System.out.println("---------------------------");

        System.out.println("Your Ships: " + "\n");
        gamePlayer.getShipDamageReport();
        gamePlayer.getPlayerTable().printTable();

        System.out.println("\nEnemy Ships: " + "\n");
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

    // Check if orientation is valid
    public boolean checkValidOrientation(String orientation) {
        if (orientation.toUpperCase().equals("H") ||
                orientation.toUpperCase().equals("V")) {
            return true;
        }
        return false;
    }

    // Press enter to continue method
    public void pressEnter() {
        LineByLineReader enter = new LineByLineReader();
        enter.readLineFromStdIn();
    }

}
