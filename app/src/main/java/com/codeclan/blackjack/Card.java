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
        return this.rank.ordinal() + 1;
    }
}