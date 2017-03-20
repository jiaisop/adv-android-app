package com.jia.adv;


import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//import com.jia.adv.SocketService.LocalBinder;
//import com.jia.adv.MyService.MyServerBind;

import java.net.*;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    //MyService heyService;
    boolean isBound = false;
    EditText ipAddr, portNumber;
    String thisAddress;
    String thisPort;

    /*
    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyServerBind binder = (MyServerBind) service;
            heyService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
        }
    };
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent i = new Intent(this, MyService.class);
        //bindService(i, myConnection, Context.BIND_AUTO_CREATE);

        //ipAddr = (EditText)findViewById(R.id.input_ip_addr);
        //portNumber = (EditText)findViewById(R.id.input_port);
    }

    @Override
    public void onBackPressed() {
    }

    public void advConnect(View view){
        /*
        //testConnect(ipAddr.getText().toString(), Integer.parseInt(portNumber.getText().toString();
        String currentTime = heyService.getCurrentTime();
        TextView myText = (TextView)findViewById(R.id.input_ip_addr);
        myText.setText(currentTime);
        */
        EditText ipAddr = (EditText)findViewById(R.id.input_ip_addr);
        thisAddress = ipAddr.getText().toString();
    }

    public void automaticControl(View view){
        if(thisAddress != null) {
            Intent intent = new Intent(this, automatic_control.class);
            intent.putExtra("sendAddress", thisAddress);
            startActivity(intent);
        }
    }

    public void manualControl(View view){
        if(thisAddress != null) {
            Intent intent = new Intent(this, manual_control.class);
            intent.putExtra("sendAddress", thisAddress);
            startActivity(intent);
        }
    }

    public void vehicleCamera(View view){
        if(thisAddress != null) {
            Intent intent = new Intent(this, camera_control.class);
            intent.putExtra("sendAddress", thisAddress);
            startActivity(intent);
        }
    }

    public void enterDatabase(View view){
        Intent intent = new Intent(this, database_control.class);
        startActivity(intent);
    }
}
