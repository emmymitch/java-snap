package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame{

    public String gameName = "Snap";
    private boolean isGameFinished = false;
    private ArrayList<Card> usedCards = new ArrayList<>();
    private ArrayList<Player> playerList = new ArrayList<>();

    public void playSinglePlayer() {
        this.isGameFinished = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Let's play snap!");
        System.out.println("Single player: match card symbols only, press enter to deal your card");
        System.out.println("E.g. 7♥ matches 7♤");
        System.out.println(" ");
        System.out.println("Press enter to start");
        String start = input.nextLine();

        while (!isGameFinished){
            System.out.println(" ");
            this.shuffleDeck();
            Card card1 = this.dealCard();
            usedCards.add(card1);
            System.out.println(card1);

            String wait = input.nextLine();

            this.shuffleDeck();

            Card card2 = this.dealCard();
            //Check if in used pile
            while (usedCards.contains(card2)){
                this.shuffleDeck();
                card2 = this.dealCard();
            }
            usedCards.add(card2);
            System.out.println(card2);


            if (card1.getValue() == card2.getValue()){
                System.out.println("Snap!");
                isGameFinished = true;

            } else {
                System.out.println("No match!");
            }
        }
    }

    public void playMultiplayer(int numberOfPlayers){
        this.isGameFinished = false;

        //Initial shuffle
        this.shuffleDeck();

        for (int i=0; i<numberOfPlayers; i++){
            //Add a new player
            playerList.add(new Player(i+1));

            //Deal the player a hand
            int initialIndex = (this.getCardDeck().size() / numberOfPlayers) * i;
            int finalIndex = ((this.getCardDeck().size() / numberOfPlayers) * playerList.get(i).playerNumber);
            playerList.get(i).cardHand = this.getCardDeck().subList(initialIndex, finalIndex);

        }

        Scanner input = new Scanner(System.in);

        System.out.println("Let's play snap!");
        System.out.println("Multiplayer: take turns to deal your cards, match card symbols only");
        System.out.println("E.g. 7♥ matches 7♤");
        System.out.println(playerList.size() + " players will receive " + this.getCardDeck().size() / numberOfPlayers + " cards each");
        System.out.println(" ");
        System.out.println("Press enter to start");
        String start = input.nextLine();

//        while (!isGameFinished){
//            System.out.println(" ");
//            this.shuffleDeck();
//            Card card1 = this.dealCard();
//            usedCards.add(card1);
//            System.out.println(card1);
//
//            String wait = input.nextLine();
//
//            this.shuffleDeck();
//
//            Card card2 = this.dealCard();
//            //Check if in used pile
//            while (usedCards.contains(card2)){
//                this.shuffleDeck();
//                card2 = this.dealCard();
//            }
//            usedCards.add(card2);
//            System.out.println(card2);
//
//
//            if (card1.getValue() == card2.getValue()){
//                System.out.println("Snap!");
//                isGameFinished = true;
//
//            } else {
//                System.out.println("No match!");
//            }
        //}
    }

}
