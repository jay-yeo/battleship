package com.matritellabs.utama.jbd;
import com.matritellabs.utama.helper.LineByLineReader;

public class Main {
    public static void main(String[] args) {

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
        System.out.println("BATTLESHIP by torpedoTeam-2");
        System.out.println("---------------------------");
        System.out.println("Starting new Battleship game...\n");
        Game newGame = new Game();

        // Setup Players

        // Player 1
        // Enter name
        System.out.println("Player 1: (Enter Name)");
        LineByLineReader playerOneNameInput = new LineByLineReader();
        String playerOneName = playerOneNameInput.readLineFromStdIn();
        newGame.setGamePlayer(1, playerOneName);

        // Place ships
        newGame.playerShipPlacement(newGame.getPlayerOne());

        // Privacy line-feed
        newGame.clearConsole();

        // Player 2
        // Enter name
        System.out.println("Player 2: (Enter Name)");
        LineByLineReader playerTwoNameInput = new LineByLineReader();
        String playerTwoName = playerTwoNameInput.readLineFromStdIn();
        newGame.setGamePlayer(2, playerTwoName);

        // Place ships
        newGame.playerShipPlacement(newGame.getPlayerTwo());

        // Privacy line-feed
        newGame.clearConsole();

        // Play game until either player has zero ships remaining
        while (newGame.getPlayerOne().getListOfShips().size() != 0 || newGame.getPlayerTwo().getListOfShips().size() != 0) {

            // Player one turn
            newGame.playerTurn(newGame.getPlayerOne());

            // Privacy line-feed
            newGame.clearConsole();

            // Player two turn
            newGame.playerTurn(newGame.getPlayerTwo());

            // Privacy line-feed
            newGame.clearConsole();

        }

        System.out.println("GAME OVER!");



    }
}
