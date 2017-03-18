package com.codeclan.blackjack;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BlackJackActivity extends AppCompatActivity {

    TextView gameText;
    TextView yourhandtext;
    TextView yournewhandtext;
    ImageView card1image;
    ImageView card2image;
    ImageView card3image;
    ImageView card4image;
    ImageView card5image;
    ImageView card6image;
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
        dealerhand.discardHand();
        deck.buildDeck();
        deck.shuffle();
        blackJack.deal();

        Card card1 = (Card)player1hand.getHand().get(0);
        Card card2 = (Card)player1hand.getHand().get(1);
        Card dealerCard = (Card) dealerhand.getHand().get(0);

        int card1id = card1.GetCardDrawableId(this);
        int card2id = card2.GetCardDrawableId(this);
        int dealercardid = dealerCard.GetCardDrawableId(this);

        card1image = (ImageView)findViewById(R.id.card1image);
        card1image.setImageResource(card1id);
        card2image = (ImageView)findViewById(R.id.card2image);
        card2image.setImageResource(card2id);
        card6image = (ImageView)findViewById(R.id.card6image);
        card6image.setImageResource(dealercardid);

        String yourhand = player1hand.showHand();
        yourhandtext = (TextView)findViewById(R.id.your_hand_text);

        yourhandtext.setText("You have " + yourhand + " for a score of " + player1hand.handValue() + "\n \n The Dealer is showing the " + dealerCard.showCard());

    }

    public void onHitButtonClicked(View view){
        deck.shuffle();
        blackJack.hit(player1);
//        String yourhand = player1hand.showHand();
//        if(player1hand.handValue() > 21){
//            yournewhandtext = (TextView)findViewById(R.id.your_new_hand_text);
//            yournewhandtext.setText("You have " + yourhand + " for a score of " + player1hand.handValue() + " You've busted out!");
        }

    public void onStayButtonClicked(View view){

    }


    }





