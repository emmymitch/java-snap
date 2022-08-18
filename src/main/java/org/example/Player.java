package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {

    int playerNumber;
    List<Card> cardHand;
    boolean isTurn;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        cardHand = new ArrayList<>();
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}
