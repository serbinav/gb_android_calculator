package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textOut = findViewById(R.id.text_out);
        EditText textInput = findViewById(R.id.text_input);

        CalculatorCount calc = new CalculatorCount();

        Button buttonDiscard = findViewById(R.id.btn_discard);
        buttonDiscard.setOnClickListener(v -> {
//            if (text.length() != 0) {
//                text.setLength(0);
//                textInput.setText(text.toString());
//            }
        });

        Button buttonChangeSymbol = findViewById(R.id.btn_change_symbol);
        buttonChangeSymbol.setOnClickListener(v -> {
//            if (text.length() != 0 && text.charAt(0) == '-') {
//                text.deleteCharAt(0);
//            } else {
//                text.insert(0, "-");
//            }
//            textInput.setText(text.toString());
        });

        Button buttonPercent = findViewById(R.id.btn_percent);

        Button buttonDelete = findViewById(R.id.btn_delete);
        buttonDelete.setOnClickListener(v -> {
//            if (text.length() != 0) {
//                text.setLength(text.length() - 1);
//                textInput.setText(text.toString());
//            }
        });

        Button buttonSeven = findViewById(R.id.btn_seven);
        buttonSeven.setOnClickListener(v -> {
            textInput.setText(calc.seven());
        });
        Button buttonEight = findViewById(R.id.btn_eight);
        buttonEight.setOnClickListener(v -> {
            textInput.setText(calc.eight());
        });
        Button buttonNine = findViewById(R.id.btn_nine);
        buttonNine.setOnClickListener(v -> {
            textInput.setText(calc.nine());
        });

        Button buttonDivide = findViewById(R.id.btn_divide);

        Button buttonFour = findViewById(R.id.btn_four);
        buttonFour.setOnClickListener(v -> {
            textInput.setText(calc.four());
        });
        Button buttonFive = findViewById(R.id.btn_five);
        buttonFive.setOnClickListener(v -> {
            textInput.setText(calc.five());
        });
        Button buttonSix = findViewById(R.id.btn_six);
        buttonSix.setOnClickListener(v -> {
            textInput.setText(calc.six());
        });

        Button buttonMultiply = findViewById(R.id.btn_multiply);

        Button buttonOne = findViewById(R.id.btn_one);
        buttonOne.setOnClickListener(v -> {
            textInput.setText(calc.one());
        });
        Button buttonTwo = findViewById(R.id.btn_two);
        buttonTwo.setOnClickListener(v -> {
            textInput.setText(calc.two());
        });
        Button buttonThree = findViewById(R.id.btn_three);
        buttonThree.setOnClickListener(v -> {
            textInput.setText(calc.three());
        });

        Button buttonMinus = findViewById(R.id.btn_minus);

        Button buttonZero = findViewById(R.id.btn_zero);
        buttonZero.setOnClickListener(v -> {
            textInput.setText(calc.zero());
        });

        Button buttonDot = findViewById(R.id.btn_dot);
        buttonDot.setOnClickListener(v -> {
//            if (text.indexOf(",") < 0) {
//                text.append(",");
//                textInput.setText(text.toString());
//            }
        });


        Button buttonEquals = findViewById(R.id.btn_equals);
        buttonEquals.setOnClickListener(v -> {
//            textOut.setText(text.toString());
//            textInput.setText("");
//            text.setLength(0);
        });

        Button buttonPlus = findViewById(R.id.btn_plus);
    }
}

//1. Напишите обработку каждой кнопки из макета калькулятора.
//2. Создайте объект с данными и операциями калькулятора. Продумайте, каким образом будете хранить введённые пользователем данные.
//3. * Создайте макет калькулятора для горизонтальной ориентации экрана и отображайте его в ландшафтной ориентации.