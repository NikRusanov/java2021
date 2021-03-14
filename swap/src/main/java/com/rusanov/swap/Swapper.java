package com.rusanov.swap;

import java.util.List;

public class Swapper {

    private int length;

    public boolean swap(int i, int j, int[] anArray) {
        if(anArray == null) return false;
        length = anArray.length;
        if( length == 0 ) return false;
        // false ?
        if(!isValidIndexes(i,j)) throw new IllegalArgumentException("bad indexes");

        int tmp = anArray[i];
        anArray[i] = anArray[j];
        anArray[j] = tmp;
        return true;
    }





    public  <T> boolean swap(int i, int j, List<T> anArray) {
        if(anArray == null || anArray.isEmpty()) return false;
        if(!isValidIndexes(i,j))
            anArray.set(i, anArray.set(j, anArray.get(i)));

        return true;
    }



    private boolean isValidIndexes(int i, int j) {
        return isValid(i) && isValid(j);
    }
    private boolean isValid(int i) {
        return (i >= 0) && i < length;
    }




}


