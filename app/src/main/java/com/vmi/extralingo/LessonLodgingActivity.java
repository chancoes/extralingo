package com.vmi.extralingo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class LessonLodgingActivity extends AppCompatActivity {

    String originalURL = "https://ba79dc44-7e08-463a-aded-7eb164b16714-00-2a6h01tfr8pef.janeway.repl.co/assist?prompt=";
    String chatResponse = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_food);

        Button btn_lessonOverviewAction = findViewById(R.id.btn_return_lesson_overview_food);
        Button btnSendChat = findViewById(R.id.btn_send_lesson_food);

        TextInputEditText inputTextBox = findViewById(R.id.txt_chatInput_food);
        TextInputEditText outputTextBox = findViewById(R.id.txt_chatOutput_food);
//      CHAT GPT INTEGRATION
        btnSendChat.setOnClickListener(v -> {
            String chatInput = inputTextBox.getText().toString();
            Log.w("User Input", chatInput);

            chatGPT(chatInput, outputTextBox, inputTextBox);
//            outputTextBox.setText(chatResponse);
        });

//      PAGE SWITCHES
        pageSwitchLessonOverview(btn_lessonOverviewAction);
    }

    public void pageSwitchLessonOverview(Button btn_lessonOverview){
        btn_lessonOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonLodgingActivity.this, LessonOverviewActivity.class));
            }
        });
    }

    public void chatGPT(String userInput, TextInputEditText outputBox, TextInputEditText inputBox){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String getURL = originalURL + encodeValue(userInput);
        Log.w("Updated URL: ", getURL);
        String chatOutput;
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                getURL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Rest Response: ", response.toString());
                        inputBox.setText("");
                        chatResponse = response.toString();
                        outputBox.setText(chatResponse.substring(chatResponse.indexOf(":") + 2, chatResponse.length() - 2));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response Error: ", error.toString());
                        outputBox.setText(error.toString());
                    }
                }
        );
        requestQueue.add(objectRequest);
        getURL = originalURL;
    }

    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
