package org.example;

import java.util.ArrayList;

public class ThreadPool {

    private final Buffer buffer;
    private final ArrayList<Worker> workers;
    private final int amountWorkers;

    public ThreadPool(int amountWorkers, int amountTask){
        Buffer aBuffer = new Buffer(amountTask, this);
        this.buffer = assignTask(aBuffer, amountTask);
        this.workers = createWorkers(amountWorkers);
        this.amountWorkers = amountWorkers;
    }


    public synchronized void launch() {
        for (Worker worker: this.workers) {
            worker.start();
        }
    }

    public synchronized void stop(){
        for (int i = 0; i < this.amountWorkers; i++) {
            this.buffer.put(new PoisonPill());
        }
        notifyAll();
        System.out.println("se notifico");
    }

    public int getAmountWorkers() {
        return amountWorkers;
    }

    private ArrayList<Worker> createWorkers(int amountWorkers) {
        ArrayList<Worker> someWorkers = new ArrayList<>();
        for (int i = 0; i < amountWorkers; i++) {
            someWorkers.add(new Worker(this.buffer));
        }

        return someWorkers;
    }

    private Buffer assignTask(Buffer aBuffer, int amountTask) {
        for (int i = 0; i < amountTask; i++) {
            aBuffer.put(new DummyTask());
        }

        return aBuffer;
    }


}
