package com.gashere.gashere.view;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.gashere.gashere.R;
import com.gashere.gashere.adapter.DriverResponseAdapter;
import com.gashere.gashere.model.Driver;


import org.java_websocket.WebSocket;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import ua.naiksoftware.stomp.Stomp;
import ua.naiksoftware.stomp.client.StompClient;

public class ResponseDriverActivity extends AppCompatActivity {

    private StompClient mStompClient;
    RecyclerView driversRecycler;
    DriverResponseAdapter driverResponseAdapter;
    ArrayList<Driver> drivers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_driver);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        driversRecycler = (RecyclerView)findViewById(R.id.recyclerView_drivers);
        driverResponseAdapter = new DriverResponseAdapter(drivers);
        setupRecyclerView(driverResponseAdapter);

        new Thread(new Runnable() {
            public void run() {
                mStompClient = Stomp.over(WebSocket.class, "ws://192.168.1.36:8080/gs-guide-websocket");
                mStompClient.connect();
                mStompClient.topic("/topic/client").subscribe(topicMessage -> {
                    Log.e("PAYLOAD: ",topicMessage.getPayload());
                    new StompConnectionTask().execute(topicMessage.getPayload());
                });
            }
        }).start();

    }

    public void setupRecyclerView(DriverResponseAdapter adapter){
        driversRecycler.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext());
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        driversRecycler.setAdapter(adapter);
        driversRecycler.setLayoutManager(layout);
    }

    public void addItemList(Driver driver){
        drivers.add(driver);
        driverResponseAdapter.notifyDataSetChanged();
    }


    private class StompConnectionTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Toast.makeText(ResponseDriverActivity.this, s, Toast.LENGTH_SHORT).show();
            try {
                JSONObject jsonObject = new JSONObject(s);
                String precio = jsonObject.getString("content");
                Driver d = new Driver("Alejandro","Correa Gonzalez","A 25 minutos aprox.","Precio: $"+precio);
                addItemList(d);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
