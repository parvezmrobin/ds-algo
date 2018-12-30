package com.parvezmrobin.ds.contracts;

public interface HeapInterface {
    int parent(int child);

    int leftChild(int parent);

    int rightChild(int parent);

    void push(double value);

    double pop();
}
