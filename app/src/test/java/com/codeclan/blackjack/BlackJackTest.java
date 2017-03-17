package com.codeclan.blackjack;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class BlackJackTest {

        BlackJack blackjack;

        Player player1;
        Player player2;
        ArrayList<Player> players;
        Hand player1hand;
        Hand player2hand;

        Card card1;
        Card card2;
        Card card3;
        Card card4;
        Card card5;

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
            blackjack = new BlackJack( players, deck);
            card1 = new Card(Suit.HEARTS, Rank.KING);
            card2 = new Card(Suit.DIAMONDS, Rank.JACK);
            card3 = new Card(Suit.SPADES, Rank.ACE);
            card4 = new Card(Suit.CLUBS, Rank.FOUR);
            card5 = new Card(Suit.HEARTS, Rank.TEN);

        }


        @Test
        public void canDealToPlayers(){
            blackjack.deal();
            assertEquals(2, player1hand.cardCount());
            assertEquals(2, player2hand.cardCount());
        }

        @Test
        public void canShowHand(){
            player1hand.addCardToHand(card1);
            player1hand.addCardToHand(card4);
            player2hand.addCardToHand(card3);
            player2hand.addCardToHand(card2);
            assertEquals("Ewen has the KING of HEARTS, FOUR of CLUBS, Steven has the ACE of SPADES, JACK of DIAMONDS, ",  blackjack.showHands());
        }

        @Test
        public void testCardRounding(){
            player1hand.addCardToHand(card1);
            player1hand.addCardToHand(card3);
            int points = blackjack.getScore(player1hand);
            assertEquals(21, points);

        }

        @Test
        public void testHit(){
            player1hand.addCardToHand(card1);
            blackjack.hit(player1);
            assertEquals(2, player1hand.cardCount());
        }



//        @Test
//        public void testWinner(){
//            player1hand.addCardToHand(card1);
//            player1hand.addCardToHand(card4);
//            player2hand.addCardToHand(card3);
//            player2hand.addCardToHand(card2);
//            assertEquals("Steven Wins with 21", game.winner(player1, player2));
//        }
//


    }



