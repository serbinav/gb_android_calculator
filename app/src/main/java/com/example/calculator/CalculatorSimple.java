package com.example.calculator;

import android.util.Pair;

public class CalculatorSimple {

    private StringBuilder text = new StringBuilder();
    private int numericOne;
    private char mathOperations;
    private int numericTwo;

    String discard() {
        if (text.length() != 0) {
            text.setLength(0);
        }
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
        if (text.indexOf(",") < 0) {
            text.append(",");
        }
        return text.toString();
    }

    String plus() {
        numericOne = Integer.parseInt(text.toString());
        mathOperations = '+';
        text.append("+");
        return text.toString();
    }

    String minus() {
        numericOne = Integer.parseInt(text.toString());
        mathOperations = '-';
        text.append("-");
        return text.toString();
    }

    String divide() {
        numericOne = Integer.parseInt(text.toString());
        mathOperations = '/';
        text.append("/");
        return text.toString();
    }

    String multiply() {
        numericOne = Integer.parseInt(text.toString());
        mathOperations = '*';
        text.append("*");
        return text.toString();
    }

    Pair<String, String> equals() {
        String[] numeric = text.toString().split("[+-/*]");
        numericTwo = Integer.parseInt(numeric[1]);
        int total = 0;
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
        return new Pair<>(temp, Integer.toString(total));
    }

    String percent() {
        return text.toString();
    }
}
