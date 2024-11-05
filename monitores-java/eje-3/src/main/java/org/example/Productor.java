package org.example;

public class Productor extends Thread{

    private final Buffer buffer;

    public Productor(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(buffer.get());
        }
    }
}
