package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame{

    public String gameName = "Snap";
    private boolean isGameFinished = false;
    private ArrayList<Card> usedCards = new ArrayList<>();

    public void play() {
        Scanner input = new Scanner(System.in);

        System.out.println("Let's play snap!");
        System.out.println("Single player: match card symbols only, press enter to deal your card");
        System.out.println("E.g. 7♥ matches 7♤");
        System.out.println(" ");
        System.out.println("Press enter to start");
        String start = input.nextLine();

        while (!isGameFinished){
            this.shuffleDeck();
            Card card1 = this.dealCard();
            usedCards.add(card1);
            System.out.println(card1);

            String wait = input.nextLine();

            this.shuffleDeck();

            Card card2 = this.dealCard();
            //Check if in used pile
            while (usedCards.contains(card2)){
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

}
