package com.sri.challenge;

public class HealthyBurger extends Hamburger{
    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price){
        super("Healthy Burger",meat,price,"Brown rye Roll");
    }

    public void addHealthyAddition1(String name, double price){
        healthyExtra1Name=name;
        healthyExtra1Price=price;
    }
    public void addHealthyAddition2(String name, double price){
        healthyExtra2Name=name;
        healthyExtra2Price=price;
    }

    @Override
    public double itemizehamburger() {
        return super.itemizehamburger()+this.healthyExtra2Price+this.healthyExtra1Price;
    }
}
