package com.vmi.extralingo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
public class LessonOverviewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_overview);

        ImageButton btn_foodLessonAction = findViewById(R.id.btn_menu_food_lesson);
        Button btn_returnMainMenu = findViewById(R.id.btn_return_main_menu);

        pageSwitchMainMenu(btn_returnMainMenu);
    }

    public void pageSwitchMainMenu(Button btn_main_menu){
        btn_main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonOverviewActivity.this, MainMenuActivity.class));
            }
        });
    }
}
