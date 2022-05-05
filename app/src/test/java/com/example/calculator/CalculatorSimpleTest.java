package com.example.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorSimpleTest {

    @Test
    public void testDiscard1() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("1", calc.addNumber("1"));
        Assert.assertEquals("", calc.discard());
    }

    @Test
    public void testDiscard2() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("1", calc.addNumber("1"));
        Assert.assertEquals("1+", calc.plus());
        Assert.assertEquals(1.0f, calc.getNumericOne(), 0);
        Assert.assertEquals('+', calc.getMathOperations());
        Assert.assertEquals("", calc.discard());
        Assert.assertEquals(0.0f, calc.getNumericOne(), 0);
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testChangeSymbol1() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("2", calc.addNumber("2"));
        Assert.assertEquals("-2", calc.changeSymbol());
        Assert.assertEquals("2", calc.changeSymbol());
    }

    @Test
    public void testChangeSymbol2() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("-", calc.changeSymbol());
        Assert.assertEquals("", calc.changeSymbol());
        Assert.assertEquals("-", calc.changeSymbol());
        Assert.assertEquals("-3", calc.addNumber("3"));
    }

    @Test
    public void testDelete1() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("4", calc.addNumber("4"));
        Assert.assertEquals("44", calc.addNumber("4"));
        Assert.assertEquals("4", calc.delete());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testDelete2() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("4", calc.addNumber("4"));
        Assert.assertEquals("44", calc.addNumber("4"));
        Assert.assertEquals("44-", calc.minus());
        Assert.assertEquals('-', calc.getMathOperations());
        Assert.assertEquals("44", calc.delete());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testDelete3() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("4", calc.addNumber("4"));
        Assert.assertEquals("44", calc.addNumber("4"));
        Assert.assertEquals("44-", calc.minus());
        Assert.assertEquals("44-5", calc.addNumber("5"));
        Assert.assertEquals("44-55", calc.addNumber("5"));
        Assert.assertEquals("44-5", calc.delete());
        Assert.assertEquals('-', calc.getMathOperations());
    }

    @Test
    public void testDelete4() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("6", calc.addNumber("6"));
        Assert.assertEquals("66", calc.addNumber("6"));
        Assert.assertEquals("66.", calc.dot());
        Assert.assertEquals("66.7", calc.addNumber("7"));
        Assert.assertEquals("66.77", calc.addNumber("7"));
        Assert.assertEquals("66.7", calc.delete());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testDot1() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("8", calc.addNumber("8"));
        Assert.assertEquals("8.", calc.dot());
        Assert.assertEquals("8.8", calc.addNumber("8"));
        Assert.assertEquals("8.8", calc.dot());
    }

    @Test
    public void testDot2() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals(".", calc.dot());
        Assert.assertEquals(".9", calc.addNumber("9"));
    }

    @Test
    public void testPlus1() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("", calc.plus());
        Assert.assertEquals("", calc.plus());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testPlus2() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("0", calc.addNumber("0"));
        Assert.assertEquals("0+", calc.plus());
        Assert.assertEquals("0+", calc.plus());
        Assert.assertEquals('+', calc.getMathOperations());
        Assert.assertEquals(0.0f, calc.getNumericOne(), 0);
    }

    @Test
    public void testPlus3() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("0", calc.addNumber("0"));
        Assert.assertEquals("0+", calc.plus());
        Assert.assertEquals("0+1", calc.addNumber("1"));
        Assert.assertEquals("0+1", calc.plus());
        Assert.assertEquals('+', calc.getMathOperations());
        Assert.assertEquals(0.0f, calc.getNumericOne(), 0);
    }

    @Test
    public void testMinus1() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("", calc.minus());
        Assert.assertEquals("", calc.minus());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testMinus2() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("0", calc.addNumber("0"));
        Assert.assertEquals("0-", calc.minus());
        Assert.assertEquals("0-", calc.minus());
        Assert.assertEquals('-', calc.getMathOperations());
        Assert.assertEquals(0.0f, calc.getNumericOne(), 0);
    }

    @Test
    public void testMinus3() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("0", calc.addNumber("0"));
        Assert.assertEquals("0-", calc.minus());
        Assert.assertEquals("0-1", calc.addNumber("1"));
        Assert.assertEquals("0-1", calc.minus());
        Assert.assertEquals('-', calc.getMathOperations());
        Assert.assertEquals(0.0f, calc.getNumericOne(), 0);
    }

    @Test
    public void testDivide1() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("", calc.divide());
        Assert.assertEquals("", calc.divide());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testDivide2() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("0", calc.addNumber("0"));
        Assert.assertEquals("0/", calc.divide());
        Assert.assertEquals("0/", calc.divide());
        Assert.assertEquals('/', calc.getMathOperations());
        Assert.assertEquals(0.0f, calc.getNumericOne(), 0);
    }

    @Test
    public void testDivide3() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("0", calc.addNumber("0"));
        Assert.assertEquals("0/", calc.divide());
        Assert.assertEquals("0/1", calc.addNumber("1"));
        Assert.assertEquals("0/1", calc.divide());
        Assert.assertEquals('/', calc.getMathOperations());
        Assert.assertEquals(0.0f, calc.getNumericOne(), 0);
    }

    @Test
    public void testMultiply1() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("", calc.multiply());
        Assert.assertEquals("", calc.multiply());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testMultiply2() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("0", calc.addNumber("0"));
        Assert.assertEquals("0*", calc.multiply());
        Assert.assertEquals("0*", calc.multiply());
        Assert.assertEquals('*', calc.getMathOperations());
        Assert.assertEquals(0.0f, calc.getNumericOne(), 0);
    }

    @Test
    public void testMultiply3() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("0", calc.addNumber("0"));
        Assert.assertEquals("0*", calc.multiply());
        Assert.assertEquals("0*1", calc.addNumber("1"));
        Assert.assertEquals("0*1", calc.multiply());
        Assert.assertEquals('*', calc.getMathOperations());
        Assert.assertEquals(0.0f, calc.getNumericOne(), 0);
    }

    @Test
    public void testPercent1() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("2", calc.addNumber("2"));
        Assert.assertEquals("20", calc.addNumber("0"));
        Assert.assertEquals("20", calc.percent());
    }

    @Test
    public void testPercent2() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("2", calc.addNumber("2"));
        Assert.assertEquals("20", calc.addNumber("0"));
        Assert.assertEquals("20+", calc.plus());
        Assert.assertEquals("20+", calc.percent());
    }

    @Test
    public void testPercent3() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("2", calc.addNumber("2"));
        Assert.assertEquals("20", calc.addNumber("0"));
        Assert.assertEquals("200", calc.addNumber("0"));
        Assert.assertEquals("200+", calc.plus());
        Assert.assertEquals("200+5", calc.addNumber("5"));
        Assert.assertEquals("200+50", calc.addNumber("0"));
        Assert.assertEquals("200.0+100.0", calc.percent());
    }

    @Test
    public void testEquals1() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("0", calc.addNumber("0"));
        Assert.assertEquals("0/", calc.divide());
        Assert.assertEquals("0/0", calc.addNumber("0"));
        Assert.assertEquals('/', calc.getMathOperations());
        Assert.assertArrayEquals(new String[]{"0/0", "Division undefined"}, calc.equals());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testEquals2() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("1", calc.addNumber("1"));
        Assert.assertEquals("1/", calc.divide());
        Assert.assertEquals("1/0", calc.addNumber("0"));
        Assert.assertEquals('/', calc.getMathOperations());
        Assert.assertArrayEquals(new String[]{"1/0", "Division by zero"}, calc.equals());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testEquals3() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("1", calc.addNumber("1"));
        Assert.assertEquals("1+", calc.plus());
        Assert.assertEquals("1+0", calc.addNumber("0"));
        Assert.assertEquals('+', calc.getMathOperations());
        Assert.assertArrayEquals(new String[]{"1+0", "1.0"}, calc.equals());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testEquals4() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("3", calc.addNumber("3"));
        Assert.assertEquals("3-", calc.minus());
        Assert.assertEquals("3-2", calc.addNumber("2"));
        Assert.assertEquals('-', calc.getMathOperations());
        Assert.assertArrayEquals(new String[]{"3-2", "1.0"}, calc.equals());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testEquals5() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("8", calc.addNumber("8"));
        Assert.assertEquals("8/", calc.divide());
        Assert.assertEquals("8/4", calc.addNumber("4"));
        Assert.assertEquals('/', calc.getMathOperations());
        Assert.assertArrayEquals(new String[]{"8/4", "2"}, calc.equals());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testEquals6() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("5", calc.addNumber("5"));
        Assert.assertEquals("5*", calc.multiply());
        Assert.assertEquals("5*6", calc.addNumber("6"));
        Assert.assertEquals('*', calc.getMathOperations());
        Assert.assertArrayEquals(new String[]{"5*6", "30.00"}, calc.equals());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testEquals7() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertArrayEquals(new String[]{"", ""}, calc.equals());
        Assert.assertArrayEquals(new String[]{"", ""}, calc.equals());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testEquals8() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("0", calc.addNumber("0"));
        Assert.assertArrayEquals(new String[]{"", "0"}, calc.equals());
        Assert.assertArrayEquals(new String[]{"", "0"}, calc.equals());
        Assert.assertEquals(' ', calc.getMathOperations());
    }

    @Test
    public void testEquals9() {
        CalculatorSimple calc = new CalculatorSimple();
        Assert.assertEquals("2", calc.addNumber("2"));
        Assert.assertEquals("2+", calc.plus());
        Assert.assertEquals("2+2", calc.addNumber("2"));
        Assert.assertEquals('+', calc.getMathOperations());
        Assert.assertArrayEquals(new String[]{"2+2", "4.0"}, calc.equals());
        Assert.assertEquals(' ', calc.getMathOperations());
        Assert.assertEquals("4.0+", calc.plus());
        Assert.assertEquals("4.0+6", calc.addNumber("6"));
        Assert.assertEquals('+', calc.getMathOperations());
        Assert.assertArrayEquals(new String[]{"4.0+6", "10.0"}, calc.equals());
        Assert.assertEquals(' ', calc.getMathOperations());
    }
}
