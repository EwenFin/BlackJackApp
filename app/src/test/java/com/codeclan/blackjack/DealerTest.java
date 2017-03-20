package com.codeclan.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DealerTest {

    Dealer dealer;

    Hand hand;

    Card card1;
    Card card2;
    Card card3;
    Card card4;

    @Before
    public void before(){
        hand = new Hand();
        dealer = new Dealer("Dealer", hand);
        card1 = new Card(Suit.HEARTS, Rank.KING);
        card2 = new Card(Suit.DIAMONDS, Rank.SIX);
        card3 = new Card(Suit.SPADES, Rank.ACE);
        card4 = new Card(Suit.CLUBS, Rank.SEVEN);
    }

    @Test
    public void testDoesDealerHitNo(){
        hand.addCardToHand(card1);
        hand.addCardToHand(card4);
        assertEquals(false, dealer.doesdealerHit());
    }

    @Test
    public void testDoesDealerHitYes(){
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        assertEquals(true, dealer.doesdealerHit());
    }




}
