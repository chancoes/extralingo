package com.vmi.extralingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        EditText txt_UsernameInput, txt_PasswordInput;
        Button btn_SignInAction, btn_RegistrationPage;
        DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_UsernameInput = findViewById(R.id.txt_UsernameInput);
        txt_PasswordInput = findViewById(R.id.txt_PasswordInput);
        btn_RegistrationPage = findViewById(R.id.btn_RegistrationPage);
        btn_SignInAction = findViewById(R.id.btn_SignInAction);

        btn_SignInAction.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String user = txt_UsernameInput.getText().toString();
                String pass = txt_PasswordInput.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainActivity.this, "All fields Required", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass == true){
                        Toast.makeText(MainActivity.this, "Login Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Login Failed",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        btn_RegistrationPage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }



}