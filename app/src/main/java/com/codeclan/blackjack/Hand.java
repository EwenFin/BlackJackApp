package com.codeclan.blackjack;

import java.util.*;

public class Hand {

    private ArrayList<Card> hand;

    public Hand(){
        this.hand = new ArrayList<Card>();

    }

    public int cardCount(){
        return hand.size();
    }

    public ArrayList getHand(){
        return this.hand;
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }

    public void discardHand(){
        hand.clear();
    }

    public int handValue() {
        int result = 0;
        for (Card card : hand) {
            result = result + card.cardValue();

        }
        return result;

    }


    public String showHand(){
        String result = "";
        for(Card card : hand){
            result = result + card.showCard() + "  ";
        }
        return result;
    }



}