package com.codeclan.blackjack;

import android.content.Context;
import android.content.Intent;
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
    ImageView yourhand2;
    ImageView yournewhand;
    BlackJack blackJack;
    Player player1;
    Player dealer;
    ArrayList<Player> players;
    Deck deck;
    Hand player1hand;
    Hand dealerhand;

    private final static int[] cardIds = new int[]{
            R.drawable.ace_of_spades,
            R.drawable.two_of_spades,
            R.drawable.three_of_spades,
            R.drawable.four_of_spades,
            R.drawable.five_of_spades,
            R.drawable.six_of_spades,
            R.drawable.seven_of_spades,
            R.drawable.eight_of_spades,
            R.drawable.nine_of_spades,
            R.drawable.ten_of_spades,
            R.drawable.jack_of_spades,
            R.drawable.queen_of_spades,
            R.drawable.king_of_spades,
            R.drawable.ace_of_clubs,
            R.drawable.two_of_clubs,
            R.drawable.three_of_clubs,
            R.drawable.four_of_clubs,
            R.drawable.five_of_clubs,
            R.drawable.six_of_clubs,
            R.drawable.seven_of_clubs,
            R.drawable.eight_of_clubs,
            R.drawable.nine_of_clubs,
            R.drawable.ten_of_clubs,
            R.drawable.jack_of_clubs,
            R.drawable.queen_of_clubs,
            R.drawable.king_of_clubs,
            R.drawable.ace_of_diamonds,
            R.drawable.two_of_diamonds,
            R.drawable.three_of_diamonds,
            R.drawable.four_of_diamonds,
            R.drawable.five_of_diamonds,
            R.drawable.six_of_diamonds,
            R.drawable.seven_of_diamonds,
            R.drawable.eight_of_diamonds,
            R.drawable.nine_of_diamonds,
            R.drawable.ten_of_diamonds,
            R.drawable.jack_of_diamonds,
            R.drawable.queen_of_diamonds,
            R.drawable.king_of_diamonds,
            R.drawable.ace_of_hearts,
            R.drawable.two_of_hearts,
            R.drawable.three_of_hearts,
            R.drawable.four_of_hearts,
            R.drawable.five_of_hearts,
            R.drawable.six_of_hearts,
            R.drawable.seven_of_hearts,
            R.drawable.eight_of_hearts,
            R.drawable.nine_of_hearts,
            R.drawable.ten_of_hearts,
            R.drawable.jack_of_hearts,
            R.drawable.queen_of_hearts,
            R.drawable.king_of_hearts,
        };

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

//    public static int getDrawable(Context context, String cardname){
//        return context.getResources().getIdentifier(cardname, "drawable", "com.codeclan.blackjack");

    }

    public void onDealButtonClicked(View view) {

        player1hand.discardHand();
        deck.shuffle();
        blackJack.deal();

        card1image = (ImageView)findViewById(R.id.card1image);
        card1image.setImageResource(card1id);
        card2image = (ImageView)findViewById(R.id.card2image);
        card2image.setImageResource(card2id);




//      String yourhand = player1hand.showHand();
//      yourhandtext = (TextView)findViewById(R.id.your_hand_text);
//      Card dealercard = (Card) dealerhand.getHand().get(0);
//      yourhandtext.setText("You have " + yourhand + " for a score of " + player1hand.handValue() + "\n \n The Dealer is showing the " + dealercard.showCard());

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





