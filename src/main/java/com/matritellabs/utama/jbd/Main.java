package com.matritellabs.utama.jbd;

public class Main {
    public static void main(String[] args) {

        // New Game
        Game newGame = new Game();

        // Set Players
        newGame.setGamePlayer(1,"Daniel");
        newGame.setGamePlayer(2,"Balint");



        System.out.println(newGame);

        System.out.println("Game View:");
        Ship battleship = newGame.getPlayerOne().getShip("Battleship");
        Ship carrier = newGame.getPlayerOne().getShip("Carrier");


        newGame.getPlayerOne().placeShip(battleship,0,0, "H");
        newGame.getPlayerOne().placeShip(carrier,5,0, "V");
        newGame.getPlayerOne().getPlayerTable().printTable();

        System.out.println(newGame.getPlayerOne().getShip("Battleship"));






    }
}
