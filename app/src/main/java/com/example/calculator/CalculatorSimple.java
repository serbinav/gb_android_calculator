package com.example.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorSimple {

    private StringBuilder text = new StringBuilder();
    private float numericOne = 0.0f;
    private char mathOperations = ' ';
    private float numericTwo = 0.0f;

    public float getNumericOne() {
        return numericOne;
    }

    public char getMathOperations() {
        return mathOperations;
    }

    String discard() {
        text.setLength(0);
        numericOne = 0.0f;
        mathOperations = ' ';
        numericTwo = 0.0f;
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
            Pattern p = Pattern.compile("\\S*[+-/*]$");
            Matcher m = p.matcher(text.toString());
            if (m.matches()) {
                mathOperations = ' ';
            }
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
        if (text.length() != 0 && mathOperations == ' ') {
            numericOne = Float.parseFloat(text.toString());
            mathOperations = '+';
            text.append("+");
        }
        return text.toString();
    }

    String minus() {
        if (text.length() != 0 && mathOperations == ' ') {
            numericOne = Float.parseFloat(text.toString());
            mathOperations = '-';
            text.append("-");
        }
        return text.toString();
    }

    String divide() {
        if (text.length() != 0 && mathOperations == ' ') {
            numericOne = Float.parseFloat(text.toString());
            mathOperations = '/';
            text.append("/");
        }
        return text.toString();
    }

    String multiply() {
        if (text.length() != 0 && mathOperations == ' ') {
            numericOne = Float.parseFloat(text.toString());
            mathOperations = '*';
            text.append("*");
        }
        return text.toString();
    }

    String[] equals() {
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
            return new String[]{temp, text.toString()};
        }
        return new String[]{"", text.toString()};
    }

    String percent() {
        if (calcTwoNumber()) {
            float totalPercent = (numericOne * numericTwo) / 100;
            text.setLength(0);
            text.append(numericOne).append(mathOperations).append(totalPercent);
            return text.toString();
        }
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
}
