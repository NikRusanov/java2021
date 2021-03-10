package com.rusanov.adder;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdderTest {

    @Test
    public void overflowTest() {
        int x = Integer.MAX_VALUE;
        int y = 1;
        try {
            new Adder().summ(x,y);
            fail();
        } catch (ArithmeticException ex) {
            String message = "integer overflow";
            assertEquals(message, ex.getMessage());
        }
    }


    @Test
    public void normalAdd() {
//        int x = 5;
//        int y = Integer.MAX_VALUE - 5 ;
        Adder adder = new Adder();
//        assertEquals(Integer.MAX_VALUE, adder.summ(x,y));
        int x = -3;
        int y = Integer.MIN_VALUE + 3;
        assertEquals(Integer.MIN_VALUE, adder.summ(x,y));
    }


    @Test
    public void underflowTest(){
        int x = Integer.MIN_VALUE;
        int y = -1;
        try {
            System.out.println( new Adder().summ(x,y));;
        } catch (ArithmeticException ex) {
            String message = "integer overflow";
            assertEquals(message, ex.getMessage());
        }
    }
}
