package com.sri.abstraction;

public abstract class Bird extends Animal implements CanFly{

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName()+" is picking");
    }

    @Override
    public void breath() {
        System.out.println("Breathe in and Breathe out. Repeat!");
    }

    @Override
    public void fly(){
        System.out.println("Flying from branch to branch");
    }
}
