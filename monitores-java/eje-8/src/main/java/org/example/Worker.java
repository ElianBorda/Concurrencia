package org.example;

public class Worker extends Thread {
    private final Buffer b;
    public Worker(Buffer buffer) {
        this.b = buffer;
    }

    @Override
    public void run() {
        try {
            while (true){
                    Task aTask = b.get();
                    if (aTask.isTaskTrue()){
                        Thread aThread = new Thread(aTask);
                        aThread.start();
                    } else {
                        aTask.run();
                    }
            }
        } catch (PoisonException ignored) {}
    }

}

