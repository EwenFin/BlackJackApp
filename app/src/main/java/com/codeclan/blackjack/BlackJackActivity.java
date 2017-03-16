package com.codeclan.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class BlackJackActivity extends AppCompatActivity {

    TextView gameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("Name");
//        Deck deck = new Deck();
//        ArrayList<Player> players = new ArrayList<Player>();
        Player player1 = new Player(name);
//        Player player2 = new Player("Dealer");
//        players.add(player1);
//        players.add(player2);
//        BlackJack blackJack = new BlackJack(players, deck);
//        blackJack.deal();
//        blackJack.deal();

        gameText = (TextView)findViewById(R.id.game_text);
        gameText.setText(name + " has " + player1.hand.showHand());
    }
}
