package com.parvezmrobin.algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CombinationTest {

    @Test
    void permutations() {
        // nPn tests
        int[][] combs = Combination.permutations(new int[]{1, 2, 3});
        int[][] expected = {
                {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 2, 1}, {3, 1, 2}
        };
        assertArrayEquals(expected, combs);

        combs = Combination.permutations(new int[]{1, 2, 3, 4});
        expected = new int[][]{
                {1, 2, 3, 4}, {1, 2, 4, 3}, {1, 3, 2, 4}, {1, 3, 4, 2}, {1, 4, 3, 2}, {1, 4, 2, 3},
                {2, 1, 3, 4}, {2, 1, 4, 3}, {2, 3, 1, 4}, {2, 3, 4, 1}, {2, 4, 3, 1}, {2, 4, 1, 3},
                {3, 2, 1, 4}, {3, 2, 4, 1}, {3, 1, 2, 4}, {3, 1, 4, 2}, {3, 4, 1, 2}, {3, 4, 2, 1},
                {4, 2, 3, 1}, {4, 2, 1, 3}, {4, 3, 2, 1}, {4, 3, 1, 2}, {4, 1, 3, 2}, {4, 1, 2, 3},
        };
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected.length; j++) {
                if (i == j) continue;

                assertFalse(Arrays.equals(expected[i], expected[j]));
            }
        }
        assertArrayEquals(expected, combs);

        combs = Combination.permutations(new int[]{1});
        expected = new int[][]{{1},};
        assertArrayEquals(expected, combs);

        combs = Combination.permutations(new int[]{1, 2});
        expected = new int[][]{{1, 2}, {2, 1},};
        assertArrayEquals(expected, combs);

        // nPr tests

        combs = Combination.permutations(new int[]{1, 2, 3}, 2);
        expected = new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 3}, {3, 2}, {3, 1}};
        assertArrayEquals(expected, combs);

        combs = Combination.permutations(new int[]{1, 2, 3}, 1);
        expected = new int[][]{{1}, {2}, {3}};
        assertArrayEquals(expected, combs);

        combs = Combination.permutations(new int[]{1, 2, 3}, 0);
        expected = new int[][]{{}};
        assertArrayEquals(expected, combs);
    }

    @Test
    void combinations() {
        int[][] combs = Combination.combinations(new int[]{1, 2, 3, 4, 5}, 3);
        int[][] expected = {
                {3, 4, 5}, {2, 4, 5}, {2, 3, 5}, {2, 3, 4}, {1, 4, 5},
                {1, 3, 5}, {1, 3, 4}, {1, 2, 5}, {1, 2, 4}, {1, 2, 3},
        };
        assertArrayEquals(expected, combs);

        combs = Combination.combinations(new int[]{1, 2, 3, 4, 5}, 4);
        expected = new int[][]{
                {2, 3, 4, 5}, {1, 3, 4, 5}, {1, 2, 4, 5}, {1, 2, 3, 5}, {1, 2, 3, 4},
        };
        assertArrayEquals(expected, combs);

        combs = Combination.combinations(new int[]{1, 2, 3, 4, 5}, 5);
        expected = new int[][]{{1, 2, 3, 4, 5}};
        assertArrayEquals(expected, combs);

        combs = Combination.combinations(new int[]{1, 2, 3, 4, 5}, 1);
        expected = new int[][]{{5}, {4}, {3}, {2}, {1}};
        assertArrayEquals(expected, combs);

        combs = Combination.combinations(new int[]{1, 2, 3, 4, 5}, 0);
        expected = new int[][]{{}};
        assertArrayEquals(expected, combs);
    }

    @Test
    void subsets() {
        int[][] combs = Combination.subsets(new int[]{1, 2, 3});
        int[][] expected = new int[][]{{}, {1}, {1, 2}, {1, 2, 3}, {1, 3}, {2}, {2, 3}, {3}};
        assertArrayEquals(expected, combs);

        combs = Combination.subsets(new int[0]);
        expected = new int[][]{{}};
        assertArrayEquals(expected, combs);

        combs = Combination.subsets(new int[]{1});
        expected = new int[][]{{}, {1}};
        assertArrayEquals(expected, combs);

        // minSize tests

        combs = Combination.subsets(new int[]{1, 2, 3}, 1);
        expected = new int[][]{{1}, {1, 2}, {1, 2, 3}, {1, 3}, {2}, {2, 3}, {3}};
        assertArrayEquals(expected, combs);

        combs = Combination.subsets(new int[]{1, 2, 3}, 2);
        expected = new int[][]{{1, 2}, {1, 2, 3}, {1, 3}, {2, 3}};
        assertArrayEquals(expected, combs);

        combs = Combination.subsets(new int[]{1, 2, 3}, 4);
        expected = new int[][]{};
        assertArrayEquals(expected, combs);

        combs = Combination.subsets(new int[0]);
        expected = new int[][]{{}};
        assertArrayEquals(expected, combs);

        combs = Combination.subsets(new int[0], 1);
        expected = new int[][]{};
        assertArrayEquals(expected, combs);

        combs = Combination.subsets(new int[0], 2);
        expected = new int[][]{};
        assertArrayEquals(expected, combs);

        combs = Combination.subsets(new int[]{1}, 1);
        expected = new int[][]{{1}};
        assertArrayEquals(expected, combs);

        combs = Combination.subsets(new int[]{1}, 2);
        expected = new int[][]{};
        assertArrayEquals(expected, combs);
    }

    @Test
    void backtrack() {
        int[][] combs = Combination.backtrack(new int[]{1, 2, 3}, 2);
        int[][] expected = new int[][]{{1, 1}, {1, 2}, {1, 3}, {2, 1}, {2, 2}, {2, 3}, {3, 1}, {3, 2}, {3, 3}};
        assertArrayEquals(expected, combs);

        assertThrows(IllegalArgumentException.class, () -> Combination.backtrack(new int[0], 0));
        assertThrows(IllegalArgumentException.class, () -> Combination.backtrack(new int[0], 1));

        combs = Combination.backtrack(new int[]{1}, 0);
        expected = new int[][]{{}};
        assertArrayEquals(expected, combs);

        combs = Combination.backtrack(new int[]{1}, 1);
        expected = new int[][]{{1}};
        assertArrayEquals(expected, combs);

        combs = Combination.backtrack(new int[]{1, 2, 3}, 1);
        expected = new int[][]{{1}, {2}, {3}};
        assertArrayEquals(expected, combs);

        combs = Combination.backtrack(new int[]{1}, 4);
        expected = new int[][]{{1, 1, 1, 1}};
        assertArrayEquals(expected, combs);
    }
}