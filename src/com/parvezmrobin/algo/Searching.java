package com.parvezmrobin.algo;

public class Searching {
    public static int linearSearch(double[] haystack, double needle){
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == needle){
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(double[] haystack, double needle) {
        return binarySearch(haystack, needle, false);
    }

    public static int binarySearch(double[] haystack, double needle, boolean sort){
        if (sort){
            haystack = Sorting.selectionSort(haystack);
        }
        return recursiveBinarySearch(haystack, needle, 0, haystack.length - 1);
    }

    private static int recursiveBinarySearch(double[] haystack, double needle, int l, int h) {
        int m = (l+h)/2;
        if (haystack[m] == needle){
            return m;
        }
        if (l == h){
            return -1;
        }
        if (needle <= haystack[l]) {
            return recursiveBinarySearch(haystack, needle, 0, l);
        }
        return recursiveBinarySearch(haystack, needle, l+1, h);
    }
}
