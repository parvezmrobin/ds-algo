package com.parvezmrobin.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    Heap heap = new MaxHeap(10);

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
    void maxHeap() {
        for (int i = 0; i < 500; i++) {
            heap.push(i);
        }
        double prev = Double.POSITIVE_INFINITY;
        for (int i = 0; i < 500; i++) {
            double curr = heap.top();
            assertEquals(curr, heap.pop());
            assertTrue(prev > curr);
            assertEquals(499 - i, curr);
        }

        for (int k = 0; k < 5; k++) {
            assertThrows(IndexOutOfBoundsException.class, () -> heap.pop());
            assertThrows(IndexOutOfBoundsException.class, () -> heap.top());
        }

        assertArrayEquals(new double[]{}, heap.getHeap());
    }

    @Test
    void maxHeap2() {
        this.heap = new MaxHeap();
        for (int i = 10; i > 0; i--) {
            heap.push(i);
        }
        assertArrayEquals(new double[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, heap.getHeap());
    }

    @Test
    void maxHeap1() {
        this.heap = new MaxHeap();
        assertArrayEquals(new double[]{}, heap.getHeap());

        for (int i = 0; i < 10; i++) {
            heap.push(i);
        }
        assertArrayEquals(new double[]{9, 8, 5, 6, 7, 1, 4, 0, 3, 2}, heap.getHeap());
    }

    @Test
    void minHeap() {
        this.heap = new MinHeap(10);
        for (int i = 0; i < 500; i++) {
            heap.push(i);
        }
        double prev = Double.POSITIVE_INFINITY;
        for (int i = 0; i < 500; i++) {
            double curr = heap.top();
            assertEquals(curr, heap.pop());
            assertTrue(prev > curr);
            assertEquals(i, curr);
        }

        for (int k = 0; k < 5; k++) {
            assertThrows(IndexOutOfBoundsException.class, () -> heap.pop());
            assertThrows(IndexOutOfBoundsException.class, () -> heap.top());
        }

        assertArrayEquals(new double[]{}, heap.getHeap());
    }

    @Test
    void minHeap2() {
        this.heap = new MinHeap();
        for (int i = 10; i > 0; i--) {
            heap.push(i);
        }
        assertArrayEquals(new double[]{1, 2, 5, 4, 3, 9, 6, 10, 7, 8}, heap.getHeap());
    }

    @Test
    void minHeap1() {
        this.heap = new MinHeap();
        assertArrayEquals(new double[]{}, heap.getHeap());

        for (int i = 0; i < 10; i++) {
            heap.push(i);
        }
        assertArrayEquals(new double[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, heap.getHeap());
    }
}