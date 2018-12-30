package com.parvezmrobin.ds;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {
    Heap heap;

    @BeforeEach
    void setup(){
        this.heap = new MaxHeap(10);
    }

    @Test
    void parent() {
        assertEquals(0, heap.parent(2));
        assertEquals(1, heap.parent(3));
        assertEquals(1, heap.parent(4));
        assertEquals(2, heap.parent(5));
    }

    @Test
    void leftChild() {
        assertEquals(1, heap.leftChild(0));
        assertEquals(3, heap.leftChild(1));
        assertEquals(5, heap.leftChild(2));
    }

    @Test
    void rightChild() {
        assertEquals(2, heap.rightChild(0));
        assertEquals(4, heap.rightChild(1));
        assertEquals(6, heap.rightChild(2));
    }

    @Test
    void pushPop() {
        for (int i = 0; i < 5; i++) {
            heap.push(i);
        }
        double prev = Double.POSITIVE_INFINITY;
        for (int i = 0; i < 5; i++) {
            double curr = heap.pop();
            assertTrue(prev > curr);
            assertEquals(4-i, curr);
        }

        for (int k = 0; k < 5; k++) {
            assertThrows(IndexOutOfBoundsException.class, () -> heap.pop());
        }

        assertArrayEquals(new double[]{}, heap.getHeap());

        for (int i = 0; i < 10; i++) {
            heap.push(i);
        }

        assertArrayEquals(new double[]{9, 8, 5, 6, 7, 1, 4, 0, 3, 2}, heap.getHeap());
    }

}