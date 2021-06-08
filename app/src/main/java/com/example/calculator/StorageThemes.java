package com.example.calculator;

import android.content.Context;
import android.content.SharedPreferences;

public class StorageThemes {

    private static final String KEY_APP_THEMES = "KEY_APP_THEMES";

    private SharedPreferences pref;

    public StorageThemes(Context context) {
        pref = context.getSharedPreferences("app_themes", Context.MODE_PRIVATE);
    }

    public ApplicationThemes getThemes() {
        String key = pref.getString(KEY_APP_THEMES, ApplicationThemes.ONE_THEMES.getKey());

        for (ApplicationThemes themes :
                ApplicationThemes.values()) {
            if (themes.getKey().equals(key)) {
                return themes;
            }
        }
        throw new IllegalStateException("STUB!");
    }

    public void setThemes(ApplicationThemes themes) {
        pref.edit().putString(KEY_APP_THEMES, themes.getKey()).apply();
    }
}

