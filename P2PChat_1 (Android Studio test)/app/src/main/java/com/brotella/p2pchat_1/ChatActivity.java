package com.brotella.p2pchat_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.SocketException;

public class ChatActivity extends AppCompatActivity {

    String name;
    int sourcePort;
    String destinationIP;
    int destinationPort;
    Channel channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        sourcePort = intent.getIntExtra("sourcePort", 1111);
        destinationIP = intent.getStringExtra("destinationIP");
        destinationPort = intent.getIntExtra("destinationPort", 2222);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(null == channel)
        {
            try
            {
                channel = new Channel();
                channel.bind(sourcePort);
                channel.start();
            }
            catch (SocketException e)
            {
                e.printStackTrace();
                finish();
            }

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(null != channel)
        {
            channel.stop();
        }
    }

}
