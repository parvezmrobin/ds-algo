package com.parvezmrobin.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    void heapSort() {
        double[] array = {5, 4, 3, 2, 1};
        assertArrayEquals(new double[]{5, 4, 3, 2, 1}, Sorting.heapSort(array));
        array = new double[]{3, 4, 2, 1, 5};
        assertArrayEquals(new double[]{5, 4, 3, 2, 1}, Sorting.heapSort(array));
        array = new double[]{5, 2, 1, 2, 2};
        assertArrayEquals(new double[]{5, 2, 2, 2, 1}, Sorting.heapSort(array));
        array = new double[]{1, 2, 3, 4, 5};
        assertArrayEquals(new double[]{5, 4, 3, 2, 1}, Sorting.heapSort(array));
    }

    @Test
    void heapSortInt() {
        int[] array = {5, 4, 3, 2, 1};
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, Sorting.heapSort(array));
        array = new int[]{3, 4, 2, 1, 5};
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, Sorting.heapSort(array));
        array = new int[]{5, 2, 1, 2, 2};
        assertArrayEquals(new int[]{5, 2, 2, 2, 1}, Sorting.heapSort(array));
        array = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, Sorting.heapSort(array));
    }
}