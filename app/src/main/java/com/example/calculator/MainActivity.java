package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int[] numberButtonIds = new int[]{R.id.btn_zero, R.id.btn_one, R.id.btn_two,
            R.id.btn_three, R.id.btn_four, R.id.btn_five, R.id.btn_six, R.id.btn_seven,
            R.id.btn_eight, R.id.btn_nine};

    TextView textOut;
    EditText textInput;
    Button buttonDiscard, buttonChangeSymbol, buttonPercent, buttonDelete, buttonDivide,
            buttonMultiply, buttonMinus, buttonDot, buttonEquals, buttonPlus;
    CalculatorSimple calc = new CalculatorSimple();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOut = (TextView) findViewById(R.id.text_out);
        textInput = (EditText) findViewById(R.id.text_input);
        buttonDiscard = (Button) findViewById(R.id.btn_discard);
        buttonDiscard.setOnClickListener(this);
        buttonChangeSymbol = (Button) findViewById(R.id.btn_change_symbol);
        buttonChangeSymbol.setOnClickListener(this);
        buttonPercent = (Button) findViewById(R.id.btn_percent);
        buttonPercent.setOnClickListener(this);
        buttonDelete = (Button) findViewById(R.id.btn_delete);
        buttonDelete.setOnClickListener(this);
        buttonDivide = (Button) findViewById(R.id.btn_divide);
        buttonDivide.setOnClickListener(this);
        buttonMultiply = (Button) findViewById(R.id.btn_multiply);
        buttonMultiply.setOnClickListener(this);
        buttonMinus = (Button) findViewById(R.id.btn_minus);
        buttonMinus.setOnClickListener(this);
        buttonDot = (Button) findViewById(R.id.btn_dot);
        buttonDot.setOnClickListener(this);
        buttonEquals = (Button) findViewById(R.id.btn_equals);
        buttonEquals.setOnClickListener(this);
        buttonPlus = (Button) findViewById(R.id.btn_plus);
        buttonPlus.setOnClickListener(this);

        for (int i = 0; i < numberButtonIds.length; i++) {
            Button btn = (Button) findViewById(numberButtonIds[i]);
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_discard:
                textInput.setText(calc.discard());
                break;
            case R.id.btn_change_symbol:
                textInput.setText(calc.changeSymbol());
                break;
            case R.id.btn_percent:
                textInput.setText(calc.percent());
                break;
            case R.id.btn_delete:
                textInput.setText(calc.delete());
                break;
            case R.id.btn_divide:
                textInput.setText(calc.divide());
                break;
            case R.id.btn_multiply:
                textInput.setText(calc.multiply());
                break;
            case R.id.btn_minus:
                textInput.setText(calc.minus());
                break;
            case R.id.btn_dot:
                textInput.setText(calc.dot());
                break;
            case R.id.btn_equals:
                String[] calcData = calc.equals();
                textOut.setText(calcData[0]);
                textInput.setText(calcData[1]);
                break;
            case R.id.btn_plus:
                textInput.setText(calc.plus());
                break;
            default:
                Button btn = findViewById(v.getId());
                String textForInput = calc.addNumber(btn.getText().toString());
                textInput.setText(textForInput);
                break;
        }
    }
}

//1. Переделайте все кнопки на Материал.
//2. Все размеры и строки сделайте ресурсами.
//3. Создайте стиль для своего приложения.
//        4. * Создайте светлую и тёмную тему для приложения.
//        5. * исправление замечаний по дз
