package com.gashere.gashere.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gashere.gashere.R;
import com.gashere.gashere.model.Driver;

import java.util.ArrayList;

/**
 * Created by John on 01-04-2018.
 */
/*
* Esta clase se utiliza para adaptar las listas que pasan por el constructor, elemento por elemento,
* a cada card view asignado a travez de su ViewHolder
* */
public class DriverResponseAdapter extends RecyclerView.Adapter<DriverResponseViewHolder> {

    private ArrayList<Driver> driverList;

    public DriverResponseAdapter(ArrayList<Driver> driverList) {
        this.driverList = driverList;
    }

    @Override
    public DriverResponseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_drivers_response,parent,false);
        return new DriverResponseViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(DriverResponseViewHolder holder, int position) {
        Driver driver = driverList.get(position);

        holder.userNameCard.setText(driver.getFirstName() + driver.getLastName());
        holder.estimatedTimeCard.setText(driver.getTime());
        holder.totalValueCard.setText(driver.getTotalValue());
    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }
}
