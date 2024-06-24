package com.sri.challenge;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions=new ArrayList<Double>();

    public Customer(String name,double transaction){
        this.name=name;
        transactions.add(transaction);
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Double> getTransactions(){
        return this.transactions;
    }

    public void addTransaction(double transaction){
        this.transactions.add(transaction);
    }
}
