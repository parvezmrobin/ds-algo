package com.parvezmrobin.ds;

public class Queue<T> {
    private Object[] queue;
    private int front, back;

    /**
     * @param size default size of the initial underlying array
     */
    public Queue(int size) {
        this.queue = new Object[size];
        this.front = 0;
        this.back = 0;
    }

    public Queue() {
        this(100);
    }

    public void enqueue(T val) {
        this.front %= this.queue.length;

        if ((this.front + 1) % this.queue.length == this.back) {
//            if the queue is full
            this.doubleSize();
        }

        this.queue[front] = val;
        this.front++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        this.back %= this.queue.length;
        if (this.back == this.front % this.queue.length) {
            throw new IndexOutOfBoundsException("Queue is empty.");
        }

        return (T) this.queue[back++];
    }

    private void doubleSize() {
        int newSize = this.queue.length * 2;
        Object[] newQueue = new Object[newSize];
        System.arraycopy(this.queue, 0, newQueue, 0, this.queue.length);
        this.queue = newQueue;
    }

    public boolean isEmpty(){
        return this.back % this.queue.length == this.front % this.queue.length;
    }
}
