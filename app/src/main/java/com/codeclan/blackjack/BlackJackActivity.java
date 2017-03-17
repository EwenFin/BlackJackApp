package com.codeclan.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class BlackJackActivity extends AppCompatActivity {

    TextView gameText;
    TextView yourhandtext;
    TextView yournewhandtext;
    BlackJack blackJack;
    Player player1;
    Player dealer;
    ArrayList<Player> players;
    Deck deck;
    Hand player1hand;
    Hand dealerhand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("Name");
        deck = new Deck();
        player1hand = new Hand();
        dealerhand = new Hand();
        players = new ArrayList<Player>();
        player1 = new Player(name, player1hand);
        dealer = new Player("Dealer", dealerhand);
        players.add(player1);
        players.add(dealer);
        blackJack = new BlackJack(players, deck);


        gameText = (TextView) findViewById(R.id.game_text);
        gameText.setText("Welcome to the BlackJack Table " + name);
    }

    public void onDealButtonClicked(View view) {

        player1hand.discardHand();
        deck.shuffle();
        blackJack.deal();
        String yourhand = player1hand.showHand();
        yourhandtext = (TextView)findViewById(R.id.your_hand_text);
        Card dealercard = (Card) dealerhand.getHand().get(0);
        yourhandtext.setText("You have " + yourhand + " for a score of " + player1hand.handValue() + "\n \n The Dealer is showing the " + dealercard.showCard());

    }

    public void onHitButtonClicked(View view){
        deck.shuffle();
        blackJack.hit(player1);
        String yourhand = player1hand.showHand();
        if(player1hand.handValue() > 21){
            yournewhandtext = (TextView)findViewById(R.id.your_new_hand_text);
            yournewhandtext.setText("You have " + yourhand + " for a score of " + player1hand.handValue() + " You've busted out!");
        }


    }

}



