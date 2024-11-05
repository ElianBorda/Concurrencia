package org.example;

public class Barrera {

    private final int inicial;
    private int cupo;
    private int esperando;

    public Barrera(int cupo){
        this.cupo = cupo;
        this.inicial = cupo;
        this.esperando = 0;
    }

    public synchronized void esperar() {
        cupo--;
        while (cupo > 0) {
            esperando++;
            try {
                wait();
            } catch (InterruptedException ignore) {}
        }
        notify();
    /*    while (esperando == inicial-1) {
            esperando++;
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }*/


    }

}
