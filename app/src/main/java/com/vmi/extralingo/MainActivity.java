package com.vmi.extralingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_RegistrationPage = findViewById(R.id.btn_RegistrationPage);
        Button btn_signInAction = findViewById(R.id.btn_SignInAction);

        pageSwitchRegistration(btn_RegistrationPage);
        pageSwitchMainMenu(btn_signInAction);
    }

    public void pageSwitchMainMenu(Button btn_signIn){
        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainMenuActivity.class));
            }
        });
    }

    public void pageSwitchRegistration(Button btn_registration){
        btn_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });
    }

}