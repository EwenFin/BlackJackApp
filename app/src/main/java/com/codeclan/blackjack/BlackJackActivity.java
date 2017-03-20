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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BlackJackActivity extends AppCompatActivity {

    TextView gameText;
    TextView yourhandtext;
    TextView yournewhandtext;
    TextView dealerhandtext;
    TextView winnertext;
    ImageView card1image;
    ImageView card2image;
    ImageView card3image;
    ImageView card4image;
    ImageView card5image;
    ImageView card6image;
    ImageView card7image;
    ImageView card8image;
    ImageView card9image;
    ImageView card10image;
    BlackJack blackJack;
    Player player1;
    Dealer dealer;
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
        dealer = new Dealer("Dealer", dealerhand);
        players.add(player1);
        players.add(dealer);
        blackJack = new BlackJack(players, deck);


        gameText = (TextView) findViewById(R.id.game_text);
        gameText.setText("Welcome to the BlackJack Table " + name);
    }


    public void onDealButtonClicked(View view) {

        player1hand.discardHand();
        dealerhand.discardHand();
        deck.shuffle();
        blackJack.deal();


        Card card1 = (Card)player1hand.getHand().get(0);
        Card card2 = (Card)player1hand.getHand().get(1);
        Card card6 = (Card) dealerhand.getHand().get(0);

        int card1id = card1.GetCardDrawableId(this);
        int card2id = card2.GetCardDrawableId(this);
        int card6id = card6.GetCardDrawableId(this);
        int card7id = this.getResources().getIdentifier("card_back", "drawable", "com.codeclan.blackjack");

        card1image = (ImageView)findViewById(R.id.card1image);
        card1image.setImageResource(card1id);
        card2image = (ImageView)findViewById(R.id.card2image);
        card2image.setImageResource(card2id);
        card6image = (ImageView)findViewById(R.id.card6image);
        card6image.setImageResource(card6id);
        card7image = (ImageView)findViewById(R.id.card7image);
        card7image.setImageResource(card7id);


        card3image = (ImageView)findViewById(R.id.card3image);
        card3image.setImageResource(android.R.color.transparent);
        card4image = (ImageView)findViewById(R.id.card4image);
        card4image.setImageResource(android.R.color.transparent);
        card5image = (ImageView)findViewById(R.id.card5image);
        card5image.setImageResource(android.R.color.transparent);


        card8image = (ImageView)findViewById(R.id.card8image);
        card8image.setImageResource(android.R.color.transparent);
        card9image = (ImageView)findViewById(R.id.card9image);
        card9image.setImageResource(android.R.color.transparent);
        card10image = (ImageView)findViewById(R.id.card10image);
        card10image.setImageResource(android.R.color.transparent);


        String yourhand = player1hand.showHand();
        yourhandtext = (TextView)findViewById(R.id.your_hand_text);
        yournewhandtext = (TextView)findViewById(R.id.your_new_hand_text);
        winnertext = (TextView)findViewById(R.id.winner_text);

        winnertext.setText("");
        yournewhandtext.setText("");
        yourhandtext.setText("You have " + yourhand + " for a score of " + player1hand.handValue());
        if (player1hand.handValue() == 21){
            yourhandtext.setText("BLACKJACK, You Win!");

        }
        dealerhandtext = (TextView)findViewById(R.id.dealer_hand);
        dealerhandtext.setText("The Dealer is showing the " + card6.showCard());
    }

    public void onHitButtonClicked(View view) {
        deck.shuffle();
        blackJack.hit(player1);
        String yourhand = player1hand.showHand();
        Card dealerCard = (Card) dealerhand.getHand().get(0);
        yourhandtext = (TextView) findViewById(R.id.your_hand_text);
        yourhandtext.setText("");

        if (player1hand.cardCount() == 3) {
            Card card3 = (Card) player1hand.getHand().get(2);
            int card3id = card3.GetCardDrawableId(this);

            card3image = (ImageView) findViewById(R.id.card3image);
            card3image.setImageResource(card3id);
        } else if (player1hand.cardCount() == 4) {
            Card card4 = (Card) player1hand.getHand().get(3);
            int card4id = card4.GetCardDrawableId(this);

            card4image = (ImageView) findViewById(R.id.card4image);
            card4image.setImageResource(card4id);
        } else if (player1hand.cardCount() == 5) {
            Card card5 = (Card) player1hand.getHand().get(4);
            int card5id = card5.GetCardDrawableId(this);

            card5image = (ImageView) findViewById(R.id.card5image);
            card5image.setImageResource(card5id);
        }

        yournewhandtext = (TextView) findViewById(R.id.your_new_hand_text);
        yournewhandtext.setText("You have " + yourhand + " for a score of " + player1hand.handValue());
        dealerhandtext = (TextView)findViewById(R.id.dealer_hand);
        dealerhandtext.setText("The Dealer is showing the " + dealerCard.showCard());

        if (player1hand.handValue() > 21) {
            yourhandtext.setText("YOU'VE BUSTED OUT");
            yournewhandtext.setText("");
            winnertext.setText("The Dealer wins with "+ dealerhand.handValue());
            Card card7 = (Card) dealerhand.getHand().get(1);
            int card7id = card7.GetCardDrawableId(this);
            card7image = (ImageView) findViewById(R.id.card7image);
            card7image.setImageResource(card7id);

        }


    }
    public void onStayButtonClicked(View view) {
        yourhandtext = (TextView) findViewById(R.id.your_hand_text);
        yourhandtext.setText("Your score is:" + player1hand.handValue());

        Card card7 = (Card) dealerhand.getHand().get(1);
        int card7id = card7.GetCardDrawableId(this);
        card7image = (ImageView) findViewById(R.id.card7image);
        card7image.setImageResource(card7id);



        while(dealerhand.handValue() < 21 && dealerhand.handValue() <= player1hand.handValue() && player1hand.handValue() < 22) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            blackJack.hit(dealer);


            if (dealerhand.cardCount() == 3) {
                Card card8 = (Card) dealerhand.getHand().get(2);
                int card8id = card8.GetCardDrawableId(this);

                card8image = (ImageView) findViewById(R.id.card8image);
                card8image.setImageResource(card8id);

            } else if (dealerhand.cardCount() == 4) {

                Card card9 = (Card) dealerhand.getHand().get(3);
                int card9id = card9.GetCardDrawableId(this);

                card9image = (ImageView) findViewById(R.id.card9image);
                card9image.setImageResource(card9id);

            } else if (dealerhand.cardCount() == 5) {

                Card card10 = (Card) dealerhand.getHand().get(4);
                int card10id = card10.GetCardDrawableId(this);

                card10image = (ImageView) findViewById(R.id.card10image);
                card10image.setImageResource(card10id);
            }
        }


        String dealerhas = dealerhand.showHand();
        dealerhandtext = (TextView)findViewById(R.id.dealer_hand);
        dealerhandtext.setText("The dealer has " + dealerhas + " for a score of " + dealerhand.handValue());
        String dealerwinner = "The Dealer wins with "+ dealerhand.handValue();
        String userwinner = player1.getName() + " wins with " + player1hand.handValue();

        if(dealerhand.handValue() >= player1hand.handValue() && dealerhand.handValue() < 22 || player1hand.handValue() > 21){
            winnertext = (TextView)findViewById(R.id.winner_text);
            winnertext.setText(dealerwinner);
        }
        else{
            winnertext = (TextView)findViewById(R.id.winner_text);
            winnertext.setText(userwinner);
        }


    }


}





