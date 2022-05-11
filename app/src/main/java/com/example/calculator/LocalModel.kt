package com.example.calculator

class LocalModel : MainRepository {
    private var outputText = StringBuilder()
    private var numericOne = 0.0f
    private var mathOperations = ' '
    private var numericTwo = 0.0f

    override fun getOutputText(): StringBuilder {
        return outputText
    }

    override fun setOutputText(string: StringBuilder) {
        outputText = string
    }

    override fun getNumericOne(): Float {
        return numericOne
    }

    override fun setNumericOne(num: Float) {
        numericOne = num
    }

    override fun getMathOperations(): Char {
        return mathOperations
    }

    override fun setMathOperations(char: Char) {
        mathOperations = char
    }

    override fun getNumericTwo(): Float {
        return numericTwo
    }

    override fun setNumericTwo(num: Float) {
        numericTwo = num
    }
}