package com.rusanov.minlist;

import java.util.List;



public class Minimum {


    public  static <T extends Comparable<T>>  T findMin(List<T> list, int start, int end) {
        //?????? throw Exception ???????
        if (list == null || list.isEmpty()) return null;

        int size = list.size();

        if(start < 0 || start > size) return null;
        if(end  > size || end < 0) return null;

        if(end < start) {
            start = start + end;
            end = start - end;
            start = start - end;
        }
        T minimum = list.get(start);

        for (int i = start ; i < end - 1; ++i) {
            T currentElem = list.get(i);
            if (minimum.compareTo(currentElem) > 0 ) minimum = currentElem;
        }

        return minimum;
    }


}
