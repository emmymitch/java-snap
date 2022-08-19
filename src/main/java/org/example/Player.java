package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {

    int playerNumber;
    String name;
    List<Card> cardHand;


    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        this.name = String.valueOf(playerNumber);
        cardHand = new ArrayList<>();
    }

    public Player(int playerNumber, String name) {
        this.playerNumber = playerNumber;
        this.name = name;
        cardHand = new ArrayList<>();
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
