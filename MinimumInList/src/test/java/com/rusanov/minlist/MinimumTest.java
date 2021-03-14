package com.rusanov.minlist;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

class MinimumTest {


    @Test
    public void findDoubleMinTest() {
        List<Double> list = new ArrayList<>(){{
            add(3.0);
            add(5.0);
            add(2.00001);
            add(-2.00001);
        }};
        Double result = Minimum.findMin(list,0, 4);

        assertEquals(2.00001, result, 0.0001);
    }


    @Test
    public void InvalidBoundTest() {
        List<Double> list = new ArrayList<>(){{
            add(3.0);
            add(5.0);
            add(2.00001);
            add(-2.00001);
        }};
       //end
        try {
            Minimum.findMin(list, 0, 100);
            fail();
        } catch (IllegalArgumentException exception) {
            assertEquals("Error end argument", exception.getMessage());
        }
        try {
            Minimum.findMin(list, -2, 4);
            fail();
        } catch (IllegalArgumentException exception) {
            assertEquals("Error start argument", exception.getMessage());
        }

    }

    @Test
    public void OneElementTest() {
        List<Double> list = new ArrayList<>(){{
            add(4.0);
            add(3.0);
        }};
        assertEquals(3.0 ,Minimum.findMin(list, 1, 2), 0.0001);
        assertEquals(3.0 ,Minimum.findMin(list, 1, 1), 0.0001);
        assertEquals(4.0 ,Minimum.findMin(list, 0, 0), 0.0001);
        assertEquals(4.0 ,Minimum.findMin(list, 0, 1), 0.0001);
    }



}