package com.vmi.extralingo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText txt_EmailInput, txt_PasswordInput, txt_UsernameInput, txt_RePasswordInput;
    Button btn_signInPage, btn_RegisterActon;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        txt_EmailInput = findViewById(R.id.txt_EmailInput);
        txt_PasswordInput = findViewById(R.id.txt_PasswordInput);
        txt_UsernameInput = findViewById(R.id.txt_UsernameInput);
        txt_RePasswordInput = findViewById(R.id.txt_RePasswordInput);
        btn_RegisterActon = findViewById(R.id.btn_RegisterActon);
        btn_signInPage = findViewById(R.id.btn_SignInPage);
        DB = new DBHelper(this);
        btn_RegisterActon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String user = txt_UsernameInput.getText().toString();
                String pass = txt_PasswordInput.getText().toString();
                String repass = txt_RePasswordInput.getText().toString();
                String email = txt_EmailInput.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass)|| TextUtils.isEmpty(email)){
                    Toast.makeText(RegistrationActivity.this, "All fields Required", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass,email);
                            if(insert==true){
                                Toast.makeText(RegistrationActivity.this, "Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegistrationActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegistrationActivity.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegistrationActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn_signInPage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
