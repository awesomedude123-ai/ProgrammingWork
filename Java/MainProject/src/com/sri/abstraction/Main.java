package com.sri.abstraction;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Miley");
        dog.breath();
        dog.eat();
        dog.getName();
        System.out.println();
        Parrot parrot=new Parrot("Austin");
        parrot.breath();
        parrot.eat();
        parrot.fly();
        System.out.println();

        Penguin penguin=new Penguin("emperor");
        penguin.breath();
        penguin.eat();
        penguin.fly();
    }
}
