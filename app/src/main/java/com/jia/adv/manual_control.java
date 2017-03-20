package com.jia.adv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.net.*;

public class manual_control extends AppCompatActivity {
    Button forw, backw, tleft, tright, vstop, lUp, lDown, lStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_control);

        forw = (Button)findViewById(R.id.buttonUp);
        backw = (Button)findViewById(R.id.buttonDown);
        tleft = (Button)findViewById(R.id.buttonLeft);
        tright = (Button)findViewById(R.id.buttonRight);
        vstop = (Button)findViewById(R.id.buttonStop);
        lUp = (Button)findViewById(R.id.buttonLiftUp);
        lDown = (Button)findViewById(R.id.buttonLiftDown);
        lStop = (Button)findViewById(R.id.buttonLiftStop);

        Bundle extras = getIntent().getExtras();

        final String serverIP = extras.getString("sendAddress");
        int serverPort = 3000;

        forw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                TCPClient connectClient = new TCPClient(serverIP, serverPort, "w");
                connectClient.execute();
                //forw.setBackgroundColor(0xff00ff00);
            }
        });

        backw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                TCPClient connectClient = new TCPClient(serverIP, serverPort, "s");
                connectClient.execute();
            }
        });

        tleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                TCPClient connectClient = new TCPClient(serverIP, serverPort, "a");
                connectClient.execute();
            }
        });

        tright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                TCPClient connectClient = new TCPClient(serverIP, serverPort, "d");
                connectClient.execute();
            }
        });

        vstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                TCPClient connectClient = new TCPClient(serverIP, serverPort, "h");
                connectClient.execute();
            }
        });

        lUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                TCPClient connectClient = new TCPClient(serverIP, serverPort, "q");
                connectClient.execute();
            }
        });

        lDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                TCPClient connectClient = new TCPClient(serverIP, serverPort, "e");
                connectClient.execute();
            }
        });

        lStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                TCPClient connectClient = new TCPClient(serverIP, serverPort, " ");
                connectClient.execute();
            }
        });
    }

    public void backToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void controlForward(View view){

    }

    public void controlBackward(View view){

    }

    public void controlLeft(View view){

    }

    public void controlRight(View view){

    }

    public void controlStop(View view){

    }
}

