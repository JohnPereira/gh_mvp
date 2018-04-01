package com.gashere.gashere.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gashere.gashere.R;

/**
 * Created by John on 01-04-2018.
 */

/*
Esta clase se utiliza en DriverResponseAdapter para conectarlo al card view, por eso tiene su estructura
 */
public class DriverResponseViewHolder extends RecyclerView.ViewHolder {
    //definir todos los Views que componen al CardView
    TextView userNameCard;
    TextView estimatedTimeCard;
    TextView totalValueCard;

    public DriverResponseViewHolder(View itemView) {
        super(itemView);
        userNameCard = (TextView)itemView.findViewById(R.id.txtUsernameCard);
        estimatedTimeCard = (TextView)itemView.findViewById(R.id.txtEstimatedTimeCard);
        totalValueCard = (TextView)itemView.findViewById(R.id.txtTotalValueCard);
    }


}
