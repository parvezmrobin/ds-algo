package com.parvezmrobin.algo;

import static com.parvezmrobin.algo.Utility.factorial;
import static com.parvezmrobin.algo.Utility.makeCopy;

public class Combination {
    private static int[][] result;
    private static int index;

    public static int[][] permutations(int[] array){
        array = makeCopy(array);
        int fact = factorial(array.length);
        Combination.result = new int[fact][];
        Combination.index = 0;

        recursivePermutation(array, 0, array.length-1);
        return Combination.result;
    }

    private static void recursivePermutation(int[] array, int l, int r){
        if (l==r){
            Combination.result[Combination.index++] = makeCopy(array);
            return;
        }

        int temp;
        for (int i = l; i <= r; i++) {
            // swap
            temp = array[i];
            array[i] = array[l];
            array[l] = temp;

            recursivePermutation(array, l+1, r);

            // swap back
            temp = array[i];
            array[i] = array[l];
            array[l] = temp;
        }
    }

}
