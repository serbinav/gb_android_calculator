package com.example.calculator;

public class CalculatorCount {

    private StringBuilder text = new StringBuilder();

    String discard() {
        if (text.length() != 0) {
            text.setLength(0);
//            textInput.setText(text.toString());
        }
        return text.toString();
    }

    String change_symbol() {
        if (text.length() != 0 && text.charAt(0) == '-') {
            text.deleteCharAt(0);
        } else {
            text.insert(0, "-");
        }
//        textInput.setText(text.toString());
        return "";
    }

    String delete() {
        if (text.length() != 0) {
            text.setLength(text.length() - 1);
//            textInput.setText(text.toString());
        }
        return "";
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
//            textInput.setText(text.toString());
        }
        return "";
    }

    String equals() {
//        textOut.setText(text.toString());
//        textInput.setText("");
        text.setLength(0);
        return "";
    }
}
