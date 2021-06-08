package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    public static final String KEY_BUNDLE = "BUNDLE_THEMES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = new Intent();

        findViewById(R.id.first_themes).setOnClickListener(v -> {
            intent.putExtra(KEY_BUNDLE, ApplicationThemes.ONE_THEMES.getKey());
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

        findViewById(R.id.second_themes).setOnClickListener(v -> {
            intent.putExtra(KEY_BUNDLE, ApplicationThemes.TWO_THEMES.getKey());
            setResult(Activity.RESULT_OK, intent);
            finish();
        });

        findViewById(R.id.third_themes).setOnClickListener(v -> {
            intent.putExtra(KEY_BUNDLE, ApplicationThemes.THREE_THEMES.getKey());
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}