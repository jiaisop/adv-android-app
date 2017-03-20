package com.jia.adv;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.os.Handler;

public class TCPClient extends AsyncTask<Void, Void, Void> {
    String serverIP;
    int serverPort;
    String commandADV = "";
    //EditText inputCommand;
    String inputCommand;
    private OnMessageReceived mMessageListener = null;
    private String serverMessage;



    TCPClient(String addr, int port, String commandPut) {
        serverIP = addr;
        serverPort = port;
        inputCommand = commandPut;
    }

    public TCPClient(OnMessageReceived listener) {
        mMessageListener = listener;
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        Socket socket = null;
        try {
            socket = new Socket(serverIP, serverPort);

            try {
                Log.d("ClientActivity", "C: Sending command.");
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                // Control Start Here
                //String tempCommand = inputCommand.getText().toString();
                String tempCommand = inputCommand;
                out.println(tempCommand);
                Log.d("ClientActivity", "C: Sent.");
                /*

                BufferedReader inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                serverMessage = inMsg.readLine();
                Log.e("RESPONSE FROM SERVER", "S: Received Message: '" + serverMessage + "'");

                if(serverMessage != null && mMessageListener != null){
                    mMessageListener.messageReceived(serverMessage);
                    Log.e("RESPONSE FROM SERVER", "S: Received Message: '" + serverMessage + "'");
                    serverMessage = null;
                }
                */



            }
            catch (Exception e) {
                Log.e("ClientActivity", "S: Error", e);
            }
            socket.close();
            Log.d("ClientActivity", "C: Closed.");
        }
        catch (Exception e) {
            Log.e("ClientActivity", "C: Error", e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }

    public interface OnMessageReceived {
        public void messageReceived(String message);
    }
}
