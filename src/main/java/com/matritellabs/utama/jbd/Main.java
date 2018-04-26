package com.matritellabs.utama.jbd;
import com.matritellabs.utama.helper.LineByLineReader;

public class Main {
    public static void main(String[] args) {

        // New Game
        System.out.println("Starting new Battleship game...");
        Game newGame = new Game();

        // Setup Players

        // Player 1
        System.out.println("Player 1: (Enter Name)");
        LineByLineReader playerOneNameInput = new LineByLineReader();
        String playerOneName = playerOneNameInput.readLineFromStdIn();
        newGame.setGamePlayer(1, playerOneName);

        // Player 2
        System.out.println("Player 2: (Enter Name)");
        LineByLineReader playerTwoNameInput = new LineByLineReader();
        String playerTwoName = playerTwoNameInput.readLineFromStdIn();

        newGame.setGamePlayer(2, playerTwoName);


        System.out.println(newGame);

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
