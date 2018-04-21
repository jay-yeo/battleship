package com.matritellabs.utama.jbd;

public class Main {
    public static void main(String[] args) {

        // New Game
        Game newGame = new Game();

        // Set Players
        newGame.setGamePlayer(1,"Daniel");
        newGame.setGamePlayer(2,"Balint");


//        for (Player player : newGame.getListOfPlayers()) {
//            System.out.println(player.getListOfShips());
//        }

        System.out.println(newGame);
        
        System.out.println("Game View:");
        newGame.getPlayerOne().getPlayerTable().printTable();




    }
}
