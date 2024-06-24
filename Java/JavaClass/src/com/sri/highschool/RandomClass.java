package com.sri.highschool;

import java.util.Random;
import java.util.Scanner;

public class RandomClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Scanner oldScanner = new Scanner(System.in);
		int x = oldScanner.nextInt();
		double y = oldScanner.nextDouble();
		oldScanner.nextLine();
		String n = oldScanner.nextLine();
		float u = oldScanner.nextFloat();
		char i = oldScanner.next().charAt(0);
		boolean o = oldScanner.nextBoolean();
		
		System.out.println(x + " " + y + " " + n + " " + u + " " + i + " " + o);
		 */
		Scanner oldScanner = new Scanner(System.in);
		Random r1 = new Random();
		System.out.println(r1.nextInt(2));
		System.out.println(Math.random());
		
		
		int min1 = 5;
		int max1 = 25;
		double answer= Math.random()*(max1 - min1 + 1) + min1;
		System.out.println(answer);
		
		
		int min = 1;
		int max = 100;
		double p = Math.random()*(max-min+1)+min;
		double d = Math.floor(p);
		int o1 = (int) d;
		System.out.println(o1);
		System.out.println(d);
		System.out.println(p);
		
		System.out.println(min+=2);
		
		//Math random 0,1 with 1 non inclusive
		
		//Scanner -> reads your input -> whether it be int, String, double ... 
		//Random Class -> Generates random numbers
		//Math Class -> 
		//Class Work -> 
		//Home Work -> 1. Make a program that randomly picks two numbers, prints both numbers
		//2. Take in an input and form random numbers based on input
		//3. 


	}//end main method

}//end public class
