package com.sri.inheritance;

public class Bank1 {
    public static void main(String[] args) {
        Account sri=new Account("12394",908.89,"Sri Mukkamala","hi@gmail.com","1234567890");

        sri.getCustomerEmailAddress();
        sri.getCustomerName();
        sri.getCustomerPhoneNumber();
        System.out.println(sri.getBalance());
        System.out.println(sri.getCustomerEmailAddress());

        Account tim=new Account("Tim Milich","tim@gmail.com","12345678");
        System.out.println(tim.getBalance()+" "+tim.getCustomerEmailAddress()+" "+tim.getNumber());



        VipPerson sri1=new VipPerson("Sri",90000,"srimu2004@gmail.com");
        System.out.println(sri1.getEmailAddress()+" "+sri1.getName()+" "+ sri1.getCreditLimit());
    }
}
