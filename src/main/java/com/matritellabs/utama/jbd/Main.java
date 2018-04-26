package com.matritellabs.utama.jbd;

import com.matritellabs.utama.helper.LineByLineReader;

public class Main {
    public static void main(String[] args) {

        // New Game
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

//        newGame.clearConsole();
        System.out.println(newGame);

        System.out.println("Game View:");
        Ship battleship = newGame.getPlayerOne().getShip("Battleship");
        Ship carrier = newGame.getPlayerOne().getShip("Carrier");


        newGame.getPlayerOne().placeShip(battleship,new Coordinate(2,2), "H");


        newGame.getPlayerOne().placeShip(carrier,new Coordinate(4,5), "V");
        newGame.getPlayerOne().placeShip(carrier,new Coordinate(8,3), "V");
        newGame.getPlayerOne().placeShip(carrier,new Coordinate(8,1), "V");
        newGame.getPlayerOne().placeShip(carrier,new Coordinate(3,8), "H");
        newGame.getPlayerOne().getPlayerTable().printTable();

        System.out.println(newGame.getPlayerOne().getShip("Battleship"));






    }
}
