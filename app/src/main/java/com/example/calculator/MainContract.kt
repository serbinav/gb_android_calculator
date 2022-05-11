package com.example.calculator

interface MainContract {

    interface View {

        fun clickButtonDiscard()
        fun clickButtonChangeSymbol()
        fun clickButtonPercent()
        fun clickButtonDelete()
        fun clickButtonDivide()
        fun clickButtonMultiply()
        fun clickButtonMinus()
        fun clickButtonDot()
        fun clickButtonEquals()
        fun clickButtonPlus()
        fun clickButtonZero()
        fun clickButtonOne()
        fun clickButtonTwo()
        fun clickButtonThree()
        fun clickButtonFour()
        fun clickButtonFive()
        fun clickButtonSix()
        fun clickButtonSeven()
        fun clickButtonEight()
        fun clickButtonNine()

        fun showError(msg: String)

        fun setOperationsText(text: String)
        fun setInputText(text: String)
    }

    interface Presenter<V : View> {

        fun attachView(view: V)
        fun detachView(view: V)

        fun discard()
        fun changeSymbol()
        fun percent()
        fun delete()
        fun divide()
        fun multiply()
        fun minus()
        fun dot()
        fun plus()
        fun addNumber(number: String)
        fun equals()
    }
}