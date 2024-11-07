package org.example;

import java.util.ArrayList;

public class ThreadPool {

    private final Buffer buffer;
    private final ArrayList<Worker> workers;
    private final int amountWorkers;

    public ThreadPool(int dimension, int amountWorkers){
        this.buffer = new Buffer(dimension);
        this.workers = createWorkers(amountWorkers);
        this.amountWorkers = amountWorkers;
        this.runWorkers();
    }

    private void runWorkers() {
        for (Worker aWorker : this.workers) {
            aWorker.start();
        }
    }

    public synchronized void launch(Task aTask) {
        this.buffer.put(aTask);
    }

    public synchronized void stop(){
        for (Worker aWorker : this.workers) {
            this.buffer.put(new PoisonPill());
        }
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


}
