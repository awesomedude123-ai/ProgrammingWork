package com.sriwork;

public class Main2 {

    public static void main(String[] args){

        float myMinFloatValue=Float.MIN_VALUE;
        float myMaxFloatValue=Float.MAX_VALUE;
        System.out.println(myMinFloatValue);
        System.out.println(myMaxFloatValue);

        double myMinDoubleValue=Double.MIN_VALUE;
        double myMaxDoubleValue=Double.MAX_VALUE;
        System.out.println(myMinDoubleValue);
        System.out.println(myMaxDoubleValue);

        int a=5/3;
        float b=5f/3f,d=(float)5.25;
        double c=5d/3d,e=5.25;
        System.out.println(a);
        System.out.println(b+" "+d);
        System.out.println(c+" "+e);

    }

}
