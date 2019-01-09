package com.parvezmrobin.algo;

import org.jetbrains.annotations.NotNull;

public class Utility {
    public static double[] makeCopy(@NotNull double[] array) {
        double[] copy = new double[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    public static int[] makeCopy(@NotNull int[] array) {
        return makeCopy(array, array.length);
    }

    public static int[] makeCopy(@NotNull int[] array, int length) {
        int[] copy = new int[length];
        System.arraycopy(array, 0, copy, 0, length);
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

    public static int nCr(int n, int r) {
        return factorial(n, r + 1) / factorial(n - r);
    }

    public static int nPr(int n, int r) {
        return factorial(n) / factorial(n - r);
    }
}
