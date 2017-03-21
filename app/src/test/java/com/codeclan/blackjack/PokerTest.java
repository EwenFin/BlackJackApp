package com.codeclan.blackjack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class PokerTest {

    Poker poker;

    Player player1;
    Player player2;
    ArrayList<Player> players;
    Hand player1hand;
    Hand player2hand;

    Deck deck;

    @Before
    public void before(){
        deck = new Deck();
        players = new ArrayList<Player>();
        player1hand = new Hand();
        player2hand = new Hand();
        player1 = new Player("Ewen", player1hand);
        player2 = new Player("Steven", player2hand);
        players.add(player1);
        players.add(player2);
        poker = new Poker( players, deck);

    }

    @Test
    public void canDeal(){
        poker.deal();
        assertEquals(5, player1hand.cardCount());
        assertEquals(5, player2hand.cardCount());
    }
}
