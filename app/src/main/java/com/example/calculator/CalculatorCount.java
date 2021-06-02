package com.example.calculator;

import android.util.Pair;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public class CalculatorCount {

    private StringBuilder text = new StringBuilder();

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

    Pair<String, String> equals() {
        Pattern p = Pattern.compile("(\\d+[.]?\\d*)([+-/*])(\\d+[.]?\\d*)");
        Matcher m = p.matcher(text.toString());

        int numericOne = Integer.parseInt(m.group(1));
        String sign = m.group(2);
        int numericTwo = Integer.parseInt(m.group(3));
        int end;

        switch (sign) {
            case "+":
                end = numericOne + numericTwo;
            case "-":
                end = numericOne - numericTwo;
            case "/":
                end = numericOne / numericTwo;
            case "*":
                end = numericOne * numericTwo;
        }

        return new Pair<>(text.toString(), "");
    }

    String plus() {
        text.append("+");
        return text.toString();
    }
}
