package com.example.calculator

import java.math.BigDecimal
import java.util.regex.Pattern

class MainPresenter<V : MainContract.View> : MainContract.Presenter<V> {

    private var currentView: V? = null
    private val text = StringBuilder()
    private var numericOne = 0.0f
    private var mathOperations = ' '
    private var numericTwo = 0.0f

    override fun getNumericOne(): Float {
        return numericOne
    }

    override fun getMathOperations(): Char {
        return mathOperations
    }

    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detachView(view: V) {
        if (view == currentView) {
            currentView = null
        }
    }

    override fun discard() {
        text.setLength(0)
        numericOne = 0.0f
        mathOperations = ' '
        numericTwo = 0.0f
        currentView?.setInputText(text.toString())
    }

    override fun changeSymbol() {
        if (text.isNotEmpty() && text[0] == '-') {
            text.deleteCharAt(0)
        } else {
            text.insert(0, "-")
        }
        currentView?.setInputText(text.toString())
    }

    override fun percent() {
        if (calcTwoNumber()) {
            if (!numericOne.equals(0.0f) && !numericTwo.equals(0.0f)) {
                val totalPercent = numericOne * numericTwo / 100
                text.setLength(0)
                text.append(numericOne).append(mathOperations).append(totalPercent)
            }
        }
        currentView?.setInputText(text.toString())
    }

    override fun delete() {
        if (text.isNotEmpty()) {
            val p = Pattern.compile("\\S*[+-/*]$")
            val m = p.matcher(text.toString())
            if (m.matches()) {
                mathOperations = ' '
            }
            text.setLength(text.length - 1)
        }
        currentView?.setInputText(text.toString())
    }

    override fun divide() {
        if (text.isNotEmpty() && mathOperations == ' ') {
            numericOne = text.toString().toFloat()
            mathOperations = '/'
            text.append("/")
        }
        currentView?.setInputText(text.toString())
    }

    override fun multiply() {
        if (text.isNotEmpty() && mathOperations == ' ') {
            numericOne = text.toString().toFloat()
            mathOperations = '*'
            text.append("*")
        }
        currentView?.setInputText(text.toString())
    }

    override fun minus() {
        if (text.isNotEmpty() && mathOperations == ' ') {
            numericOne = text.toString().toFloat()
            mathOperations = '-'
            text.append("-")
        }
        currentView?.setInputText(text.toString())
    }

    override fun dot() {
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
        currentView?.setInputText(text.toString())
    }

    override fun plus() {
        if (text.isNotEmpty() && mathOperations == ' ') {
            numericOne = text.toString().toFloat()
            mathOperations = '+'
            text.append("+")
        }
        currentView?.setInputText(text.toString())
    }

    override fun addNumber(number: String) {
        text.append(number)
        currentView?.setInputText(text.toString())
    }

    override fun equals() {
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
            currentView?.setOperationsText(temp)
        } else {
            currentView?.setOperationsText("")
        }
        currentView?.setInputText(text.toString())
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