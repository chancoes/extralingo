package com.vmi.extralingo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button btn_signOutAction = findViewById(R.id.btn_menu_signOut);
        pageSwitchSignOut(btn_signOutAction);
    }

    public void pageSwitchSignOut(Button btn_signOut){
        btn_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, MainActivity.class));
            }
        });
    }

}
