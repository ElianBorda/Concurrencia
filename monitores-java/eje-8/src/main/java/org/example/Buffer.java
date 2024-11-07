package org.example;

import java.util.ArrayList;

public class Buffer {

    private final ArrayList<Task> buffer;

    private int begin;
    private int end;
    private final int n;

    public Buffer(int dimension){
        this.buffer = new ArrayList<Task>(dimension+1);
        for (int i = 0; i < dimension + 1; i++) {
            this.buffer.add(null);
        }
        this.begin = 0;
        this.end = 0;
        this.n = dimension + 1;
    }

    public synchronized Task get() {
        while (isEmpty()){
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        Task aTask = this.buffer.get(this.end);
        this.end = next(this.end);
        notifyAll();
        return aTask;
    }

    public synchronized void put(Task aTask){
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
