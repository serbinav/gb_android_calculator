package com.example.calculator

import android.content.Context
import android.content.SharedPreferences

class StorageThemes(context: Context) {

    private val pref: SharedPreferences =
        context.getSharedPreferences("app_themes", Context.MODE_PRIVATE)

    var themes: ApplicationThemes
        get() {
            val key = pref.getString(KEY_APP_THEMES, ApplicationThemes.ONE_THEMES.key)
            for (themes in ApplicationThemes.values()) {
                if (themes.key == key) {
                    return themes
                }
            }
            throw IllegalStateException("STUB!")
        }
        set(themes) {
            pref.edit().putString(KEY_APP_THEMES, themes.key).apply()
        }

    companion object {
        private const val KEY_APP_THEMES = "KEY_APP_THEMES"
    }
}