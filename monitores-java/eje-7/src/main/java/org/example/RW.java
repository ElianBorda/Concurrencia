package org.example;

import java.io.Serializable;

public class RW {

    String dato;

    public synchronized String beginRead(){
        return "todo";
    }

    public synchronized String endRead(){
        return "todo";
    }

    public synchronized void beginWrite(){

    }

    public synchronized void endWrite(){

    }

}
