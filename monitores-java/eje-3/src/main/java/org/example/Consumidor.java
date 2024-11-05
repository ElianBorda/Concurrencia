package org.example;

public class Consumidor extends Thread{

    private final Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int n = 0;
        while (true) {
            buffer.put(n);
            n++;
        }
    }
}
