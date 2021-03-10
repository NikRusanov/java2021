package com.rusanov.min3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumTest {

    @Test
    public void findMinimum() {
        int  a = -500;
        int b = -50;
        int c = -10;
        assertEquals(-500, Minimum.findMin(a, b, c));
    }
}
