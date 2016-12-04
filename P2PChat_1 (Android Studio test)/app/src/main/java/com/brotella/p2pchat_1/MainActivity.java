package com.brotella.p2pchat_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button startButton;

    EditText nameEditText;
    EditText sourcePortEditText;
    EditText destinationIPEditText;
    EditText destinationPortEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(this);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        sourcePortEditText = (EditText) findViewById(R.id.sourcePortEditText);
        destinationIPEditText = (EditText) findViewById(R.id.destinationIPEditText);
        destinationPortEditText = (EditText) findViewById(R.id.destinationPortEditText);

    }

    @Override
    public void onClick(View v)
    {
        String name = nameEditText.getText().toString();
        int sourcePort = Integer.parseInt(sourcePortEditText.getText().toString());
        String destinationIP = destinationIPEditText.getText().toString();
        int destinationPort = Integer.parseInt(destinationPortEditText.getText().toString());

        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("sourcePort", sourcePort);
        intent.putExtra("destinationIP", destinationIP);
        intent.putExtra("destinationPort", destinationPort);

        startActivity(intent);
    }
}
