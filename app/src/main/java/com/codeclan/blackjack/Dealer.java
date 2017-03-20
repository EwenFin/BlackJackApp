package com.codeclan.blackjack;




public class Dealer extends Player{

    public String name;
    public Hand hand;

    public Dealer(String name, Hand hand){
        this.name = name;
        this.hand = hand;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public boolean doesdealerHit() {
        if (this.hand.handValue() < 17){
            return true;
        }
        else return false;
    }
}
