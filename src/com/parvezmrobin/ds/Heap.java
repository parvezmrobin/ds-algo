package com.parvezmrobin.ds;

import com.parvezmrobin.ds.contracts.HeapInterface;

public abstract class Heap implements HeapInterface {

    protected double[] heap;
    protected int heapSize;

    public Heap() {
        this(100);
    }

    public Heap(int initialSize) {
        this.heap = new double[initialSize];
        this.heapSize = 0;
    }

    public Heap(double[] values) {
        this.heap = values;
        this.heapSize = this.heap.length;
        for (int i = 1; i < this.heapSize; i++) {
            heapify(i);
        }
    }

    @Override
    public int parent(int child) {
        return (child - 1) / 2;
    }

    @Override
    public int leftChild(int parent) {
        return 2 * parent + 1;
    }

    @Override
    public int rightChild(int parent) {
        return 2 * parent + 2;
    }

    @Override
    public void push(double value) {
        if (this.heapSize == this.heap.length) {
            this.doubleSize();
        }

        this.heap[this.heapSize] = value;
        this.heapify(this.heapSize);
        this.heapSize++;
    }

    private void doubleSize() {
        int newSize = this.heap.length * 2;
        double[] newHeap = new double[newSize];
        System.arraycopy(this.heap, 0, newHeap, 0, this.heap.length);
        this.heap = newHeap;
    }

    @Override
    public double pop() {
        if (this.heapSize == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        double top = this.heap[0];
        deleteTop();
        this.heapSize--;
        return top;
    }

    @Override
    public double top() {
        if (this.heapSize == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return this.heap[0];
    }

    public double[] getHeap() {
        double[] array = new double[this.heapSize];
        System.arraycopy(this.heap, 0, array, 0, this.heapSize);
        return array;
    }

    protected abstract void heapify(int parent);

    protected abstract void deleteTop();
}
