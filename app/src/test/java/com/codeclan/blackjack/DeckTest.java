package com.codeclan.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DeckTest{

    Deck deck;

    Hand hand;
    Card card1;
    Card card2;
    Card card3;

    Player player1;

    @Before
    public void before(){
        hand = new Hand();
        player1 = new Player("Ewen", hand);
        deck = new Deck();
        card1 = new Card(Suit.HEARTS, Rank.KING);
        card2 = new Card(Suit.DIAMONDS, Rank.JACK);
        card3 = new Card(Suit.SPADES, Rank.ACE);
    }

    @Test
    public void canAddCardToDeck(){
        deck.addCardToDeck(card1);
        assertEquals(53, deck.cardCount());
    }

    @Test
    public void canRemoveCardFromDeck(){
        deck.addCardToDeck(card1);
        deck.addCardToDeck(card2);
        assertEquals(54, deck.cardCount());
        deck.removeCardFromDeck(card1);
        assertEquals(53,deck.cardCount());
    }

    @Test
    public void canDeal(){
        deck.addCardToDeck(card1);
        deck.addCardToDeck(card2);
        deck.addCardToDeck(card3);
        deck.deal(player1);
        assertEquals(1, player1.hand.cardCount());
        assertEquals(54 , deck.cardCount());
    }

    @Test
    public void fullDeck(){
        assertEquals(52, deck.cardCount());
    }
}