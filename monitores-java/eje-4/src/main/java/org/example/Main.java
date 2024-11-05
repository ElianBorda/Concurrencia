package org.example;

public class Main {
    public static void main(String[] args) {

        Barrera b = new Barrera(4);
        Task t1 = new Task(b, "a", 1);
        Task t2 = new Task(b, "b", 2);
        Task t3 = new Task(b, "c", 3);
        Task t4 = new Task(b, "d", 4);
        Task t5 = new Task(b, "e", 5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}