package com.sri.inheritance;

public class Account {
    private String number;
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;
    private double balance;

    public Account(){
        System.out.println("Hi");
    }
    public Account(String number,double balance, String custmerName, String customerEmailAddress,String customerPhoneNumber){
        this();//calls the other constructor that prints hi. Needs to be the first statement in the constructor body.
        this.number=number;
        this.balance=balance;
        this.customerName=custmerName;
        this.customerEmailAddress=customerEmailAddress;
        this.customerPhoneNumber=customerPhoneNumber;

    }//end constructor

    public Account(String customerName, String customerEmailAddress, String customerPhoneNumber) {
        this("99999",100.55,customerName,customerEmailAddress,customerPhoneNumber);
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailAddress() {
        return this.customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPhoneNumber() {
        return this.customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double deposit){
        this.balance+=deposit;
        System.out.println("New Balance: "+this.balance);
    }
    public void withdrawal(double withdrawal){
        if(withdrawal>this.balance){
            System.out.println("This amount cannot be taken out of the account as you do not have enough money");
        }else{
            this.balance-=withdrawal;
            System.out.println("Balance remaining: "+this.balance);
        }
    }

}
