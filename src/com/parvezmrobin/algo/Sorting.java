package com.parvezmrobin.algo;

import com.parvezmrobin.ds.Heap;
import com.parvezmrobin.ds.MaxHeap;
import org.jetbrains.annotations.NotNull;

public class Sorting {
    public static double[] heapSort(double[] array) {
        Heap heap = new MaxHeap(array);
        double[] sortedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = heap.pop();
        }
        return sortedArray;
    }

    public static double[] bubbleSort(double[] array){
        double[] copy = makeCopy(array);

        for (int i = 1; i < copy.length; i++) {
            double temp = copy[i];
            int j;
            for (j = i; j > 0; j--) {
                if (copy[j-1] > temp) {
                    copy[j] = copy[j-1];
                } else {
                    break;
                }
            }
            copy[j] = temp;
        }

        return copy;
    }

    public static double[] selectionSort(double[] array){
        double[] copy = makeCopy(array);

        for (int i = 0; i < copy.length - 1; i++) {
            int min_index = i;
            for (int j = i; j < copy.length; j++) {
                if (copy[j] < copy[min_index]){
                    min_index = j;
                }
            }

            double temp = copy[i];
            copy[i] = copy[min_index];
            copy[min_index] = temp;
        }

        return copy;
    }

    private static double[] makeCopy(@NotNull double[] array) {
        double[] copy = new double[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
}
