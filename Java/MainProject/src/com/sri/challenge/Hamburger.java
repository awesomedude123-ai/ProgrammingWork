package com.sri.challenge;

public class Hamburger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    public Hamburger(String name, String meat, double price, String breadRollType){
        this.name=name;
        this.meat=meat;
        this.price=price;
        this.breadRollType=breadRollType;
    }

    private String addition1Name;
    private String addition2Name;
    private String addition3Name;
    private String addition4Name;
    private double addition1Price;
    private double addition2Price;
    private double addition3Price;
    private double addition4Price;

    public void addHamburgerAddition1(String name,double price){
        addition1Price=price;
        addition1Name=name;
        System.out.println("Added "+name+" for an extra "+ price);
    }
    public void addHamburgerAddition2(String name,double price){
        addition2Price=price;
        addition2Name=name;
        System.out.println("Added "+name+" for an extra "+ price);
    }
    public void addHamburgerAddition3(String name,double price){
        addition3Price=price;
        addition3Name=name;
        System.out.println("Added "+name+" for an extra "+ price);
    }
    public void addHamburgerAddition4(String name,double price){
        addition4Price=price;
        addition4Name=name;
        System.out.println("Added "+name+" for an extra "+ price);
    }

    public double itemizehamburger(){
        return this.price+this.addition1Price+this.addition2Price+this.addition3Price+this.addition4Price;
    }
}