package com.parvezmrobin.algo;

import com.parvezmrobin.ds.Heap;
import com.parvezmrobin.ds.MaxHeap;
import com.parvezmrobin.ds.MinHeap;
import org.jetbrains.annotations.NotNull;

public class Sorting {
    public static double[] heapSort(double[] array) {
        return heapSort(array, false);
    }

    public static double[] heapSort(double[] array, boolean reverse) {
        Heap heap;
        if (reverse) {
            heap = new MaxHeap(array);
        } else {
            heap = new MinHeap(array);
        }
        double[] sortedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = heap.pop();
        }
        return sortedArray;
    }

    public static double[] bubbleSort(double[] array){
        return bubbleSort(array, false);
    }

    public static double[] bubbleSort(double[] array, boolean reverse){
        array = makeCopy(array);

        for (int i = 1; i < array.length; i++) {
            double temp = array[i];
            int j;
            for (j = i; j > 0; j--) {
                if ((reverse && array[j - 1] < temp) || !(reverse || array[j - 1] <= temp)){
                    array[j] = array[j-1];
                } else {
                    break;
                }
            }
            array[j] = temp;
        }

        return array;
    }

    public static double[] selectionSort(double[] array){
        return selectionSort(array, false);
    }

    public static double[] selectionSort(double[] array, boolean reverse){
        array = makeCopy(array);

        for (int i = 0; i < array.length - 1; i++) {
            int optimum_index = i;
            for (int j = i; j < array.length; j++) {
                if (!(reverse || array[j] >= array[optimum_index]) || (reverse && array[j] > array[optimum_index])){
                    optimum_index = j;
                }
            }

            double temp = array[i];
            array[i] = array[optimum_index];
            array[optimum_index] = temp;
        }

        return array;
    }

    private static double[] makeCopy(@NotNull double[] array) {
        double[] copy = new double[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
}
