package org.example;

public class Buffer {

    private final int[] buffer;
    private final int n;
    private int begin;
    private int end;

    public Buffer(int dimension) {
        this.buffer = new int[dimension+1];
        this.n = dimension;
        this.end = 0;
        this.begin = 0;
    }

    public synchronized void put(int value) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException ignored) {}

        }
        buffer[begin] = value;
        begin = next(begin);
        notifyAll();
    }

    public synchronized int get() {
        while(isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        int result = buffer[end];
        end = next(end);
        notifyAll();
        return result;
    }

    private boolean isEmpty() {
        return end == begin;
    }


    private boolean isFull() {
        return next(begin) == end;
    }

    private int next(int i) {
        return (i+1)%(n+1);
    }



}
