package com.matritellabs.utama.jbd;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Game {
    public String gameName;
    public Map<String, Integer> mapOfPieces;
    public List<Player> listOfPlayers;

    // Constructor
    public Game() {
        gameName = "BattleShip";

        // Initalize player list
        listOfPlayers = new ArrayList<>();

        // Set ship pieces map
        mapOfPieces = new Hashtable<>();
        mapOfPieces.put("Carrier", 5);
        mapOfPieces.put("Battleship", 4);
        mapOfPieces.put("Cruiser", 3);
        mapOfPieces.put("Submarine", 3);
        mapOfPieces.put("Destroyer", 2);

    }

    public String toString() {
        String outputString = "GAME: " + gameName + "\n";
        outputString += "PLAYERS: \n";

        String playerList = "";
        for (Player name : listOfPlayers) {
            playerList += "Name: " + name.getPlayerName() + "\n";
        }

        outputString += playerList;

        return outputString;
    }

    // Create and log new players
    public void setGamePlayer(String playerName) {

        // Create new player
        Player newPlayer = new Player(playerName);

        // Add player to listOfPlayers
        listOfPlayers.add(newPlayer);
    }

}
