package org.example;

public class Main {
    public static void main(String[] args) {

        Buffer b = new Buffer(2);
        Consumidor c = new Consumidor(b);
        Productor p = new Productor(b);

        c.start();
        p.start();

    }
}