package org.example;

public class Testing {

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.printCardDeck();

        Card card = game.getCardDeck().get(51);
        System.out.println(card);

//        game.sortDeckInNumberOrder();
//        game.printCardDeck();
//        game.sortDeckIntoSuits();
//        game.printCardDeck();
//        game.shuffleDeck();
//        game.printCardDeck();
//        game.shuffleDeck();
//        game.dealCard();
//        game.printCardDeck();
//        game.sortDeckIntoSuits();
//        game.printCardDeck();

        Snap snap = new Snap();
        snap.playMultiplayer(10);
    }
}
