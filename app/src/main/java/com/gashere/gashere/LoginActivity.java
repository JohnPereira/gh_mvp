package com.gashere.gashere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gashere.gashere.view.ContainerActivity;
import com.gashere.gashere.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView txtRegister = (TextView)findViewById(R.id.txtRegister);
        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        txtRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtRegister:
                //intent(donde estoy, a donde voy)
                Intent intentRegister = new Intent(this, CreateAccountActivity.class);
                startActivity(intentRegister);
                break;
            case R.id.btnLogin:
                Intent intentContainer = new Intent(this, ContainerActivity.class);
                startActivity(intentContainer);
                break;
        }
    }
}
