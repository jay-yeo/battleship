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

        final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        final String ANSI_RED_BACKGROUND = "\u001B[41m";
        final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


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
        newGame.getPlayerOne().getPlayerTable().printTable();
        System.out.println("");

        // Place ships
        newGame.playerShipPlacement(newGame.getPlayerOne());
        System.out.println(playerOneName + ", press enter to continue!");
        LineByLineReader enter = new LineByLineReader();
        String waitForEnter = enter.readLineFromStdIn();

        // Privacy line-feed
        newGame.clearConsole();


        // Player 2
        // Enter name
        System.out.println("Player 2: (Enter Name)");
        LineByLineReader playerTwoNameInput = new LineByLineReader();
        String playerTwoName = playerTwoNameInput.readLineFromStdIn();
        newGame.setGamePlayer(2, playerTwoName);
        newGame.getPlayerTwo().getPlayerTable().printTable();
        System.out.println("");

        // Place ships
        newGame.playerShipPlacement(newGame.getPlayerTwo());

        System.out.println(playerTwoName + ", press enter to continue!");
        waitForEnter = enter.readLineFromStdIn();

        // Privacy line-feed
        newGame.clearConsole();
        System.out.println(playerOneName + ", press enter to continue!");
        waitForEnter = enter.readLineFromStdIn();

        // Play game until either player has zero ships remaining
        while (newGame.getPlayerOne().getListOfSunkenShips().size() != 6 || newGame.getPlayerTwo().getListOfSunkenShips().size() != 6) {


            // Player one turn
            System.out.println(newGame.getPlayerOne().getListOfSunkenShips());
            newGame.playerTurn(newGame.getPlayerOne());
            newGame.getPlayerOne().getOpponentTable().printTable();
            if (newGame.getPlayerTwo().getListOfSunkenShips().size() == 5) {
                break;
            }
            System.out.println(playerOneName + ", press enter to continue!");
            waitForEnter = enter.readLineFromStdIn();

            // Privacy line-feed
            newGame.clearConsole();
            System.out.println(playerTwoName + ", press enter to continue!");
            waitForEnter = enter.readLineFromStdIn();

            // Player two turn
            System.out.println(newGame.getPlayerTwo().getListOfSunkenShips());
            newGame.playerTurn(newGame.getPlayerTwo());
            newGame.getPlayerTwo().getOpponentTable().printTable();
            if (newGame.getPlayerOne().getListOfSunkenShips().size() == 5) {
                break;
            }
            System.out.println(playerTwoName + ", press enter to continue!");
            waitForEnter = enter.readLineFromStdIn();

            // Privacy line-feed
            newGame.clearConsole();
            System.out.println(playerOneName + ", press enter to continue!");
            waitForEnter = enter.readLineFromStdIn();

        }

        System.out.println("GAME OVER!");



    }
}
