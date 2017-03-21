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

    public void onDealButtonClicked(View view) {

        MediaPlayer player = MediaPlayer.create(this, R.raw.cardfan);
        player.start();
        player1hand.discardHand();
        player2hand.discardHand();
        deck.shuffle();
        poker.deal();




}
