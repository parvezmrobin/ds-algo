package com.parvezmrobin.algo;

import org.jetbrains.annotations.NotNull;

import static com.parvezmrobin.algo.Utility.makeCopy;

public class Combination {
    private static int[][] result;
    private static int index;

    public static int[][] permutations(int[] array) {
        return permutations(array, array.length);
    }

    public static int[][] permutations(int[] array, int r) {
        array = makeCopy(array);
        int fact = Utility.nPr(array.length, r);
        Combination.result = new int[fact][];
        Combination.index = 0;

        recursivePermutation(array, 0, r);
        return Combination.result;
    }

    private static void recursivePermutation(int[] array, int l, int r) {
        if (l == r) {
            Combination.result[Combination.index++] = makeCopy(array, r);
            return;
        }

        int temp;
        for (int i = l; i < array.length; i++) {
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
        int fact = Utility.nCr(array.length, r);
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
        recursiveCombinations(array, r, combination, i + 1, j + 1);
    }

    public static int[][] subsets(int[] array) {
        return subsets(array, 0);
    }

    public static int[][] subsets(int[] array, int minSize) {
        if (minSize < 0) {
            throw new IllegalArgumentException("minSize must be a non-negative number.");
        }
        int numResults = (int) Math.pow(2, array.length);
        Combination.result = new int[numResults][];
        Combination.index = 0;
        if (minSize == 0) {
            Combination.result[0] = new int[0];
            Combination.index = 1;
        }

        recursiveSubsets(array, minSize - 1, new int[array.length], 0, 0);
        int[][] copy = new int[Combination.index][];
        System.arraycopy(Combination.result, 0, copy, 0, Combination.index);
        return copy;
    }

    private static void recursiveSubsets(@NotNull int[] array, int minSize, int[] subset, int i, int j) {
        for (int k = j; k < array.length; k++) {
            subset[i] = array[k];
            if (i >= minSize && i < array.length) {
                Combination.result[Combination.index++] = makeCopy(subset, i + 1);
            }
            recursiveSubsets(array, minSize, subset, i + 1, k + 1);
        }
    }

    public static int[][] backtrack(int[] actions, int steps) {
        if (steps < 0) {
            throw new IllegalArgumentException("steps must be a non-negative number.");
        }
        if (actions.length == 0) {
            throw new IllegalArgumentException("actions must be non-empty.");
        }

        int numResults = (int) Math.pow(actions.length, steps);
        Combination.result = new int[numResults][];
        Combination.index = 0;

        recursiveBacktrack(actions, steps, new int[steps], 0);
        return Combination.result;
    }

    private static void recursiveBacktrack(@NotNull int[] actions, int steps, int[] sequence, int i) {
        if (i == steps) {
            Combination.result[Combination.index++] = makeCopy(sequence);
            return;
        }
        for (int action : actions) {
            sequence[i] = action;
            recursiveBacktrack(actions, steps, sequence, i + 1);
        }
    }
}
