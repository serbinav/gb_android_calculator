package com.example.calculator

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainPresenterTest {

    private lateinit var presenter: MainPresenter<MainContract.View>

    @Mock
    private lateinit var viewContract: MainContract.View

    @Mock
    private lateinit var model: MainRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(model)
        presenter.attachView(viewContract)
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun discard_test() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder())
        presenter.discard()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("")
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun changeSymbol_isNotEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("-"))
        presenter.changeSymbol()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("")
    }

    @Test
    fun changeSymbol_isEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder())
        presenter.changeSymbol()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("-")
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun calcTwoNumber_true() {
        Mockito.`when`(model.getMathOperations()).thenReturn('-')
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("21-3"))
        Mockito.`when`(model.getNumericTwo()).thenReturn(3f)
        Assert.assertTrue(presenter.calcTwoNumber())
    }

    @Test
    fun calcTwoNumber_false() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("21"))
        Assert.assertFalse(presenter.calcTwoNumber())
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun percent_getNumericOne_zero() {
        Mockito.`when`(model.getMathOperations()).thenReturn('-')
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("100-0"))
        Mockito.`when`(model.getNumericOne()).thenReturn(100f)
        Mockito.`when`(model.getNumericTwo()).thenReturn(0f)
        presenter.percent()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("100-0")
    }

    @Test
    fun percent_getNumericOne_nonZero() {
        Mockito.`when`(model.getMathOperations()).thenReturn('-')
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("1000-10"))
        Mockito.`when`(model.getNumericOne()).thenReturn(1000f)
        Mockito.`when`(model.getNumericTwo()).thenReturn(10f)
        presenter.percent()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("1000.0-100.0")
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun delete_isEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder())
        presenter.delete()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("")
    }

    @Test
    fun delete_isNotEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("911"))
        Mockito.`when`(model.getMathOperations()).thenReturn(' ')
        presenter.delete()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("91")
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun divide_isEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder())
        presenter.divide()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("")
    }

    @Test
    fun divide_isNotEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("4"))
        Mockito.`when`(model.getMathOperations()).thenReturn(' ')
        Mockito.`when`(model.getNumericOne()).thenReturn(4f)
        presenter.divide()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("4/")
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun multiply_isEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder())
        presenter.multiply()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("")
    }

    @Test
    fun multiply_isNotEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("4"))
        Mockito.`when`(model.getMathOperations()).thenReturn(' ')
        Mockito.`when`(model.getNumericOne()).thenReturn(4f)
        presenter.multiply()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("4*")
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun minus_isEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder())
        presenter.minus()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("")
    }

    @Test
    fun minus_isNotEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("4"))
        Mockito.`when`(model.getMathOperations()).thenReturn(' ')
        Mockito.`when`(model.getNumericOne()).thenReturn(4f)
        presenter.minus()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("4-")
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun dot_isNumericTwo_containsDot() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("4+2.2"))
        Mockito.`when`(model.getMathOperations()).thenReturn('+')
        Mockito.`when`(model.getNumericTwo()).thenReturn(2.2f)
        presenter.dot()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("4+2.2")
    }

    @Test
    fun dot_isNumericTwo_notContainsDot() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("4+4"))
        Mockito.`when`(model.getMathOperations()).thenReturn('+')
        Mockito.`when`(model.getNumericTwo()).thenReturn(4f)
        presenter.dot()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("4+4.")
    }

    @Test
    fun dot_isFirstSymbolDot() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder())
        presenter.dot()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText(".")
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun plus_isEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder())
        presenter.plus()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("")
    }

    @Test
    fun plus_isNotEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("4"))
        Mockito.`when`(model.getMathOperations()).thenReturn(' ')
        Mockito.`when`(model.getNumericOne()).thenReturn(4f)
        presenter.plus()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("4+")
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun addNumber_test() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder())
        presenter.addNumber("7")
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("7")
    }

    //-------------------------------------------------------------------------------------------------
    @Test
    fun equals_isEmpty() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder())
        presenter.equals()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("")
    }

    @Test
    fun equals_isMathOperations_multiply() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("7*3"))
        Mockito.`when`(model.getMathOperations()).thenReturn('*')
        Mockito.`when`(model.getNumericOne()).thenReturn(7f)
        Mockito.`when`(model.getNumericTwo()).thenReturn(3f)
        presenter.equals()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("21.00")
    }

    @Test
    fun equals_isMathOperations_divide() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("8/2"))
        Mockito.`when`(model.getMathOperations()).thenReturn('/')
        Mockito.`when`(model.getNumericOne()).thenReturn(8f)
        Mockito.`when`(model.getNumericTwo()).thenReturn(2f)
        presenter.equals()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("4")
    }

    @Test
    fun equals_isMathOperations_divideException1() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("0/0"))
        Mockito.`when`(model.getMathOperations()).thenReturn('/')
        Mockito.`when`(model.getNumericOne()).thenReturn(0f)
        Mockito.`when`(model.getNumericTwo()).thenReturn(0f)
        presenter.equals()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("Division undefined")
    }

    @Test
    fun equals_isMathOperations_divideException2() {
        Mockito.`when`(model.getOutputText()).thenReturn(StringBuilder("1/0"))
        Mockito.`when`(model.getMathOperations()).thenReturn('/')
        Mockito.`when`(model.getNumericOne()).thenReturn(1f)
        Mockito.`when`(model.getNumericTwo()).thenReturn(0f)
        presenter.equals()
        Mockito.verify(viewContract, Mockito.times(1)).setInputText("Division by zero")
    }
//-------------------------------------------------------------------------------------------------
}