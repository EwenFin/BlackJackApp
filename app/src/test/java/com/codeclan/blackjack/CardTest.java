package com.codeclan.blackjack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class CardTest{

    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before(){
        card1 = new Card(Suit.HEARTS, Rank.KING);
        card2 = new Card(Suit.DIAMONDS, Rank.JACK);
        card3 = new Card(Suit.SPADES, Rank.ACE);
    }

    @Test
    public void canGetSuit(){
        assertEquals(Suit.HEARTS, card1.getSuit());
        assertEquals(Suit.SPADES, card3.getSuit());
    }

    @Test
    public void canGetRank(){
        assertEquals(Rank.KING, card1.getRank());
        assertEquals(Rank.JACK, card2.getRank());
    }

    @Test
    public void canShowCard(){
        assertEquals("KING of HEARTS", card1.showCard());
    }

    @Test
    public void testCardValue(){
        assertEquals(10, card1.cardValue());
        assertEquals(11, card3.cardValue());
    }

    @Test
    public void testIsAce(){
        assertEquals(false, card1.isAce());
        assertEquals(true, card3.isAce());
    }
}
