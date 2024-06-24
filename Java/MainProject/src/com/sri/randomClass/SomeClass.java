package com.sri.randomClass;

import java.util.Scanner;

public class SomeClass {
    public static void main(String[] args) {
        OtherClass oc=new OtherClass();
        OtherClass oc1=new OtherClass();
        System.out.println(oc.getX());
        System.out.println(oc1.getX());
        System.out.println(2^3);
        //^--> it conducts a binary exclusive or logical operator on both the numbers and produces a binary sequence which is converted into a number

        try(Scanner oldScanner=new Scanner(System.in)){
            System.out.println("Hello");
        }catch(Exception e){
            System.out.println("Here");
        }
        finally{
            System.out.println("Here");
        }
    }
}

class OtherClass{
    private final int x;
    private static int countNum=0;

    public OtherClass(){
        countNum++;
        x=countNum;
    }

    public int getX() {
        return x;
    }
    public void print(){
        System.out.println("Final x: " + this.x);
    }
}
