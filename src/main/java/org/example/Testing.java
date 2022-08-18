package org.example;

public class Testing {

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.getCardDeck();
        Card card = game.getDeckArray().get(51);
        System.out.println(card);
    }
}
