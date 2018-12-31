package com.parvezmrobin.algo;

import org.jetbrains.annotations.NotNull;

public class Utility {
    public static double[] makeCopy(@NotNull double[] array) {
        double[] copy = new double[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
}
