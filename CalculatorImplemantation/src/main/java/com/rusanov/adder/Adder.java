package com.rusanov.adder;

public class Adder implements Calculator{
    @Override
    public int summ(int x, int y) {
        return Math.addExact(x, y);
    }
}
