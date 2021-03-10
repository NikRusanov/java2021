package com.rusanov.swap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SwapTest {


    Swapper swapper = new Swapper();


    @Test
    public void validSwapTest() {
        int[] arr = new int[10];
        for (int i =0 ; i < 10; ++i) {
            arr[i] = i;
        }

        int value1 = arr[0];
        int value2 = arr[5];

        swapper.swap(0,5,arr);

        assertEquals(arr[0], value2);
        assertEquals(arr[5],value1);
    }

    @Test
    public void swapNullArray() {
        int[] arr = null;

        assertFalse(swapper.swap(0, 5, arr));
    }

    @Test
    public void  swapEmptyArray() {
        int[] arr = new int[0];

        assertFalse(swapper.swap(0, 5, arr));
    }

    @Test
    public void swapOutOfRightBoundElements() {
        int[] array = new int[5];

        assertFalse(swapper.swap(0, 30, array));
    }

    @Test
    public void swapOutOfLeftBoundElements() {
        int[] array = new int[5];

        assertFalse(swapper.swap(-5, 3, array));
    }



    @Test
    public void validListSwap() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<10; ++i) {
            list.add(i);
        }

        Integer value1 = list.get(0);
        Integer value2 = list.get(5);

        swapper.swap(0,5, list);

        assertEquals(list.get(0), value2);
        assertEquals(list.get(5),value1);
    }

    @Test
    public void EmptyListSwap() {
        List<String> strings = new ArrayList<>();
        assertFalse(swapper.swap(2,4, strings));
    }


    @Test
    public void OutOfRightBoundListException() {
        List<Integer> integers = new ArrayList<>();
        assertFalse(swapper.swap(0, 30, integers));
    }


    @Test
    public void swapOutOfLeftBoundListElements() {
        List<Integer> integers = new ArrayList<>();
        assertFalse(swapper.swap(-5, 3, integers));
    }

}
