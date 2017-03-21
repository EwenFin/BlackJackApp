package com.codeclan.blackjack;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {


    TextView welcome;
    ImageView welcomeImage;
    EditText NameEntry;
    Button BlackJackButton;
    Button PokerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameEntry = (EditText)findViewById(R.id.name_entry);
        BlackJackButton = (Button)findViewById(R.id.play_blackjack);
        PokerButton = (Button)findViewById(R.id.play_poker);

        welcome = (TextView)findViewById(R.id.welcome);
        welcome.setText("Welcome to CodeClanCasino, please gamble responsibly...");

        int welcomeImageId = this.getResources().getIdentifier("casino", "drawable", "com.codeclan.blackjack");
        welcomeImage = (ImageView)findViewById(R.id.welcome_image);
        welcomeImage.setImageResource(welcomeImageId);

    }



    public void onBlackJackButtonClicked(View button){
        String name = NameEntry.getText().toString();

        Intent intent = new Intent(this, BlackJackActivity.class);
        intent.putExtra("Name", name);

        startActivity(intent);
    }

    public void onPokerButtonClicked(View button){
        String name = NameEntry.getText().toString();

        Intent intent = new Intent(this, PokerActivity.class);
        intent.putExtra("Name", name);

        startActivity(intent);
    }
}
