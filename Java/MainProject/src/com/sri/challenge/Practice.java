package com.sri.challenge;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        reverse(new int[]{1, 2, 3, 4});
    }

    private static void reverse(int[] array) {
        System.out.println("Array = " + Arrays.toString(array));
        int[] array1 = new int[array.length];
        int y = array.length;
        for (int i = 0; i < array.length; i++) {
            array1[i] = array[y - 1];
            y--;
        }
        System.out.println("Reversed array = " + Arrays.toString(array1));
    }
}
