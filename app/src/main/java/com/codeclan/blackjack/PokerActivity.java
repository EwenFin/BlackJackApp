package com.codeclan.blackjack;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class PokerActivity extends AppCompatActivity {

    TextView gameText;

    ImageView card1image;
    ImageView card2image;
    ImageView card3image;
    ImageView card4image;
    ImageView card5image;
    ImageView card6image;
    ImageView card7image;
    ImageView card8image;
    ImageView card9image;

    Poker poker;
    Player player1;
    Player player2;
    ArrayList<Player> players;
    Deck deck;
    Hand player1hand;
    Hand player2hand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("Name");
        deck = new Deck();
        player1hand = new Hand();
        player2hand = new Hand();
        players = new ArrayList<Player>();
        player1 = new Player(name, player1hand);
        player2 = new  Player ("House", player2hand);
        players.add(player1);
        players.add(player2);
        poker = new Poker(players, deck);

        gameText = (TextView) findViewById(R.id.game_text);
        gameText.setText("Welcome to the Poker Table " + name);

    }

    public void onPokerDealButtonClicked(View view) {

        MediaPlayer player = MediaPlayer.create(this, R.raw.cardfan);
        player.start();
        player1hand.discardHand();
        player2hand.discardHand();
        deck.shuffle();
        poker.deal();

        Card card1 = (Card) player1hand.getHand().get(0);
        Card card2 = (Card) player1hand.getHand().get(1);
        Card card3 = (Card) player2hand.getHand().get(0);
        Card card4 = (Card) player2hand.getHand().get(1);

        int card1id = card1.GetCardDrawableId(this);
        int card2id = card2.GetCardDrawableId(this);
        int card3id = this.getResources().getIdentifier("card_back", "drawable", "com.codeclan.blackjack");
        int card4id = this.getResources().getIdentifier("card_back", "drawable", "com.codeclan.blackjack");

        card1image = (ImageView) findViewById(R.id.card1image);
        card1image.setImageResource(card1id);
        card2image = (ImageView) findViewById(R.id.card2image);
        card2image.setImageResource(card2id);
        card3image = (ImageView) findViewById(R.id.card3image);
        card3image.setImageResource(card3id);
        card4image = (ImageView) findViewById(R.id.card4image);
        card4image.setImageResource(card4id);
    }


}
