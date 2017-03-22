package com.codeclan.blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class PokerHandChecker{

    private Hand hand;
    private ArrayList<Card> board;

public PokerHandChecker(Hand hand, ArrayList<Card> board){

    this.hand = hand;
    this.board = board;

    }

    public int highCard(){
        Collections.sort(hand.getHand());
        Card high = (Card) hand.getHand().get(1);
        Rank cardRank = high.getRank();
        int value = cardRank.ordinal();
        if(value == 0){
            value = value + 14;
        }
        return value;
    }

    public
}
