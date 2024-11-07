package org.example;

public class Worker extends Thread {
    private final Buffer b;
    private Boolean running = true;

    public Worker(Buffer buffer) {
        this.b = buffer;
    }

    @Override
    public void run() {
        while (running){
            try {
                Runnable aTask = b.get();
                Thread aThread = new Thread(aTask);
                aThread.start();
            } catch (PoisonException e) {
                this.running = false;
                System.out.println(e.getMessage());
            }

        }
    }
}
