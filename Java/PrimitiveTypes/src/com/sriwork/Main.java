package com.sriwork;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int myValue=10000;
        int myMinIntValue=Integer.MIN_VALUE;
        int myMaxIntValue=Integer.MAX_VALUE;
        System.out.println("Integer Minimum Value = "+myMinIntValue);
        System.out.println("Intgeer Maximum Value = "+myMaxIntValue);
        int myMaxIntTest=2_147;
        System.out.println(myMaxIntTest);

        byte myMinByteValue=Byte.MIN_VALUE;
        byte myMaxByteValue=Byte.MAX_VALUE;
        System.out.println(myMinByteValue);
        System.out.println(myMaxByteValue);

        short myMinShortValue=Short.MIN_VALUE;
        short myMaxShortValue=Short.MAX_VALUE;
        System.out.println(myMinShortValue);
        System.out.println(myMaxShortValue);

        long myMinLongValue=Long.MIN_VALUE;
        long myMaxLongValue=Long.MAX_VALUE;
        System.out.println(myMinLongValue);
        System.out.println(myMaxLongValue);
        long bigIntegerValue=2_123_456_908;
        System.out.println(bigIntegerValue);

        short value=20000;//Automatically casts the integer value to specified data type and provides error notice if the number is too small or big.


        //Challenge
        byte a=100;
        short c=20000;
        int y=1000000;
        long v=(long) (50000+ 10*(a+c+y));
        System.out.println(v);
    }
}