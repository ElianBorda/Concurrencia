package org.example;

public class DummyTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Corre el dummytask");
    }
}
