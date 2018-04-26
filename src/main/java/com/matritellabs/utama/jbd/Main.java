package com.matritellabs.utama.jbd;
import com.matritellabs.utama.helper.LineByLineReader;
import sun.tools.tree.WhileStatement;

public class Main {
    public static void main(String[] args) {

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

        }


//        System.out.println(newGame);

//        System.out.println("Game View:");
//        Ship battleship = newGame.getPlayerOne().getShip("Battleship");
//        Ship carrier = newGame.getPlayerOne().getShip("Carrier");
//
//
//        newGame.getPlayerOne().placeShip(battleship,0,0, "H");
//
//
//        newGame.getPlayerOne().placeShip(carrier,5,0, "V");
//        newGame.getPlayerOne().getPlayerTable().printTable();
//
//        System.out.println(newGame.getPlayerOne().getShip("Battleship"));






    }
}
