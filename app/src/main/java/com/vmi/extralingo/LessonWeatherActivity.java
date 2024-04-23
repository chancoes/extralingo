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

public class LessonWeatherActivity extends AppCompatActivity {

    String originalURL = "https://ba79dc44-7e08-463a-aded-7eb164b16714-00-2a6h01tfr8pef.janeway.repl.co/assist?prompt=";
    String chatResponse = "";

    String lessonStarter = "Let’s talk about weather in Spanish! We will only communicate in Spanish. Do your best to use cognates and context clues to help you out! If you’re stuck, use a dictionary or translation tool to help. Reply to this sentence in Spanish “¿Cómo está el clima donde estás?”";
    String lessonPrompt = "This is a Spanish lesson about weather. The text I started this message with in the parenthesis should be in Spanish. If it is not, tell me to speak in Spanish instead and ask me another question about weather. If what I said in Spanish is not logical or has spelling or grammar errors, please tell me in 1-3 sentences what the problem with it is then ask me another question about weather. If what I said in the parenthesis is in correct Spanish, please give me a quick 1-3 sentence response to that and ask me another question in Spanish to answer relating to weather.";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_weather);

        Button btn_lessonOverviewAction = findViewById(R.id.btn_return_lesson_overview_weather);
        Button btnSendChat = findViewById(R.id.btn_send_lesson_weather);

        TextInputEditText inputTextBox = findViewById(R.id.txt_chatInput_weather);
        TextInputEditText outputTextBox = findViewById(R.id.txt_chatOutput_weather);
        outputTextBox.setText(lessonStarter);
//      CHAT GPT INTEGRATION
        btnSendChat.setOnClickListener(v -> {
            String chatInput = inputTextBox.getText().toString();
            chatInput = "(" + chatInput +")" + lessonPrompt;
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
                startActivity(new Intent(LessonWeatherActivity.this, LessonOverviewActivity.class));
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
