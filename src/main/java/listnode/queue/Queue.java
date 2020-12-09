package listnode.queue;

import java.util.EmptyStackException;

public class Queue implements QueueADT {

    private int[] queue;
    private int size = 0;
    private int capacity = 10;
    private int currentCapacity = 10;

    public Queue() {
        this.queue = new int[capacity];
    }

    public Queue(int ensureCapacity) {
        this.capacity = ensureCapacity;
        this.currentCapacity = ensureCapacity;
        this.queue = new int[capacity];
    }


    private boolean isFull() {
        return this.currentCapacity == this.size;
    }

    private void extendQueue() {
        currentCapacity = currentCapacity + capacity;
        int[] temp = new int[currentCapacity];
        for (int i = 0 ; i < this.size; i++) {
            temp[i] = this.queue[i];
        }
        this.queue = temp;
    }


    public int getCurrentCapacity() {
        return currentCapacity;
    }

    @Override
    public void add(int data) {
        if (isFull()) {
            extendQueue();
        }
        queue[this.size++] = data;
    }

    @Override
    public Integer peek() {
        if (empty()) return null;
        return queue[0];
    }

    @Override
    public Integer poll() {
        if (empty()) return null;
        int ret = queue[0];
        for (int i = 1; i < this.size; i++) {
            queue[i-1] = queue[i];
        }
        this.size--;
        return ret;
    }

    @Override
    public boolean empty() {
        return this.size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
