package com.example.calculator

import java.lang.StringBuilder
import java.math.BigDecimal
import java.util.regex.Pattern

class MainPresenter<V : MainContract.View>(private val model: MainRepository) :
    MainContract.Presenter<V> {

    private var currentView: V? = null

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
        model.setOutputText(StringBuilder())
        model.setNumericOne(0.0f)
        model.setMathOperations(' ')
        model.setNumericTwo(0.0f)
        currentView?.setInputText(model.getOutputText().toString())
    }

    override fun changeSymbol() {
        val text = model.getOutputText()
        if (text.isNotEmpty() && text[0] == '-') {
            text.deleteCharAt(0)
        } else {
            text.insert(0, "-")
        }
        model.setOutputText(text)
        currentView?.setInputText(text.toString())
    }

    override fun percent() {
        var text = model.getOutputText()
        if (calcTwoNumber()) {
            if (!model.getNumericOne().equals(0.0f) && !model.getNumericTwo().equals(0.0f)) {
                val totalPercent = model.getNumericOne() * model.getNumericTwo() / 100
                text = StringBuilder()
                text.append(model.getNumericOne()).append(model.getMathOperations())
                    .append(totalPercent)
            }
        }
        model.setOutputText(text)
        currentView?.setInputText(text.toString())
    }

    override fun delete() {
        val text = model.getOutputText()
        if (text.isNotEmpty()) {
            val p = Pattern.compile("\\S*[+-/*]$")
            val m = p.matcher(text.toString())
            if (m.matches()) {
                model.setMathOperations(' ')
            }
            text.setLength(text.length - 1)
        }
        model.setOutputText(text)
        currentView?.setInputText(text.toString())
    }

    override fun divide() {
        val text = model.getOutputText()
        if (text.isNotEmpty() && model.getMathOperations() == ' ') {
            model.setNumericOne(text.toString().toFloat())
            model.setMathOperations('/')
            text.append("/")
        }
        model.setOutputText(text)
        currentView?.setInputText(text.toString())
    }

    override fun multiply() {
        val text = model.getOutputText()
        if (text.isNotEmpty() && model.getMathOperations() == ' ') {
            model.setNumericOne(text.toString().toFloat())
            model.setMathOperations('*')
            text.append("*")
        }
        model.setOutputText(text)
        currentView?.setInputText(text.toString())
    }

    override fun minus() {
        val text = model.getOutputText()
        if (text.isNotEmpty() && model.getMathOperations() == ' ') {
            model.setNumericOne(text.toString().toFloat())
            model.setMathOperations('-')
            text.append("-")
        }
        model.setOutputText(text)
        currentView?.setInputText(text.toString())
    }

    override fun dot() {
        val text = model.getOutputText()
        if (calcTwoNumber()) {
            if (model.getNumericTwo() > model.getNumericTwo().toInt()) {
                String.format("%s", model.getNumericTwo())
            } else {
                String.format("%d", model.getNumericTwo().toLong())
                text.append(".")
            }
        } else if (text.indexOf(".") < 0) {
            text.append(".")
        }
        model.setOutputText(text)
        currentView?.setInputText(text.toString())
    }

    override fun plus() {
        val text = model.getOutputText()
        if (text.isNotEmpty() && model.getMathOperations() == ' ') {
            model.setNumericOne(text.toString().toFloat())
            model.setMathOperations('+')
            text.append("+")
        }
        model.setOutputText(text)
        currentView?.setInputText(text.toString())
    }

    override fun addNumber(number: String) {
        val text = model.getOutputText()
        text.append(number)
        model.setOutputText(text)
        currentView?.setInputText(text.toString())
    }

    override fun equals() {
        val text = model.getOutputText()
        if (calcTwoNumber()) {
            var total = ""
            when (model.getMathOperations()) {
                '+' -> total = BigDecimal(model.getNumericOne().toString())
                    .add(BigDecimal(model.getNumericTwo().toString())).toString()
                '-' -> total = BigDecimal(model.getNumericOne().toString())
                    .subtract(BigDecimal(model.getNumericTwo().toString())).toString()
                '/' -> total = try {
                    BigDecimal(model.getNumericOne().toString())
                        .divide(BigDecimal(model.getNumericTwo().toString())).toString()
                } catch (ex: ArithmeticException) {
                    ex.message ?: "Another exception"
                }
                '*' -> total = BigDecimal(model.getNumericOne().toString())
                    .multiply(BigDecimal(model.getNumericTwo().toString())).toString()
            }
            val temp = model.getOutputText().toString()
            text.setLength(0)
            text.append(total)
            model.setMathOperations(' ')
            currentView?.setOperationsText(temp)
        } else {
            currentView?.setOperationsText("")
        }
        model.setOutputText(text)
        currentView?.setInputText(text.toString())
    }

    @Deprecated("for internal use only")
    fun calcTwoNumber(): Boolean {
        val char = model.getMathOperations()
        val numeric =
            model.getOutputText().toString().split("[$char]".toRegex()).toTypedArray()
        if (numeric.size == 2) {
            if (numeric[1].isNotEmpty()) {
                model.setNumericTwo(numeric[1].toFloat())
            }
            return true
        }
        return false
    }
}