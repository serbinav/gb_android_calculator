package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int[] numberButtonIds = new int[]{R.id.btn_zero, R.id.btn_one, R.id.btn_two,
            R.id.btn_three, R.id.btn_four, R.id.btn_five, R.id.btn_six, R.id.btn_seven,
            R.id.btn_eight, R.id.btn_nine};

    private TextView textOut;
    private EditText textInput;
    private Button buttonDiscard, buttonChangeSymbol, buttonPercent, buttonDelete, buttonDivide,
            buttonMultiply, buttonMinus, buttonDot, buttonEquals, buttonPlus;
    private CalculatorSimple calc = new CalculatorSimple();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textOut = findViewById(R.id.text_out);
        textInput = findViewById(R.id.text_input);
        buttonDiscard = findViewById(R.id.btn_discard);
        buttonDiscard.setOnClickListener(this);
        buttonChangeSymbol = findViewById(R.id.btn_change_symbol);
        buttonChangeSymbol.setOnClickListener(this);
        buttonPercent = findViewById(R.id.btn_percent);
        buttonPercent.setOnClickListener(this);
        buttonDelete = findViewById(R.id.btn_delete);
        buttonDelete.setOnClickListener(this);
        buttonDivide = findViewById(R.id.btn_divide);
        buttonDivide.setOnClickListener(this);
        buttonMultiply = findViewById(R.id.btn_multiply);
        buttonMultiply.setOnClickListener(this);
        buttonMinus = findViewById(R.id.btn_minus);
        buttonMinus.setOnClickListener(this);
        buttonDot = findViewById(R.id.btn_dot);
        buttonDot.setOnClickListener(this);
        buttonEquals = findViewById(R.id.btn_equals);
        buttonEquals.setOnClickListener(this);
        buttonPlus = findViewById(R.id.btn_plus);
        buttonPlus.setOnClickListener(this);

        for (int numberButtonId : numberButtonIds) {
            Button btn = findViewById(numberButtonId);
            btn.setOnClickListener(this);
        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY);
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
