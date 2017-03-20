package com.codeclan.blackjack;

import java.util.*;


public class Player {

    public String name;
    public Hand hand;

    public Player(){}

    public Player(String name, Hand hand){
        this.name = name;
        this.hand = hand;
    }

    public Player(String name) {
    }

    public String getName(){
        return this.name;
    }

    public Hand getHand(){
        return this.hand;
    }

    public void addCardToHand(Card card) {
        hand.addCardToHand(card);
    }

}