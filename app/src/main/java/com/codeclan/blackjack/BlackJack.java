package com.codeclan.blackjack;

import java.util.ArrayList;


public class BlackJack {
    private ArrayList<Player> players;
    private Deck deck;

    public BlackJack(ArrayList<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    public void addPlayerToGame(Player player){
        players.add(player);
    }

    public void deal(){
        for(Player player : players){
            deck.dealCard(player);
            deck.dealCard(player);
        }
    }


    public int getScore(Hand hand){
        int score = hand.handValue();
        return score;
    }

    public String showHands(){
        String result = "";
        for (Player player : this.players){
            result = result + player.getName() + " has the " +player.getHand().showHand();

        }
        return result;
    }
}
