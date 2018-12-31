package com.parvezmrobin.algo;

import org.jetbrains.annotations.NotNull;

public class Utility {
    public static double[] makeCopy(@NotNull double[] array) {
        double[] copy = new double[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    public static int[] makeCopy(@NotNull int[] array) {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    public static int factorial(int number) {
        return factorial(number, 1);
    }

    public static int factorial(int number, int base) {
        if (number <= 1) return 1;

        if (number < base) return 1;

        return number * factorial(number - 1, base);
    }
}
