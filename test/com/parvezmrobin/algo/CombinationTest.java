package com.parvezmrobin.algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CombinationTest {

    @Test
    void permutations() {
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
                if (i==j) continue;

                assertFalse(Arrays.equals(expected[i], expected[j]));
            }
        }
        assertArrayEquals(expected, combs);
    }
}