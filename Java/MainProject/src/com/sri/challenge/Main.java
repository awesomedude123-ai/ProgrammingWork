package com.sri.challenge;

public class Main {
    public static void main(String[] args) {
        /*
                Contact ajay=new Contact("Ajay","2235569980");
        Contact pranay=new Contact("Pranay","3342567891");
        Contact bala=new Contact("Bala","9889076456");
        MobilePhone mp=new MobilePhone("1234567890");
        mp.addNewContact(ajay);
        mp.addNewContact(pranay);
        mp.addNewContact(bala);
        mp.printContacts();
        mp.updateContact(pranay,new Contact("Dhruv","1232234536"));
        mp.updateContact(new Contact("Anirudh","1234567890 "),pranay);
        mp.printContacts();
        mp.queryContact("Bala");
        mp.removeContact(ajay);
        mp.printContacts();
         */

        Customer sri=new Customer("Sri",90.19);
        Branch my=new Branch("my");
        my.newCustomer(sri.getName(),90.19);
        boolean c=my.newCustomer("john",91.19);
        System.out.println(c);

        Bank b=new Bank("b");
        b.addBranch(my.getName());
        boolean t=b.addCustomer("my","shri",80.15);
        System.out.println(t);

    }
}
