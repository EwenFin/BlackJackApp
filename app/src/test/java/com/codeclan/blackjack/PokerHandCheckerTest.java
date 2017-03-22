package com.codeclan.blackjack;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class PokerHandCheckerTest {

    Poker poker;

    Player player1;
    Player player2;
    ArrayList<Player> players;
    Hand player1hand;
    Hand player2hand;
    ArrayList<Card> board;

    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;
    Card card6;
    Card card7;
    Card card8;
    Card card9;

    Deck deck;

    PokerHandChecker checker1;
    PokerHandChecker checker2;

    @Before
    public void before() {
        deck = new Deck();
        players = new ArrayList<Player>();
        board = new ArrayList<Card>();
        player1hand = new Hand();
        player2hand = new Hand();
        player1 = new Player("Ewen", player1hand);
        player2 = new Player("Steven", player2hand);
        players.add(player1);
        players.add(player2);
        poker = new Poker(players, deck);
        card1 = new Card(Suit.HEARTS, Rank.KING);
        card2 = new Card(Suit.DIAMONDS, Rank.JACK);
        card3 = new Card(Suit.SPADES, Rank.ACE);
        card4 = new Card(Suit.CLUBS, Rank.FOUR);
        card5 = new Card(Suit.HEARTS, Rank.TEN);
        card6 = new Card(Suit.HEARTS, Rank.ACE);
        card7 = new Card(Suit.HEARTS, Rank.FOUR);
        card8 = new Card(Suit.HEARTS, Rank.JACK);
        card9 = new Card(Suit.SPADES, Rank.JACK);
        checker1 = new PokerHandChecker(player1hand,board);
        checker2 = new PokerHandChecker(player2hand,board);


    }

    @Test
    public void testHighCard(){
        player1hand.addCardToHand(card3);
        player1hand.addCardToHand(card9);
        player2hand.addCardToHand(card2);
        player2hand.addCardToHand(card7);
        assertEquals(14, checker1.highCard());
        assertEquals(10, checker2.highCard());
    }


    @Test
    public void testPair(){
        player1hand.addCardToHand(card9);
        player1hand.addCardToHand(card1);
        player2hand.addCardToHand(card8);
        player2hand.addCardToHand(card7);
        board.add(card2);
        board.add(card3);
        board.add(card4);
        board.add(card5);
        board.add(card6);
        assertEquals(PokerHandRank.PAIR, checker1.multipleKinds());

    }

    @Test
    public void testFourOfAKind(){
        card3 = new Card (Suit.CLUBS, Rank.JACK);
        player1hand.addCardToHand(card8);
        player1hand.addCardToHand(card9);
        board.add(card3);
        board.add(card2);
        board.add(card4);
        board.add(card5);
        board.add(card6);
        assertEquals(PokerHandRank.FOUR_OF_A_KIND, checker1.multipleKinds());
    }

    @Test
    public void testThreeOfAKind(){
        player1hand.addCardToHand(card8);
        player1hand.addCardToHand(card9);
        board.add(card3);
        board.add(card2);
        board.add(card4);
        board.add(card5);
        board.add(card6);
        assertEquals(PokerHandRank.THREE_OF_A_KIND, checker1.multipleKinds());
    }

    @Test
    public void testIsFlush(){
        player1hand.addCardToHand(card1);
        player1hand.addCardToHand(card5);
        board.add(card6);
        board.add(card7);
        board.add(card8);
        board.add(card9);
        board.add(card2);
        assertEquals(PokerHandRank.FLUSH, checker1.isFlush());

    }

    @Test
    public void testisStraight(){
        player1hand.addCardToHand(card1);
        player1hand.addCardToHand(card2);
        Card card3 = new Card(Suit.HEARTS, Rank.NINE);
        Card card4 = new Card(Suit.SPADES, Rank.QUEEN);
        board.add(card3);
        board.add(card4);
        board.add(card5);
        board.add(card9);
        board.add(card7);
        assertEquals(PokerHandRank.STRAIGHT, checker1.isStraight());
    }



}
