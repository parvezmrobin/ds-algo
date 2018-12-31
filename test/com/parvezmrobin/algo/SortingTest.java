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
    void bubbleSort() {
        double[] array = {5, 4, 3, 2, 1};
        assertArrayEquals(new double[]{1, 2, 3, 4, 5}, Sorting.bubbleSort(array));
        array = new double[]{3, 4, 2, 1, 5};
        assertArrayEquals(new double[]{1, 2, 3, 4, 5}, Sorting.bubbleSort(array));
        array = new double[]{5, 2, 1, 2, 2};
        assertArrayEquals(new double[]{1, 2, 2, 2, 5}, Sorting.bubbleSort(array));
        array = new double[]{1, 2, 3, 4, 5};
        assertArrayEquals(new double[]{1, 2, 3, 4, 5}, Sorting.bubbleSort(array));
    }

    @Test
    void selectionSort() {
        double[] array = {5, 4, 3, 2, 1};
        assertArrayEquals(new double[]{1, 2, 3, 4, 5}, Sorting.selectionSort(array));
        array = new double[]{3, 4, 2, 1, 5};
        assertArrayEquals(new double[]{1, 2, 3, 4, 5}, Sorting.selectionSort(array));
        array = new double[]{5, 2, 1, 2, 2};
        assertArrayEquals(new double[]{1, 2, 2, 2, 5}, Sorting.selectionSort(array));
        array = new double[]{1, 2, 3, 4, 5};
        assertArrayEquals(new double[]{1, 2, 3, 4, 5}, Sorting.selectionSort(array));
    }
}