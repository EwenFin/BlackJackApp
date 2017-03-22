package com.codeclan.blackjack;

import android.content.Context;

public class Card implements Comparable {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }


    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public String showCard() {
        return this.rank.toString() + " of " + this.suit.toString();
    }

    public int cardValue() {
        int value = this.rank.ordinal() + 1;
        int points = 0;
        points = points + value;
        if (value == 1) points += 10;
        if (value > 10) points = 10;
        return points;
    }

    public int GetCardDrawableId(Context context) {
        int cardDrawableId = context.getResources().getIdentifier(this.rank.toString().toLowerCase() + "_of_" + this.suit.toString().toLowerCase(), "drawable", "com.codeclan.blackjack");
        return cardDrawableId;
    }

    public boolean isAce() {
        return (this.rank == Rank.ACE);
    }

    public int compareTo(Object comp){
        Card card = (Card)comp;
        int cardRank =  card.getRank().ordinal();
        if (cardRank == 0) {
            cardRank = cardRank + 14;
        }
        int otherCardRank = this.rank.ordinal();
        if (otherCardRank == 0) {
            otherCardRank = otherCardRank + 14;
        }
        return otherCardRank - cardRank;



    }
}