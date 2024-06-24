package com.sri.abstraction;

public class Penguin extends Bird{

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("I'm not very good at flying, can I swim instead?");
    }
}
