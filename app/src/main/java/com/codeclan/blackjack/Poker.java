package com.codeclan.blackjack;


import java.util.ArrayList;

public class Poker {
    private ArrayList<Player> players;
    private Deck deck;
    private ArrayList<Card> flop;
    private ArrayList<Card> turn;
    private ArrayList<Card> river;
    private ArrayList<Card> board;

    public Poker(ArrayList<Player> players, Deck deck){
        this.players = players;
        this.deck = deck;
        this.flop = new ArrayList<Card>();
        this.turn = new ArrayList<Card>();
        this.river = new ArrayList<Card>();
        this.board = new ArrayList<Card>();
    }

    public ArrayList<Card> getFlop() {
        return flop;
    }

    public ArrayList<Card> getTurn() {
        return turn;
    }

    public ArrayList<Card> getRiver() {
        return river;
    }

    public int cardCount(ArrayList<Card> board){
        return board.size();
    }

    public void deal(){
            for (Player player : players) {
                deck.dealCard(player);
                deck.dealCard(player);
            }
        }

    public void addToFlop() {
        deck.moveCard(flop);
        deck.moveCard(flop);
        deck.moveCard(flop);
    }

    public void addToTurn() {
        deck.moveCard(turn);
    }

    public void addToRiver() {
        deck.moveCard(river);
    }

    public ArrayList<Card> getBoard(){
        board.addAll(flop);
        board.addAll(turn);
        board.addAll(river);
        return board;
    }





}
