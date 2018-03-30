package com.gashere.gashere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gashere.gashere.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView txtRegister = (TextView)findViewById(R.id.txtRegister);
        txtRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtRegister:
                //intent(donde estoy, a donde voy)
                Intent intent = new Intent(this, CreateAccountActivity.class);
                startActivity(intent);
                break;
        }
    }
}
