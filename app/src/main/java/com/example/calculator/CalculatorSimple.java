package com.example.calculator;

import android.util.Pair;

public class CalculatorSimple {

    private StringBuilder text = new StringBuilder();
    private float numericOne = 0.0f;
    private char mathOperations = ' ';
    private float numericTwo = 0.0f;

    String discard() {
        clearData();
        return text.toString();
    }

    String changeSymbol() {
        if (text.length() != 0 && text.charAt(0) == '-') {
            text.deleteCharAt(0);
        } else {
            text.insert(0, "-");
        }
        return text.toString();
    }

    String delete() {
        if (text.length() != 0) {
            text.setLength(text.length() - 1);
        }
        return text.toString();
    }

    String seven() {
        text.append("7");
        return text.toString();
    }

    String eight() {
        text.append("8");
        return text.toString();
    }

    String nine() {
        text.append("9");
        return text.toString();
    }

    String four() {
        text.append("4");
        return text.toString();
    }

    String five() {
        text.append("5");
        return text.toString();
    }

    String six() {
        text.append("6");
        return text.toString();
    }

    String one() {
        text.append("1");
        return text.toString();
    }

    String two() {
        text.append("2");
        return text.toString();
    }

    String three() {
        text.append("3");
        return text.toString();
    }

    String zero() {
        text.append("0");
        return text.toString();
    }

    String dot() {
        if (text.indexOf(".") < 0) {
            text.append(".");
        }
        return text.toString();
    }

    String plus() {
        numericOne = Float.parseFloat(text.toString());
        mathOperations = '+';
        text.append("+");
        return text.toString();
    }

    String minus() {
        numericOne = Float.parseFloat(text.toString());
        mathOperations = '-';
        text.append("-");
        return text.toString();
    }

    String divide() {
        numericOne = Float.parseFloat(text.toString());
        mathOperations = '/';
        text.append("/");
        return text.toString();
    }

    String multiply() {
        numericOne = Float.parseFloat(text.toString());
        mathOperations = '*';
        text.append("*");
        return text.toString();
    }

    Pair<String, String> equals() {
        if (calcTwoNumber()) {
            float total = 0.0f;
            switch (mathOperations) {
                case '+':
                    total = numericOne + numericTwo;
                    break;
                case '-':
                    total = numericOne - numericTwo;
                    break;
                case '/':
                    total = numericOne / numericTwo;
                    break;
                case '*':
                    total = numericOne * numericTwo;
                    break;
            }
            String temp = text.toString();
            text.setLength(0);
            text.append(total);
            mathOperations = ' ';
            return new Pair<>(temp, Float.toString(total));
        }
        clearData();
        return new Pair<>("", "");
    }

    String percent() {
        if (mathOperations != ' ' && calcTwoNumber()) {
            float totalPercent = (numericOne * numericTwo)/100;
            text.setLength(0);
            text.append(numericOne).append(mathOperations).append(totalPercent);
            return text.toString();
        }
        clearData();
        return text.toString();
    }

    private boolean calcTwoNumber() {
        String[] numeric = text.toString().split("[" + mathOperations + "]");
        if (numeric.length == 2) {
            numericTwo = Float.parseFloat(numeric[1]);
            return true;
        }
        return false;
    }

    private void clearData() {
        text.setLength(0);
        numericOne = 0.0f;
        mathOperations = ' ';
        numericTwo = 0.0f;
    }
}
