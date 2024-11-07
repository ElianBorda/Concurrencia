package org.example;

public class DummyTask extends Task{

    @Override
    public Boolean isTaskTrue(){
        return true;
    }

    @Override
    public void run() {
        System.out.println("Corre el dummytask");
    }
}
