package com.matritellabs.utama.jbd;

import java.util.List;
import java.util.Map;

public class Game {
    public String gameName;
    public Map<String, Integer> mapOfPieces;
    public List<Player> listOfPlayers;

    // Constructor
    public Game() {
        gameName = "BattleShip";

        // Set ship pieces map
        mapOfPieces.put("Carrier", 5);
        mapOfPieces.put("Battleship", 4);
        mapOfPieces.put("Cruiser", 3);
        mapOfPieces.put("Submarine", 3);
        mapOfPieces.put("Destroyer", 2);

    }

    // Create and log new players
    public void setGamePlayer(String playerName) {

        // Create new player
        Player newPlayer = new Player();

        // Add player to listOfPlayers
        listOfPlayers.add(newPlayer);
    }

}
