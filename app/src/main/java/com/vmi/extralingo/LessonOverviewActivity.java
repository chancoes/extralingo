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
        ImageButton btn_weatherAction = findViewById(R.id.btn_menu_weather_lesson);
        ImageButton btn_transportAction = findViewById(R.id.btn_menu_transport_lesson);

        Button btn_signOut = findViewById(R.id.btn_signOutLessons);

        pageSwitchSignOut(btn_signOut);
        pageSwitchFoodLesson(btn_foodLessonAction);
        pageSwitchLodgingLesson(btn_lodgingLessonAction);
        pageSwitchWeatherLesson(btn_weatherAction);
        pageSwitchTransportLesson(btn_transportAction);


    }

    public void pageSwitchTransportLesson(ImageButton btn_transport_lesson){
        btn_transport_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonOverviewActivity.this, LessonTransportActivity.class));
            }
        });
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

    public void pageSwitchSignOut(Button btn_signOut){
        btn_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonOverviewActivity.this, MainActivity.class));
            }
        });
    }
}
