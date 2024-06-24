package com.sri.challenge;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts=new ArrayList<Contact>();

    public MobilePhone(String myNumber){
        this.myNumber=myNumber;
        myContacts.add(new Contact("Me",this.myNumber));
    }

    public boolean addNewContact(Contact contact){
        if(myContacts.contains(contact)){
            return false;
        }else{
            myContacts.add(contact);return true;
        }
    }

    public boolean updateContact(Contact old, Contact new1){
        if(myContacts.contains(old)){
            myContacts.set(myContacts.indexOf(old),new1);return true;
        }else{
            return false;
        }
    }

    public boolean removeContact(Contact contact){
        if(myContacts.contains(contact)){
            myContacts.remove(myContacts.indexOf(contact));return true;
        }else{
            return false;
        }
    }

    private int findContact(Contact contact){
        if(myContacts.contains(contact)){
            return myContacts.indexOf(contact);
        }else{
            return -1;
        }
    }

    private int findContact(String name){
        for(int i=0;i<myContacts.size();i++){
            if(myContacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name){
        Contact l=null;
        for(int i=0;i<myContacts.size();i++){
            if(myContacts.get(i).getName().equals(name)){
                l=myContacts.get(i);
            }
        }
        return l;
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for(int i=0;i<myContacts.size();i++){
            System.out.println((i+1)+". "+myContacts.get(i).getName()+" -> "+myContacts.get(i).getPhoneNumber());
        }
    }

}