package com.sriwork;

import java.util.Scanner;

public class Operators {

    public static void main(String[] args) {
        int result = 1 + 2 * 9 + 10;//does order of operations
        System.out.println(result);
        boolean y = false;
        if (y == false)
            System.out.println("this statement is true");
        System.out.println("here");
        result = 10;
        System.out.println(result);
        boolean t = false;
        if (!t) {
            System.out.println(!t);
        }

        int h = 10;
        String j = (h == 30) ? "cool" : "here";
        System.out.println(j);

        String u = (h >= 20) ? "It is greater than 20" : "It is less than 20";
        System.out.println(u);

        double a = 20.0;
        double i = 80.0;
        i = (i + a) * 100.0;
        boolean value = (i % 40.0 == 0) ? true : false;
        System.out.println(value);
        if (!value)//!value refers to the opposite value. so if 'value' is true, !value if false. then, it is automatically compared to true so if !value==true, it runs the if statement body.
            System.out.println("Got some remainder");

        boolean v = false;
        if(!v){ // always set to true --> works for boolean variables only
            System.out.println(v+" here");
        }

        Scanner oldScanner = new Scanner(System.in);
        String q = oldScanner.nextLine();
        int x = oldScanner.nextInt();
        int z = oldScanner.nextInt();
        System.out.println(Integer.toString(Integer.parseInt(q, x), z));//Converts input to base 10 format from the base it is currently in. From there, it converts to the base format user wishes the output to be in.


    }

}
