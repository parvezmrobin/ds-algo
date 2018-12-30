package com.parvezmrobin.ds;

public class Stack<T> {
    private Object[] stack;
    private int front;

    Stack() {
        this(100);
    }

    Stack(int size){
        this.stack = new Object[size];
        this.front = 0;
    }

    public void push(T value){
        if (this.front == this.stack.length){
            this.doubleSize();
        }
        this.stack[front++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        if (this.front == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        Object value = this.stack[--front];
        return (T) value;
    }

    private void doubleSize() {
        int newSize = this.stack.length * 2;
        Object[] newStack = new Object[newSize];
        System.arraycopy(this.stack, 0, newStack, 0, this.stack.length);
        this.stack = newStack;
    }
}
