package com.example.calculator

import java.math.BigDecimal
import java.util.regex.Pattern

class CalculatorSimple {

    private val text = StringBuilder()
    var numericOne = 0.0f
        private set
    var mathOperations = ' '
        private set
    private var numericTwo = 0.0f

    fun discard(): String {
        text.setLength(0)
        numericOne = 0.0f
        mathOperations = ' '
        numericTwo = 0.0f
        return text.toString()
    }

    fun changeSymbol(): String {
        if (text.isNotEmpty() && text[0] == '-') {
            text.deleteCharAt(0)
        } else {
            text.insert(0, "-")
        }
        return text.toString()
    }

    fun delete(): String {
        if (text.isNotEmpty()) {
            val p = Pattern.compile("\\S*[+-/*]$")
            val m = p.matcher(text.toString())
            if (m.matches()) {
                mathOperations = ' '
            }
            text.setLength(text.length - 1)
        }
        return text.toString()
    }

    fun addNumber(number: String?): String {
        text.append(number)
        return text.toString()
    }

    fun dot(): String {
        if (calcTwoNumber()) {
            val textNumericTwo = if (numericTwo > numericTwo.toInt()) {
                String.format("%d", numericTwo.toLong())
            } else {
                String.format("%s", numericTwo)
            }
            if (!textNumericTwo.contains(".")) {
                text.append(".")
            }
        } else if (text.indexOf(".") < 0) {
            text.append(".")
        }
        return text.toString()
    }

    fun plus(): String {
        if (text.isNotEmpty() && mathOperations == ' ') {
            numericOne = text.toString().toFloat()
            mathOperations = '+'
            text.append("+")
        }
        return text.toString()
    }

    fun minus(): String {
        if (text.isNotEmpty() && mathOperations == ' ') {
            numericOne = text.toString().toFloat()
            mathOperations = '-'
            text.append("-")
        }
        return text.toString()
    }

    fun divide(): String {
        if (text.isNotEmpty() && mathOperations == ' ') {
            numericOne = text.toString().toFloat()
            mathOperations = '/'
            text.append("/")
        }
        return text.toString()
    }

    fun multiply(): String {
        if (text.isNotEmpty() && mathOperations == ' ') {
            numericOne = text.toString().toFloat()
            mathOperations = '*'
            text.append("*")
        }
        return text.toString()
    }

    fun equals(): Array<String> {
        if (calcTwoNumber()) {
            var total = ""
            when (mathOperations) {
                '+' -> total = BigDecimal(numericOne.toString())
                    .add(BigDecimal(numericTwo.toString())).toString()
                '-' -> total = BigDecimal(numericOne.toString())
                    .subtract(BigDecimal(numericTwo.toString())).toString()
                '/' -> total = try {
                    BigDecimal(numericOne.toString())
                        .divide(BigDecimal(numericTwo.toString())).toString()
                } catch (ex: ArithmeticException) {
                    ex.message ?: "Another exception"
                }
                '*' -> total = BigDecimal(numericOne.toString())
                    .multiply(BigDecimal(numericTwo.toString())).toString()
            }
            val temp = text.toString()
            text.setLength(0)
            text.append(total)
            mathOperations = ' '
            return arrayOf(temp, text.toString())
        }
        return arrayOf("", text.toString())
    }

    fun percent(): String {
        if (calcTwoNumber()) {
            if (!numericOne.equals(0.0f) && !numericTwo.equals(0.0f)) {
                val totalPercent = numericOne * numericTwo / 100
                text.setLength(0)
                text.append(numericOne).append(mathOperations).append(totalPercent)
            }
            return text.toString()
        }
        return text.toString()
    }

    private fun calcTwoNumber(): Boolean {
        val numeric = text.toString().split("[$mathOperations]".toRegex()).toTypedArray()
        if (numeric.size == 2) {
            if (numeric[1].isNotEmpty()) {
                numericTwo = numeric[1].toFloat()
            }
            return true
        }
        return false
    }
}