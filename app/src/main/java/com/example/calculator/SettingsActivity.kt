package com.example.calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent()
        binding.apply {
            firstThemes.setOnClickListener {
                intent.putExtra(KEY_BUNDLE, ApplicationThemes.ONE_THEMES.key)
                setResult(RESULT_OK, intent)
                finish()
            }

            secondThemes.setOnClickListener {
                intent.putExtra(KEY_BUNDLE, ApplicationThemes.TWO_THEMES.key)
                setResult(RESULT_OK, intent)
                finish()
            }

            thirdThemes.setOnClickListener {
                intent.putExtra(KEY_BUNDLE, ApplicationThemes.THREE_THEMES.key)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    companion object {
        const val KEY_BUNDLE = "BUNDLE_THEMES"
    }
}