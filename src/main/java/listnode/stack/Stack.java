package listnode.stack;

import java.util.EmptyStackException;

public class Stack implements StackADT {
    private int[] stack;
    private int size = 0;
    private int capacity = 10;
    private int currentCapacity = 10;

    public Stack() {
        this.stack = new int[capacity];
    }

    public Stack(int ensureCapacity) {
        this.capacity = ensureCapacity;
        this.currentCapacity = ensureCapacity;
        this.stack = new int[capacity];
    }

    private boolean isFull() {
        return this.currentCapacity == this.size;
    }

    private void extendStack() {
        currentCapacity = currentCapacity + capacity;
        int[] temp = new int[currentCapacity];
        for (int i = 0 ; i < this.size; i++) {
            temp[i] = this.stack[i];
        }
        this.stack = temp;
    }

    @Override
    public void push(int data) {
        if (isFull()) {
            extendStack();
        }
        stack[this.size++] = data;
    }

    @Override
    public int pop() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        return stack[--this.size];
    }

    public int getSize() {
        return size;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }
}

