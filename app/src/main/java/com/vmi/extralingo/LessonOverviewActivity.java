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
        ImageButton btn_lodgingLessonAction = findViewById(R.id.btn_menu_lodging_lesson);
        ImageButton btn_lodgingWeatherAction = findViewById(R.id.btn_menu_weather_lesson);

        Button btn_returnMainMenu = findViewById(R.id.btn_return_main_menu);

        pageSwitchMainMenu(btn_returnMainMenu);
        pageSwitchFoodLesson(btn_foodLessonAction);
        pageSwitchLodgingLesson(btn_lodgingLessonAction);
        pageSwitchWeatherLesson(btn_lodgingWeatherAction);


    }

    public void pageSwitchWeatherLesson(ImageButton btn_weather_lesson){
        btn_weather_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonOverviewActivity.this, LessonWeatherActivity.class));
            }
        });
    }

    public void pageSwitchLodgingLesson(ImageButton btn_lodging_lesson){
        btn_lodging_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonOverviewActivity.this, LessonLodgingActivity.class));
            }
        });
    }
    public void pageSwitchFoodLesson(ImageButton btn_food_lesson){
        btn_food_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonOverviewActivity.this, LessonFoodActivity.class));
            }
        });
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
