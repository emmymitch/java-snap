package org.example;

import java.util.ArrayList;

public class CardGame {

    public String gameName;
    protected ArrayList<Card> cardDeck = new ArrayList<>();
    private final String[] SUITS = {"♥", "♤", "♦", "♧"};
    private final String[] SYMBOLS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final int[] VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};


    public CardGame() {
        for (String suit : SUITS) {
            for (int j = 0; j < SYMBOLS.length; j++) {
                this.cardDeck.add(new Card(suit, SYMBOLS[j], VALUES[j]));
            }
        }
    }


    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    protected ArrayList<Card> getDeckArray() {
        return cardDeck;
    }

    public void setCardDeck(ArrayList<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public void getCardDeck() {
        System.out.println(cardDeck.toString());
    }

}
