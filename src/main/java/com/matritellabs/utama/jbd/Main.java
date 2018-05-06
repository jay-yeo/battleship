package com.matritellabs.utama.jbd;

// Battleship by torpedoTeam-2 v0.1.0-beta.1
// https://github.com/jay-yeo/battleship

public class Main {
    public static void main(String[] args) {

        // Start new game
        Game newGame = new Game();

        // Game menu
        newGame.gameMenu();

        // Setup players
        newGame.setGamePlayers();

        // Place ships
        newGame.setGameShips();

        // Gameplay
        newGame.gamePlay();

    }
}
