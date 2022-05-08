package com.example.calculator;

import org.junit.Assert;
import org.junit.Test;

public class PresenterSimpleTest {

    MainContract.Presenter<MainContract.View> presenter = new MainPresenter();

    @Test
    public void testDiscard2() {
        presenter.addNumber("1");
        presenter.plus();
        Assert.assertEquals(1.0f, presenter.getNumericOne(), 0);
        Assert.assertEquals('+', presenter.getMathOperations());
        presenter.discard();
        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testDelete1() {
        presenter.addNumber("4");
        presenter.addNumber("4");
        presenter.delete();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testDelete2() {
        presenter.addNumber("4");
        presenter.addNumber("4");
        presenter.minus();
        Assert.assertEquals('-', presenter.getMathOperations());
        presenter.delete();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testDelete3() {
        presenter.addNumber("4");
        presenter.addNumber("4");
        presenter.minus();
        presenter.addNumber("5");
        presenter.addNumber("5");
        presenter.delete();
        Assert.assertEquals('-', presenter.getMathOperations());
    }

    @Test
    public void testDelete4() {
        presenter.addNumber("6");
        presenter.addNumber("6");
        presenter.dot();
        presenter.addNumber("7");
        presenter.addNumber("7");
        presenter.delete();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testPlus1() {
        presenter.plus();
        presenter.plus();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testPlus2() {
        presenter.addNumber("0");
        presenter.plus();
        presenter.plus();
        Assert.assertEquals('+', presenter.getMathOperations());
        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
    }

    @Test
    public void testPlus3() {
        presenter.addNumber("0");
        presenter.plus();
        presenter.addNumber("1");
        presenter.plus();
        Assert.assertEquals('+', presenter.getMathOperations());
        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
    }

    @Test
    public void testMinus1() {
        presenter.minus();
        presenter.minus();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testMinus2() {
        presenter.addNumber("0");
        presenter.minus();
        presenter.minus();
        Assert.assertEquals('-', presenter.getMathOperations());
        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
    }

    @Test
    public void testMinus3() {
        presenter.addNumber("0");
        presenter.minus();
        presenter.addNumber("1");
        presenter.minus();
        Assert.assertEquals('-', presenter.getMathOperations());
        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
    }

    @Test
    public void testDivide1() {
        presenter.divide();
        presenter.divide();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testDivide2() {
        presenter.addNumber("0");
        presenter.divide();
        presenter.divide();
        Assert.assertEquals('/', presenter.getMathOperations());
        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
    }

    @Test
    public void testDivide3() {
        presenter.addNumber("0");
        presenter.divide();
        presenter.addNumber("1");
        presenter.divide();
        Assert.assertEquals('/', presenter.getMathOperations());
        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
    }

    @Test
    public void testMultiply1() {
        presenter.multiply();
        presenter.multiply();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testMultiply2() {
        presenter.addNumber("0");
        presenter.multiply();
        presenter.multiply();
        Assert.assertEquals('*', presenter.getMathOperations());
        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
    }

    @Test
    public void testMultiply3() {
        presenter.addNumber("0");
        presenter.multiply();
        presenter.addNumber("1");
        presenter.multiply();
        Assert.assertEquals('*', presenter.getMathOperations());
        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
    }

    @Test
    public void testEquals1() {
        presenter.addNumber("0");
        presenter.divide();
        presenter.addNumber("0");
        Assert.assertEquals('/', presenter.getMathOperations());
        presenter.equals();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testEquals2() {
        presenter.addNumber("1");
        presenter.divide();
        presenter.addNumber("0");
        Assert.assertEquals('/', presenter.getMathOperations());
        presenter.equals();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testEquals3() {
        presenter.addNumber("1");
        presenter.plus();
        presenter.addNumber("0");
        Assert.assertEquals('+', presenter.getMathOperations());
        presenter.equals();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testEquals4() {
        presenter.addNumber("3");
        presenter.minus();
        presenter.addNumber("2");
        Assert.assertEquals('-', presenter.getMathOperations());
        presenter.equals();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testEquals5() {
        presenter.addNumber("8");
        presenter.divide();
        presenter.addNumber("4");
        Assert.assertEquals('/', presenter.getMathOperations());
        presenter.equals();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testEquals6() {
        presenter.addNumber("5");
        presenter.multiply();
        presenter.addNumber("6");
        Assert.assertEquals('*', presenter.getMathOperations());
        presenter.equals();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testEquals7() {
        presenter.equals();
        presenter.equals();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testEquals8() {
        presenter.addNumber("0");
        presenter.equals();
        presenter.equals();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }

    @Test
    public void testEquals9() {
        presenter.addNumber("2");
        presenter.plus();
        presenter.addNumber("2");
        Assert.assertEquals('+', presenter.getMathOperations());
        presenter.equals();
        Assert.assertEquals(' ', presenter.getMathOperations());
        presenter.plus();
        presenter.addNumber("6");
        Assert.assertEquals('+', presenter.getMathOperations());
        presenter.equals();
        Assert.assertEquals(' ', presenter.getMathOperations());
    }
}
