package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame{

    public final String GAME_NAME = "Snap";
    private boolean isGameFinished = false;
    private ArrayList<Card> usedCards = new ArrayList<>();
    private ArrayList<Player> playerList = new ArrayList<>();

    private String endState = "player lose";
    private Scanner snapInput = new Scanner(System.in);
    private boolean timeUp = false;

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            System.out.println("You missed the snap! Keep playing...");
            timeUp = true;
        }
    };

    public void checkForSnap(TimerTask task) {
        Timer timer = new Timer();
        timeUp = false;

        //Make timer 2s
        timer.schedule( task, 2*1000 );
        String checkSnap = snapInput.nextLine();
        timer.cancel();

        //Check if snapped on time
        if (!timeUp && checkSnap.equalsIgnoreCase("snap")){
            endState = "player win";
            isGameFinished = true;

        } else if (timeUp) {
            System.out.println("You're too late!");
        }
    }

    public void playSinglePlayer() {
        this.isGameFinished = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Let's play snap!");
        System.out.println("Single player: match card symbols only, press enter to deal your card");
        System.out.println("E.g. 7♥ matches 7♤");
        System.out.println(" ");
        System.out.println("Press Enter to start");
        String start = input.nextLine();

        while (!isGameFinished){
            System.out.println(" ");
            this.shuffleDeck();

            //Deal first card
            Card card1 = this.dealCard();
            usedCards.add(card1);
            System.out.println(card1);

            //Wait for player to deal
            String wait = input.nextLine();

            //Shuffle so don't get same top card
            this.shuffleDeck();

            //Deal second card
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

        //Instructions
        System.out.println("Let's play Snap!");
        System.out.println(" ");
        System.out.println("Multiplayer: take turns to deal your cards, match card symbols only");
        System.out.println("E.g. 7♥ matches 7♤");
        System.out.println(" ");
        System.out.println(numberOfPlayers + " players will receive " + this.getCardDeck().size() / numberOfPlayers + " cards each");

        //Add needed Players
        for (int i=0; i<numberOfPlayers; i++){
            //Add a new player
            playerList.add(new Player(i+1));

            //Get name for player
            Scanner in = new Scanner(System.in);
            System.out.println("Enter name for Player " + playerList.get(i).playerNumber + ":");
            playerList.get(i).setName(in.nextLine());


            //Deal the player a hand
            int initialIndex = (this.getCardDeck().size() / numberOfPlayers) * i;
            int finalIndex = ((this.getCardDeck().size() / numberOfPlayers) * playerList.get(i).playerNumber);
            //Create copy of list so separate from og card deck
            playerList.get(i).cardHand = new ArrayList<>(this.getCardDeck().subList(initialIndex, finalIndex)) ;

        }

        Scanner input = new Scanner(System.in);

        //Game start instructions
        System.out.println("Type snap and press enter when you see a snap to win!");
        System.out.println("Press enter to start");
        String start = input.nextLine();

        //Initial card
        //Get last card of deck - if 52 does not neatly divide into numPlayers this is even better
        Card card1 = this.getCardDeck().get(this.getCardDeck().size() - 1);
        //Initialise card2 for reassignment
        Card card2;


        while (!isGameFinished){
            //Loop through player turns
            for (int i = 0; i < numberOfPlayers; i++) {
                System.out.println("    ");
                System.out.println("    ");

                //Display card to match
                System.out.println("Top card: " + card1);

                //Wait for input
                System.out.println("Player " + playerList.get(i).getName() + "'s turn");
                String wait = input.nextLine();

                //If player runs out of cards, game over
                if (playerList.get(i).cardHand.size() == 0){
                    endState = "no cards left";
                    endGame(endState, playerList.get(i).getName());
                    break;
                }

                //Deal card; remove from hand as has been played
                card2 = playerList.get(i).cardHand.remove(0);
                System.out.println(card2);

                //Check if equal to prev card
                if (card1.getValue() == card2.getValue()){
                    //If so run timer to write snap
                    checkForSnap(task);
                    //Can't break loop in separate function so check here
                    if (isGameFinished){
                        endGame(endState, playerList.get(i).getName());
                        break;
                    }

                } else {
                    //If not carry on
                    System.out.println("No match!");
                    card1 = card2;
                }
            }
        }
    }

    public void endGame(String endState, String player) {
        switch (endState){
            case "player win":
                System.out.println("Player " + player + " wins!");
                break;

            case "no cards left":
                System.out.println("You've run out of cards!");
                break;

            case "player lose":
            default:
                System.out.println("You lost :(");
                break;
        }
    }

}
