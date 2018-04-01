package com.gashere.gashere.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.gashere.gashere.R;
import com.gashere.gashere.adapter.DriverResponseAdapter;
import com.gashere.gashere.model.Driver;

import java.util.ArrayList;

public class ResponseDriverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_driver);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        RecyclerView driversRecycler = (RecyclerView)findViewById(R.id.recyclerView_drivers);


        driversRecycler.setHasFixedSize(true);

        LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext());
        layout.setOrientation(LinearLayoutManager.VERTICAL);

        driversRecycler.setAdapter(new DriverResponseAdapter(buildDrivers()));

        driversRecycler.setLayoutManager(layout);
    }

    public ArrayList<Driver> buildDrivers(){
        ArrayList<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("John","Pereira Matus","A 5 minutos aprox.","Precio: $16000"));
        drivers.add(new Driver("Jose","Canto Toro","A 15 minutos aprox.","Precio: $14000"));
        drivers.add(new Driver("Alejandro","Correa Gonzalez","A 25 minutos aprox.","Precio: $13000"));
        drivers.add(new Driver("John","Pereira Matus","A 5 minutos aprox.","Precio: $16000"));
        drivers.add(new Driver("Jose","Canto Toro","A 15 minutos aprox.","Precio: $14000"));
        drivers.add(new Driver("Alejandro","Correa Gonzalez","A 25 minutos aprox.","Precio: $13000"));
        drivers.add(new Driver("John","Pereira Matus","A 5 minutos aprox.","Precio: $16000"));
        drivers.add(new Driver("Jose","Canto Toro","A 15 minutos aprox.","Precio: $14000"));
        drivers.add(new Driver("Alejandro","Correa Gonzalez","A 25 minutos aprox.","Precio: $13000"));
        return drivers;
    }

}
