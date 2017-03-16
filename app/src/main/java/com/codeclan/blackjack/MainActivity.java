package com.codeclan.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    EditText NameEntry;
    Button BlackJackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameEntry = (EditText)findViewById(R.id.name_entry);
        BlackJackButton = (Button)findViewById(R.id.play_blackjack);
    }

    public void onBlackJackButtonClicked(View button){
        String name = NameEntry.getText().toString();

        Intent intent = new Intent(this, BlackJackActivity.class);
        intent.putExtra("Name", name);

        startActivity(intent);
    }
}
