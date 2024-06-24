package com.sri.challenge;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers=new ArrayList<Customer>();

    public Branch(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }

    public boolean newCustomer(String name, double transaction){
        if(transaction<0){
            return false;
        }
        customers.add(new Customer(name,transaction));
        return true;
    }

    public boolean addCustomerTransaction(String name, double transaction){
        for(int i=0;i< customers.size();i++){
            if(customers.get(i).getName().equals(name)){
                customers.get(i).getTransactions().add(transaction);return true;
            }
        }//end for loop
        return false;
    }

    private Customer findCustomer(String name){
        for(int i=0;i< customers.size();i++){
            if(customers.get(i).getName().equals(name)){
                return customers.get(i);
            }
        }//end for loop
        return null;
    }
}
