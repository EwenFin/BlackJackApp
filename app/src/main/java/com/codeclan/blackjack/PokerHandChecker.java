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

    public Enum multipleKinds(){
        ArrayList<Card> allCards = new ArrayList<Card>();
        ArrayList<Enum> ranks = new ArrayList<Enum>();
        allCards.addAll(hand.getHand());
        allCards.addAll(board);
        for(Card card : allCards) {
            ranks.add(card.getRank());
        }
        for(Enum rank : ranks){
        if(Collections.frequency(ranks, rank) == 4) {
            return PokerHandRank.FOUR_OF_A_KIND;
             }
        if(Collections.frequency(ranks, rank) == 3) {
            return PokerHandRank.THREE_OF_A_KIND;
            }
         if(Collections.frequency(ranks, rank) == 2){
             return PokerHandRank.PAIR;
         }

        }
        return null;


    }

    public Enum isFlush(){
        ArrayList<Card> allCards = new ArrayList<Card>();
        ArrayList<Enum> suits = new ArrayList<Enum>();
        allCards.addAll(hand.getHand());
        allCards.addAll(board);
        for(Card card : allCards) {
            suits.add(card.getSuit());
        }
        for(Enum suit : suits)
        if(Collections.frequency(suits, suit) >= 5){
            return PokerHandRank.FLUSH;
        }
        return null;

    }

    public Enum isStraight(){
        ArrayList<Card> allCards = new ArrayList<Card>();
        allCards.addAll(hand.getHand());
        allCards.addAll(board);
        Collections.sort(allCards);
        int position = 0;
        int cardsTogether = 0;
        for(int i = 0; i < 7; i ++) {
            if (allCards.get(position + 1).getRank().ordinal() - allCards.get(position).getRank().ordinal() == 1) {
                cardsTogether++;
            }
            position ++;
            if(cardsTogether >= 4){
                return PokerHandRank.STRAIGHT;

            }
        }
        return null;

    }

}
