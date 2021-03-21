package com.rusanov.swap;

import java.util.List;

public class Swapper {


    public boolean swap(int i, int j, int[] anArray) {
        if(anArray == null) return false;
        int length = anArray.length;
        if( length == 0 ) return false;
        if(!isValidIndexes(i,j, length)) {
            throw new IllegalArgumentException("bad indexes");
        }
        int tmp = anArray[i];
        anArray[i] = anArray[j];
        anArray[j] = tmp;
        return true;
    }





    public  <T> boolean swap(int i, int j, List<T> anArray) {
        if(anArray == null || anArray.isEmpty()) return false;
        int length = anArray.size();
        if(isValidIndexes(i,j, length)) {
            anArray.set(i, anArray.set(j, anArray.get(i)));
        }
        return true;
    }



    private boolean isValidIndexes(int i, int j, int length) {
        return isValid(i, length) && isValid(j, length);
    }
    private boolean isValid(int i, int length) {
        return (i >= 0) && (i < length);
    }




}


