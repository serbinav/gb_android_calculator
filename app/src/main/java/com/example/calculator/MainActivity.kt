package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prefs: StorageThemes
    private lateinit var presenter: MainContract.Presenter<MainContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prefs = StorageThemes(this)
        setTheme(prefs.themes.resource)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainPresenter(LocalModel())

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
            background.numpad.btnDiscard.setOnClickListener { clickButtonDiscard() }
            background.numpad.btnChangeSymbol.setOnClickListener { clickButtonChangeSymbol() }
            background.numpad.btnPercent.setOnClickListener { clickButtonPercent() }
            background.numpad.btnDelete.setOnClickListener { clickButtonDelete() }
            background.numpad.btnDivide.setOnClickListener { clickButtonDivide() }
            background.numpad.btnMultiply.setOnClickListener { clickButtonMultiply() }
            background.numpad.btnMinus.setOnClickListener { clickButtonMinus() }
            background.numpad.btnDot.setOnClickListener { clickButtonDot() }
            background.numpad.btnEquals.setOnClickListener { clickButtonEquals() }
            background.numpad.btnPlus.setOnClickListener { clickButtonPlus() }
            background.numpad.btnZero.setOnClickListener { clickButtonZero() }
            background.numpad.btnOne.setOnClickListener { clickButtonOne() }
            background.numpad.btnTwo.setOnClickListener { clickButtonTwo() }
            background.numpad.btnThree.setOnClickListener { clickButtonThree() }
            background.numpad.btnFour.setOnClickListener { clickButtonFour() }
            background.numpad.btnFive.setOnClickListener { clickButtonFive() }
            background.numpad.btnSix.setOnClickListener { clickButtonSix() }
            background.numpad.btnSeven.setOnClickListener { clickButtonSeven() }
            background.numpad.btnEight.setOnClickListener { clickButtonEight() }
            background.numpad.btnNine.setOnClickListener { clickButtonNine() }
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

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }

    override fun clickButtonDiscard() {
        presenter.discard()
    }

    override fun clickButtonChangeSymbol() {
        presenter.changeSymbol()
    }

    override fun clickButtonPercent() {
        presenter.percent()
    }

    override fun clickButtonDelete() {
        presenter.delete()
    }

    override fun clickButtonDivide() {
        presenter.divide()
    }

    override fun clickButtonMultiply() {
        presenter.multiply()
    }

    override fun clickButtonMinus() {
        presenter.minus()
    }

    override fun clickButtonDot() {
        presenter.dot()
    }

    override fun clickButtonPlus() {
        presenter.plus()
    }

    override fun clickButtonZero() {
        presenter.addNumber("0")
    }

    override fun clickButtonOne() {
        presenter.addNumber("1")
    }

    override fun clickButtonTwo() {
        presenter.addNumber("2")
    }

    override fun clickButtonThree() {
        presenter.addNumber("3")
    }

    override fun clickButtonFour() {
        presenter.addNumber("4")
    }

    override fun clickButtonFive() {
        presenter.addNumber("5")
    }

    override fun clickButtonSix() {
        presenter.addNumber("6")
    }

    override fun clickButtonSeven() {
        presenter.addNumber("7")
    }

    override fun clickButtonEight() {
        presenter.addNumber("8")
    }

    override fun clickButtonNine() {
        presenter.addNumber("9")
    }

    override fun clickButtonEquals() {
        presenter.equals()
    }

    override fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun setOperationsText(text: String) {
        binding.operationsText.text = text
    }

    override fun setInputText(text: String) {
        binding.inputText.setText(text)
    }
}
