package com.example.calculator

interface MainRepository {

    fun getOutputText(): StringBuilder

    fun setOutputText(string: StringBuilder)

    fun getNumericOne(): Float

    fun setNumericOne(num: Float)

    fun getMathOperations(): Char

    fun setMathOperations(char: Char)

    fun getNumericTwo(): Float

    fun setNumericTwo(num: Float)
}