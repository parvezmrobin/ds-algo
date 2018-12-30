package com.parvezmrobin.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack<Integer> stack;

    @Test
    void testQueue() {
        this.stack = new Stack<>(10);

        int i;
        for (i = 0; i < 500; i++) {
            this.stack.push(i);
        }
        int j;
        for (j = 500; j > 0; j--) {
            assertEquals(j - 1, this.stack.pop());
        }
        for (int k = 0; k < 5; k++) {
            assertThrows(IndexOutOfBoundsException.class, () -> this.stack.pop());
        }

        this.stack = new Stack<>(10);

        for (i = 0; i < 100; i++, j++) {
            this.stack.push(j);
            assertEquals(j, this.stack.pop());
        }
        for (int k = 0; k < 5; k++) {
            assertThrows(IndexOutOfBoundsException.class, () -> this.stack.pop());
        }
    }
}