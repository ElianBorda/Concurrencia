package org.example;

public class PoisonException extends RuntimeException{

    public PoisonException(){
        super("PoisonException was called");
    }

}
