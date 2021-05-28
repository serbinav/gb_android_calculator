package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textOut = findViewById(R.id.text_out);
        textOut.setText("88888/666");

        EditText textInput = findViewById(R.id.text_input);
        textInput.setText("133,465465");
    }
}