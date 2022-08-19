package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    public String gameName;
    protected ArrayList<Card> cardDeck;
    private final String[] SUITS = {"♥", "♤", "♦", "♧"};
    private final String[] SYMBOLS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final int[] VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};


    public CardGame() {
        this.cardDeck = new ArrayList<>();
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

    protected ArrayList<Card> getCardDeck() {
        return cardDeck;
    }

    public void printCardDeck() {
        System.out.println(cardDeck.toString());
    }

    public void setCardDeck(ArrayList<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    protected Card dealCard() {
        return this.cardDeck.get(0);
    }

    public void sortDeckInNumberOrder() {
        Collections.sort(this.cardDeck, (a, b) -> a.getValue() - b.getValue());
    }

    public void sortDeckIntoSuits() {
        sortDeckInNumberOrder();
        Collections.sort(this.cardDeck, (a, b) -> a.getSuit().compareTo(b.getSuit()));
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cardDeck);
    }
}
