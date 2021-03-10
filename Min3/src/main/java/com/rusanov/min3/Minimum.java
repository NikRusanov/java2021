package com.rusanov.min3;

public class Minimum {



    public static int findMin(int a, int b, int c) {
            return  findMin(findMin(a,b), c);
    }

    private static int findMin(int a, int b) {
        return a <= b ? a : b ;
    }
}
