package com.sri.inheritance;

public class Main {
    public static void main(String[] args) {
        Car bmw=new Car();
        Car jeep=new Car();

        Dog d=new Dog(4, 20, "My friend",2, 4,1, 40, "Brown");

        d.eat();

        System.out.println(bmw.getModel());
        bmw.setModel("Lambo");
        System.out.println(bmw.getModel());
        bmw.setModel("Bmw");
        System.out.println(bmw.getModel());


    }
}