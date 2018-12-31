package com.parvezmrobin.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchingTest {

    @Test
    void linearSearch() {
        double[] haystack = {5, 1, 6, 2, 7, 3, 5, 7, 11, 4, 3, 2, 9, 8};
        assertEquals(0, Searching.linearSearch(haystack, 5));
        assertEquals(5, Searching.linearSearch(haystack, 3));
        assertEquals(2, Searching.linearSearch(haystack, 6));
        assertEquals(-1, Searching.linearSearch(haystack, 10));
    }

    @Test
    void binarySearch() {
        double[] haystack = {1, 1, 2, 4, 5, 6, 7, 8, 9, 9, 11, 11, 14, 19};

        assertEquals(4, Searching.binarySearch(haystack, 5));
        assertEquals(-1, Searching.binarySearch(haystack, 3));
        assertEquals(5, Searching.binarySearch(haystack, 6));
        assertEquals(10, Searching.binarySearch(haystack, 11));
    }
}