package com.rusanov.adder;

public class Adder implements Calculator{
    @Override
    public int summ(int x, int y) {
       //  ((x ^ r) & (y ^ r)) < 0

        return Math.addExact(x, y);
    }
}
