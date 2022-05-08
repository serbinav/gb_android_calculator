package com.example.calculator;

import org.junit.Assert;
import org.junit.Test;

public class PresenterTestOld {

    MainContract.Presenter<MainContract.View> presenter = new MainPresenter();

//    @Test
//    public void testDiscard1() {
//        Assert.assertEquals("1", presenter.addNumber("1"));
//        Assert.assertEquals("", presenter.discard());
//    }
//
//    @Test
//    public void testDiscard2() {
//        Assert.assertEquals("1", presenter.addNumber("1"));
//        Assert.assertEquals("1+", presenter.plus());
//        Assert.assertEquals(1.0f, presenter.getNumericOne(), 0);
//        Assert.assertEquals('+', presenter.getMathOperations());
//        Assert.assertEquals("", presenter.discard());
//        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testChangeSymbol1() {
//        Assert.assertEquals("2", presenter.addNumber("2"));
//        Assert.assertEquals("-2", presenter.changeSymbol());
//        Assert.assertEquals("2", presenter.changeSymbol());
//    }
//
//    @Test
//    public void testChangeSymbol2() {
//        Assert.assertEquals("-", presenter.changeSymbol());
//        Assert.assertEquals("", presenter.changeSymbol());
//        Assert.assertEquals("-", presenter.changeSymbol());
//        Assert.assertEquals("-3", presenter.addNumber("3"));
//    }
//
//    @Test
//    public void testDelete1() {
//        Assert.assertEquals("4", presenter.addNumber("4"));
//        Assert.assertEquals("44", presenter.addNumber("4"));
//        Assert.assertEquals("4", presenter.delete());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testDelete2() {
//        Assert.assertEquals("4", presenter.addNumber("4"));
//        Assert.assertEquals("44", presenter.addNumber("4"));
//        Assert.assertEquals("44-", presenter.minus());
//        Assert.assertEquals('-', presenter.getMathOperations());
//        Assert.assertEquals("44", presenter.delete());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testDelete3() {
//        Assert.assertEquals("4", presenter.addNumber("4"));
//        Assert.assertEquals("44", presenter.addNumber("4"));
//        Assert.assertEquals("44-", presenter.minus());
//        Assert.assertEquals("44-5", presenter.addNumber("5"));
//        Assert.assertEquals("44-55", presenter.addNumber("5"));
//        Assert.assertEquals("44-5", presenter.delete());
//        Assert.assertEquals('-', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testDelete4() {
//        Assert.assertEquals("6", presenter.addNumber("6"));
//        Assert.assertEquals("66", presenter.addNumber("6"));
//        Assert.assertEquals("66.", presenter.dot());
//        Assert.assertEquals("66.7", presenter.addNumber("7"));
//        Assert.assertEquals("66.77", presenter.addNumber("7"));
//        Assert.assertEquals("66.7", presenter.delete());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testDot1() {
//        Assert.assertEquals("8", presenter.addNumber("8"));
//        Assert.assertEquals("8.", presenter.dot());
//        Assert.assertEquals("8.8", presenter.addNumber("8"));
//        Assert.assertEquals("8.8", presenter.dot());
//    }
//
//    @Test
//    public void testDot2() {
//        Assert.assertEquals(".", presenter.dot());
//        Assert.assertEquals(".9", presenter.addNumber("9"));
//    }
//
//    @Test
//    public void testPlus1() {
//        Assert.assertEquals("", presenter.plus());
//        Assert.assertEquals("", presenter.plus());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testPlus2() {
//        Assert.assertEquals("0", presenter.addNumber("0"));
//        Assert.assertEquals("0+", presenter.plus());
//        Assert.assertEquals("0+", presenter.plus());
//        Assert.assertEquals('+', presenter.getMathOperations());
//        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
//    }
//
//    @Test
//    public void testPlus3() {
//        Assert.assertEquals("0", presenter.addNumber("0"));
//        Assert.assertEquals("0+", presenter.plus());
//        Assert.assertEquals("0+1", presenter.addNumber("1"));
//        Assert.assertEquals("0+1", presenter.plus());
//        Assert.assertEquals('+', presenter.getMathOperations());
//        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
//    }
//
//    @Test
//    public void testMinus1() {
//        Assert.assertEquals("", presenter.minus());
//        Assert.assertEquals("", presenter.minus());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testMinus2() {
//        Assert.assertEquals("0", presenter.addNumber("0"));
//        Assert.assertEquals("0-", presenter.minus());
//        Assert.assertEquals("0-", presenter.minus());
//        Assert.assertEquals('-', presenter.getMathOperations());
//        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
//    }
//
//    @Test
//    public void testMinus3() {
//        Assert.assertEquals("0", presenter.addNumber("0"));
//        Assert.assertEquals("0-", presenter.minus());
//        Assert.assertEquals("0-1", presenter.addNumber("1"));
//        Assert.assertEquals("0-1", presenter.minus());
//        Assert.assertEquals('-', presenter.getMathOperations());
//        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
//    }
//
//    @Test
//    public void testDivide1() {
//        Assert.assertEquals("", presenter.divide());
//        Assert.assertEquals("", presenter.divide());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testDivide2() {
//        Assert.assertEquals("0", presenter.addNumber("0"));
//        Assert.assertEquals("0/", presenter.divide());
//        Assert.assertEquals("0/", presenter.divide());
//        Assert.assertEquals('/', presenter.getMathOperations());
//        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
//    }
//
//    @Test
//    public void testDivide3() {
//        Assert.assertEquals("0", presenter.addNumber("0"));
//        Assert.assertEquals("0/", presenter.divide());
//        Assert.assertEquals("0/1", presenter.addNumber("1"));
//        Assert.assertEquals("0/1", presenter.divide());
//        Assert.assertEquals('/', presenter.getMathOperations());
//        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
//    }
//
//    @Test
//    public void testMultiply1() {
//        Assert.assertEquals("", presenter.multiply());
//        Assert.assertEquals("", presenter.multiply());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testMultiply2() {
//        Assert.assertEquals("0", presenter.addNumber("0"));
//        Assert.assertEquals("0*", presenter.multiply());
//        Assert.assertEquals("0*", presenter.multiply());
//        Assert.assertEquals('*', presenter.getMathOperations());
//        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
//    }
//
//    @Test
//    public void testMultiply3() {
//        Assert.assertEquals("0", presenter.addNumber("0"));
//        Assert.assertEquals("0*", presenter.multiply());
//        Assert.assertEquals("0*1", presenter.addNumber("1"));
//        Assert.assertEquals("0*1", presenter.multiply());
//        Assert.assertEquals('*', presenter.getMathOperations());
//        Assert.assertEquals(0.0f, presenter.getNumericOne(), 0);
//    }
//
//    @Test
//    public void testPercent1() {
//        Assert.assertEquals("2", presenter.addNumber("2"));
//        Assert.assertEquals("20", presenter.addNumber("0"));
//        Assert.assertEquals("20", presenter.percent());
//    }
//
//    @Test
//    public void testPercent2() {
//        Assert.assertEquals("2", presenter.addNumber("2"));
//        Assert.assertEquals("20", presenter.addNumber("0"));
//        Assert.assertEquals("20+", presenter.plus());
//        Assert.assertEquals("20+", presenter.percent());
//    }
//
//    @Test
//    public void testPercent3() {
//        Assert.assertEquals("2", presenter.addNumber("2"));
//        Assert.assertEquals("20", presenter.addNumber("0"));
//        Assert.assertEquals("200", presenter.addNumber("0"));
//        Assert.assertEquals("200+", presenter.plus());
//        Assert.assertEquals("200+5", presenter.addNumber("5"));
//        Assert.assertEquals("200+50", presenter.addNumber("0"));
//        Assert.assertEquals("200.0+100.0", presenter.percent());
//    }
//
//    @Test
//    public void testEquals1() {
//        Assert.assertEquals("0", presenter.addNumber("0"));
//        Assert.assertEquals("0/", presenter.divide());
//        Assert.assertEquals("0/0", presenter.addNumber("0"));
//        Assert.assertEquals('/', presenter.getMathOperations());
//        Assert.assertArrayEquals(new String[]{"0/0", "Division undefined"}, presenter.equals());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testEquals2() {
//        Assert.assertEquals("1", presenter.addNumber("1"));
//        Assert.assertEquals("1/", presenter.divide());
//        Assert.assertEquals("1/0", presenter.addNumber("0"));
//        Assert.assertEquals('/', presenter.getMathOperations());
//        Assert.assertArrayEquals(new String[]{"1/0", "Division by zero"}, presenter.equals());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testEquals3() {
//        Assert.assertEquals("1", presenter.addNumber("1"));
//        Assert.assertEquals("1+", presenter.plus());
//        Assert.assertEquals("1+0", presenter.addNumber("0"));
//        Assert.assertEquals('+', presenter.getMathOperations());
//        Assert.assertArrayEquals(new String[]{"1+0", "1.0"}, presenter.equals());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testEquals4() {
//        Assert.assertEquals("3", presenter.addNumber("3"));
//        Assert.assertEquals("3-", presenter.minus());
//        Assert.assertEquals("3-2", presenter.addNumber("2"));
//        Assert.assertEquals('-', presenter.getMathOperations());
//        Assert.assertArrayEquals(new String[]{"3-2", "1.0"}, presenter.equals());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testEquals5() {
//        Assert.assertEquals("8", presenter.addNumber("8"));
//        Assert.assertEquals("8/", presenter.divide());
//        Assert.assertEquals("8/4", presenter.addNumber("4"));
//        Assert.assertEquals('/', presenter.getMathOperations());
//        Assert.assertArrayEquals(new String[]{"8/4", "2"}, presenter.equals());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testEquals6() {
//        Assert.assertEquals("5", presenter.addNumber("5"));
//        Assert.assertEquals("5*", presenter.multiply());
//        Assert.assertEquals("5*6", presenter.addNumber("6"));
//        Assert.assertEquals('*', presenter.getMathOperations());
//        Assert.assertArrayEquals(new String[]{"5*6", "30.00"}, presenter.equals());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testEquals7() {
//        Assert.assertArrayEquals(new String[]{"", ""}, presenter.equals());
//        Assert.assertArrayEquals(new String[]{"", ""}, presenter.equals());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testEquals8() {
//        Assert.assertEquals("0", presenter.addNumber("0"));
//        Assert.assertArrayEquals(new String[]{"", "0"}, presenter.equals());
//        Assert.assertArrayEquals(new String[]{"", "0"}, presenter.equals());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
//
//    @Test
//    public void testEquals9() {
//        Assert.assertEquals("2", presenter.addNumber("2"));
//        Assert.assertEquals("2+", presenter.plus());
//        Assert.assertEquals("2+2", presenter.addNumber("2"));
//        Assert.assertEquals('+', presenter.getMathOperations());
//        Assert.assertArrayEquals(new String[]{"2+2", "4.0"}, presenter.equals());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//        Assert.assertEquals("4.0+", presenter.plus());
//        Assert.assertEquals("4.0+6", presenter.addNumber("6"));
//        Assert.assertEquals('+', presenter.getMathOperations());
//        Assert.assertArrayEquals(new String[]{"4.0+6", "10.0"}, presenter.equals());
//        Assert.assertEquals(' ', presenter.getMathOperations());
//    }
}
