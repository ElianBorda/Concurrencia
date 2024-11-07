package org.example;

public class Main {
    public static void main(String[] args) {
        ThreadPool aThreadPool = new ThreadPool(10, 8);


        for (int i = 0; i < 100; i++) {
            aThreadPool.launch(new DummyTask());
        }


        aThreadPool.stop();
    }
}