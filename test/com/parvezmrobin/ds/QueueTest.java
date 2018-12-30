package com.parvezmrobin.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue<Integer> queue;

    @Test
    void testQueue() {
        this.queue = new Queue<>(10);

        int i;
        for (i = 0; i < 500; i++) {
            this.queue.enqueue(i);
        }
        int j;
        for (j = 0; j < 500; j++) {
            assertEquals(j, this.queue.dequeue());
        }
        for (int k = 0; k < 5; k++) {
            assertThrows(IndexOutOfBoundsException.class, () -> this.queue.dequeue());
        }

        this.queue = new Queue<>(10);

        for (i = 0; i < 100; i++, j++) {
            this.queue.enqueue(j);
            assertEquals(j, this.queue.dequeue());
        }
        for (int k = 0; k < 5; k++) {
            assertThrows(IndexOutOfBoundsException.class, () -> this.queue.dequeue());
        }
    }
}