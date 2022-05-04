package com.example.calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.calculator.databinding.ActivityMainBinding

//        1.Выберите подходящее приложение,над которым вы уже работали в течение вашего обучения.
//        Возможно,это будут ранние версии приложений,написанных на MVP(Популярные библиотеки,
//        Профессиональная разработка приложений).Или Разбейте на слои приложения,
//        которые вы писали в самом начале обучения(Калькулятор,Заметки,Погода,Кино).
//        2.Напишите тесты для Презентера с использованием моков.

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prefs: StorageThemes
    private val calc = CalculatorSimple()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prefs = StorageThemes(this)
        setTheme(prefs.themes.resource)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val launcher = registerForActivityResult(
            StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                if (result.data != null) {
                    val chose = result.data!!.getStringExtra(
                        SettingsActivity.KEY_BUNDLE
                    )
                    when (chose) {
                        "second_themes" -> {
                            prefs.themes = ApplicationThemes.TWO_THEMES
                            recreate()
                        }
                        "third_themes" -> {
                            prefs.themes = ApplicationThemes.THREE_THEMES
                            recreate()
                        }
                        else -> {
                            prefs.themes = ApplicationThemes.ONE_THEMES
                            recreate()
                        }
                    }
                }
            }
        }

        binding.apply {
            background.numpad.btnDiscard.setOnClickListener {
                textInput.setText(calc.discard())
            }
            background.numpad.btnChangeSymbol.setOnClickListener{
                textInput.setText(calc.changeSymbol())
            }
            background.numpad.btnPercent.setOnClickListener{
                textInput.setText(calc.percent())
            }
            background.numpad.btnDelete.setOnClickListener{
                textInput.setText(calc.delete())
            }
            background.numpad.btnDivide.setOnClickListener{
                textInput.setText(calc.divide())
            }
            background.numpad.btnMultiply.setOnClickListener{
                textInput.setText(calc.multiply())
            }
            background.numpad.btnMinus.setOnClickListener{
                textInput.setText(calc.minus())
            }
            background.numpad.btnDot.setOnClickListener{
                textInput.setText(calc.dot())
            }
            background.numpad.btnEquals.setOnClickListener{
                val calcData = calc.equals()
                textOut.text = calcData[0]
                textInput.setText(calcData[1])
            }
            background.numpad.btnPlus.setOnClickListener{
                textInput.setText(calc.plus())
            }

            background.numpad.btnZero.setOnClickListener{
                calc.addNumber("0")
                textInput.setText("0")
            }
            background.numpad.btnOne.setOnClickListener{
                calc.addNumber("1")
                textInput.setText("1")
            }
            background.numpad.btnTwo.setOnClickListener{
                calc.addNumber("2")
                textInput.setText("2")
            }
            background.numpad.btnThree.setOnClickListener{
                calc.addNumber("3")
                textInput.setText("3")
            }
            background.numpad.btnFour.setOnClickListener{
                calc.addNumber("4")
                textInput.setText("4")
            }
            background.numpad.btnFive.setOnClickListener{
                calc.addNumber("5")
                textInput.setText("5")
            }
            background.numpad.btnSix.setOnClickListener{
                calc.addNumber("6")
                textInput.setText("6")
            }
            background.numpad.btnSeven.setOnClickListener{
                calc.addNumber("7")
                textInput.setText("7")
            }
            background.numpad.btnEight.setOnClickListener{
                calc.addNumber("8")
                textInput.setText("8")
            }
            background.numpad.btnNine.setOnClickListener{
                calc.addNumber("9")
                textInput.setText("9")
            }
        }

        binding.title.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                SettingsActivity::class.java
            )
            launcher.launch(intent)
        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
    }
}
