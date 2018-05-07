package com.matritellabs.utama.jbd;

// Battleship by torpedoTeam-2 v0.9.0-beta
// https://github.com/jay-yeo/battleship

public class Main {
    public static void main(String[] args) {

        // Start new game
        Game newGame = new Game();

        // Game menu
        newGame.gameMenu();

        // Setup players
        newGame.setGamePlayers();

        // Special Laci EasterEgg
        if (newGame.getPlayerOne().getPlayerName().toUpperCase().equals("LACI") || newGame.getPlayerTwo().getPlayerName().toUpperCase().equals("LACI") ) {

            System.out.println("Laci Wins! \nGAME OVER");

        } else {

            // Place ships
            newGame.setGameShips();

            // Gameplay
            newGame.gamePlay();

        }



    }
}
