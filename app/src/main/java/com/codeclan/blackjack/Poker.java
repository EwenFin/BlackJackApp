package com.codeclan.blackjack;


import java.util.ArrayList;

public class Poker {
    private ArrayList<Player> players;
    private Deck deck;

    public Poker(ArrayList<Player> players, Deck deck){
        this.players = players;
        this.deck = deck;
    }

    public void deal(){
        for(int i = 0; i < 5; i++) {
            for (Player player : players) {
                deck.dealCard(player);
            }
        }
    }
}
