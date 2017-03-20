package com.jia.adv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class automatic_control extends AppCompatActivity {
    Button start_car;

    EditText inputFrom, inputTo;
    View greenSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatic_control);

        start_car = (Button)findViewById(R.id.buttonGoTo);

        Bundle extras = getIntent().getExtras();

        final String serverIP = extras.getString("sendAddress");
        final int serverPort = 3000;

        start_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText inputFrom = (EditText)findViewById(R.id.input_from);
                EditText inputTo = (EditText)findViewById(R.id.input_to);
                TextView greenSet = (TextView)findViewById(R.id.greenColor);
                String sendThis = " ";


                if(inputFrom.getText().toString().equals("N")) {
                    if (inputTo.getText().toString().equals("A")) {
                        sendThis = "1";
                        greenSet.setBackgroundColor(0xff00ff00);
                    }
                    else if (inputTo.getText().toString().equals("B")) {
                        sendThis = "2";
                        greenSet.setBackgroundColor(0xff00ff00);
                    }
                    else{
                        sendThis = "Bad Command";
                        greenSet.setBackgroundColor(0xffff0000);
                    }
                }
                else if(inputFrom.getText().toString().equals("A")) {
                    if (inputTo.getText().toString().equals("N")) {
                        sendThis = "3";
                        greenSet.setBackgroundColor(0xff00ff00);
                    }
                    else if (inputTo.getText().toString().equals("B")) {
                        sendThis = "4";
                        greenSet.setBackgroundColor(0xff00ff00);
                    }
                    else{
                        sendThis = "Bad Command";
                        greenSet.setBackgroundColor(0xffff0000);
                    }
                }
                else if(inputFrom.getText().toString().equals("B")) {
                    if (inputTo.getText().toString().equals("A")) {
                        sendThis = "5";
                        greenSet.setBackgroundColor(0xff00ff00);
                    }
                    else if (inputTo.getText().toString().equals("N")) {
                        sendThis = "6";
                        greenSet.setBackgroundColor(0xff00ff00);
                    }
                    else{
                        sendThis = "Bad Command";
                        greenSet.setBackgroundColor(0xffff0000);
                    }
                }
                else{
                    sendThis = "Bad Command";
                    greenSet.setBackgroundColor(0xffff0000);
                }

                TCPClient connectClient = new TCPClient(serverIP, serverPort, sendThis);
                connectClient.execute();
            }
        });
    }

    public void inputCancel(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
