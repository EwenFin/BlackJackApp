package com.codeclan.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayerTest {

    Player player;

    Deck deck;

    Hand hand;

    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before(){
        hand = new Hand();
        player = new Player("Ewen", hand);
        deck = new Deck();
        card1 = new Card(Suit.HEARTS, Rank.KING);
        card2 = new Card(Suit.DIAMONDS, Rank.JACK);
        card3 = new Card(Suit.SPADES, Rank.ACE);
    }

    @Test
    public void hasName(){
        assertEquals("Ewen", player.getName());
    }



    @Test
    public void canDealToHand(){
        deck.addCardToDeck(card1);
        deck.addCardToDeck(card2);
        deck.addCardToDeck(card3);
        deck.dealCard(player);
        assertEquals(1, player.getHand().cardCount());
        assertEquals(54, deck.cardCount());
    }



}