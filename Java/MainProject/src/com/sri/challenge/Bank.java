package com.sri.challenge;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches=new ArrayList<Branch>();

    public Bank(String name){
        this.name=name;
    }

    public boolean addBranch(String name){
        for(int i=0;i<branches.size();i++){
            if(branches.get(i).getName().equals(name)){
                return false;
            }
        }
        branches.add(new Branch(name));return true;
    }

    public boolean addCustomer(String nameOfBranch,String nameOfCustomer,double transaction){
        for(int i=0;i<branches.size();i++){
            if(branches.get(i).getName().equals(nameOfBranch)) {
                return branches.get(branches.indexOf(nameOfBranch)).newCustomer(nameOfCustomer, transaction);
            }
        }
        return false;
    }
    public boolean addCustomerTransaction(String nameOfBranch,String nameOfCustomer,double transaction){
        if(branches.contains(new Branch(nameOfBranch))){
            return branches.get(branches.indexOf(nameOfBranch)).addCustomerTransaction(nameOfCustomer,transaction);
        }else{
            return false;
        }
    }

    private Branch findBranch(String name){
        if(branches.contains(new Branch(name))){
            return branches.get(branches.indexOf(new Branch(name)));
        }else{
            return null;
        }
    }

    public boolean listCustomers(String branchName, boolean printTransactions){
        if(branches.contains(new Branch(branchName))){
            System.out.println("Customer details for branch "+branchName);
            ArrayList<Customer> list=branches.get(branches.indexOf(new Branch(branchName))).getCustomers();
            if(printTransactions==false){
                for(int i=0;i<list.size();i++){
                    System.out.println("Customer: "+list.get(i).getName()+"["+(i+1)+"]");
                }//end big for loop
            }else{
                for(int i=0;i<list.size();i++){
                    System.out.println("Customer: "+list.get(i).getName()+"["+(i+1)+"]");
                    ArrayList<Double> allTransactions=list.get(i).getTransactions();
                    for(int x=0;x<allTransactions.size();x++){
                        System.out.println("["+(x+1)+"]  Amount "+allTransactions.get(x));
                    }//end small for loop
                }//end big for loop
            }//end if else statemnt
            return true;
        }else{
            return false;
        }
    }

}
