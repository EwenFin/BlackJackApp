package com.codeclan.blackjack;


        import java.util.*;

public class Deck {

    public ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
        buildDeck();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int cardCount(){
        return cards.size();
    }

    public void addCardToDeck(Card card){
        cards.add(card);
    }

    public void removeCardFromDeck(Card card){
        cards.remove(card);
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public Card dealCard(Player player){
            Card card = cards.get(cards.size() - 1);
            player.addCardToHand(card);
            removeCardFromDeck(card);
            return card;
        }

    public void buildDeck(){
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }
}