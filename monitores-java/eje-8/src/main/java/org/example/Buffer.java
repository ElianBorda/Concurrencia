package org.example;

import java.util.ArrayList;

public class Buffer {

    private final ArrayList<Runnable> buffer;
    private final ThreadPool t;
    private int waiting;
    private int begin;
    private int end;
    private final int n;

    public Buffer(int dimension, ThreadPool threadPool){
        this.buffer = new ArrayList<Runnable>(dimension+1);
        for (int i = 0; i < dimension + 1; i++) {
            this.buffer.add(null);
        }
        this.t = threadPool;
        this.waiting = 0;
        this.begin = 0;
        this.end = 0;
        this.n = dimension + 1;
    }

    public synchronized Runnable get() {
        while (isEmpty()){
            this.waiting++;
            if (this.waiting == t.getAmountWorkers()){
                t.stop();
            }
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        Runnable aTask = this.buffer.get(this.end);
        this.end = next(this.end);
        notifyAll();
        return aTask;
    }

    public synchronized void put(Runnable aTask){
        while(isFull()){
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        this.buffer.set(this.begin, aTask);
        this.begin = next(this.begin);
        notifyAll();
    }

    public Boolean isEmpty(){
        return this.end == this.begin;
    }

    public int next(int number){
        return (number+1)%this.n;
    }

    public Boolean isFull() {
        return next(this.begin) == this.end;
    }

}