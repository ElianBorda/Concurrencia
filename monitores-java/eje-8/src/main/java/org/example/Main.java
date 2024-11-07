package org.example;

public class Main {
    public static void main(String[] args) {
        ThreadPool aThreadPool = new ThreadPool(8, 100);
        aThreadPool.launch();
    }
}