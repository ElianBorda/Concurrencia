package org.example;

public class Task extends Thread{

    private final Barrera miBarrera;
    private final String s;
    private final int n;

    public Task(Barrera b, String s, int n){
        this.miBarrera = b;
        this.s = s;
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println(s);
        miBarrera.esperar();
        System.out.println(n);
    }
}
