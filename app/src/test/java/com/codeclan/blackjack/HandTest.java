package com.codeclan.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HandTest{

    Hand hand;

    Card card1;
    Card card2;
    Card card3;


    @Before
    public void before(){
        hand = new Hand();
        card1 = new Card(Suit.HEARTS, Rank.KING);
        card2 = new Card(Suit.DIAMONDS, Rank.JACK);
        card3 = new Card(Suit.SPADES, Rank.ACE);
    }

    @Test
    public void canAddCardToHand(){
        hand.addCardToHand(card1);
        assertEquals(1, hand.cardCount());
    }

    @Test
    public void canDiscard(){
        hand.addCardToHand(card1);
        hand.discardHand();
        assertEquals(0, hand.cardCount());
    }

    @Test
    public void canShowHand(){
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        assertEquals("KING of HEARTS, JACK of DIAMONDS, ", hand.showHand());
    }

    @Test
    public void testHandValue(){
        hand.addCardToHand(card1);
        assertEquals(10, hand.handValue());
        hand.addCardToHand(card2);
        hand.addCardToHand(card3);
        assertEquals(21, hand.handValue());
    }

    @Test
    public void testGetHand(){
        hand.addCardToHand(card1);
        assertEquals(card1, hand.getHand().get(0));


    }

}