package com.parvezmrobin.algo;

import com.parvezmrobin.ds.Heap;
import com.parvezmrobin.ds.MaxHeap;

public class Sorting {
    public static double[] heapSort(double[] array) {
        Heap heap = new MaxHeap(array);
        double[] sortedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = heap.pop();
        }
        return sortedArray;
    }

    public static int[] heapSort(int[] array){
        double[] doubleArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            doubleArray[i] = (double) array[i];
        }

        double[] sortedArray = heapSort(doubleArray);

        int[] sortedIntArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedIntArray[i] = (int) sortedArray[i];
        }

        return sortedIntArray;
    }
}
