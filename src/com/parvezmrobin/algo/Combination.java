package com.parvezmrobin.algo;

import static com.parvezmrobin.algo.Utility.factorial;
import static com.parvezmrobin.algo.Utility.makeCopy;

public class Combination {
    private static int[][] result;
    private static int index;

    public static int[][] permutations(int[] array) {
        array = makeCopy(array);
        int fact = factorial(array.length);
        Combination.result = new int[fact][];
        Combination.index = 0;

        recursivePermutation(array, 0, array.length - 1);
        return Combination.result;
    }

    private static void recursivePermutation(int[] array, int l, int r) {
        if (l == r) {
            Combination.result[Combination.index++] = makeCopy(array);
            return;
        }

        int temp;
        for (int i = l; i <= r; i++) {
            // swap
            temp = array[i];
            array[i] = array[l];
            array[l] = temp;

            recursivePermutation(array, l + 1, r);

            // swap back
            temp = array[i];
            array[i] = array[l];
            array[l] = temp;
        }
    }

    public static int[][] combinations(int[] array, int r) {
        array = makeCopy(array);
        int fact = factorial(array.length, r + 1) / factorial(array.length - r);
        Combination.result = new int[fact][];
        Combination.index = 0;

        recursiveCombinations(array, r, new int[r], 0, 0);
        return Combination.result;
    }

    private static void recursiveCombinations(int[] array, int r, int[] combination, int i, int j) {
        if (i == r) {
            Combination.result[Combination.index++] = makeCopy(combination);
            return;
        }
        if (j >= array.length) {
            return;
        }

        recursiveCombinations(array, r, combination, i, j + 1);
        combination[i] = array[j];
        recursiveCombinations(array, r, combination, i+1, j + 1);
    }
}
