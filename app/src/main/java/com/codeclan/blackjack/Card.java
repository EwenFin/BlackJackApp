package com.codeclan.blackjack;

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }


    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank(){
        return this.rank;
    }

    public String showCard(){
        return this.rank.toString() + " of " + this.suit.toString();
    }

    public int cardValue(){
        int value =  this.rank.ordinal() + 1;
        int points = 0;
        points = points + value;
        if(value == 1) points += 10;
        if(value > 10) points = 10;
        return points;
    }
}