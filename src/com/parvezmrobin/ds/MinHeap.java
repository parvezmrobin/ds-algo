package com.parvezmrobin.ds;

public class MinHeap extends Heap {

    public MinHeap(double[] values) {
        super(values);
    }

    public MinHeap(int initialSize) {
        super(initialSize);
    }

    public MinHeap() {
    }

    @Override
    protected void heapify(int i) {
        double temp = this.heap[i];
        int parent;
        while (true) {
            parent = this.parent(i);
            if (this.heap[parent] < temp) break;
            // while temp is smaller than the parent element
            // move the parent element to it's child
            // to make hole for temp
            this.heap[i] = this.heap[parent];
            i = parent;
            if (i == 0) break;  // if its the top, stop
        }
        this.heap[i] = temp;  // place temp in the hole
    }

    protected void deleteTop() {
        int i = 1;
        double temp = this.heap[this.heapSize - 1];

        while (i < this.heapSize) {
            if (i < this.heapSize - 1 && this.heap[i] > this.heap[i + 1]) {
                // if leftChild is smaller than rightChild
                // point to rightChild
                i++;
            }

            if (temp < this.heap[i]) {
                // if temp is greater than current value
                // stop and place temp here
                break;
            }

            this.heap[this.parent(i)] = this.heap[i];
            i = this.leftChild(i);
        }

        this.heap[this.parent(i)] = temp;
    }
}
