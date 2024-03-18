package com.vmi.extralingo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class LessonFoodActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_food);

        Button btn_lessonOverviewAction = findViewById(R.id.btn_return_lesson_overview_food);

        pageSwitchLessonOverview(btn_lessonOverviewAction);
    }

    public void pageSwitchLessonOverview(Button btn_lessonOverview){
        btn_lessonOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonFoodActivity.this, LessonOverviewActivity.class));
            }
        });
    }
}
