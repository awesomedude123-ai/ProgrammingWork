package com.sri.course;

import java.util.*;

public class Scanner1 {
	
	public static void main(String[] args) {
		
		//Converted double to int -> Conversion (Type Casting)
		//Data Types -> System.out.println();
		
		//Concatination -> put together
		
		//Instantiation -> Making an object of a class
		
		Scanner oldScanner = new Scanner(System.in);
		
		Tv srisTv = new Tv("name", "resoluted", "pixelated", "10/20");
		
		
		
		/*
		 * 
		 * String name = oldScanner.next();
		
		System.out.print("Hi");
		System.out.println("Hi");
		 * 
		 * 
		 */
		
		String name = oldScanner.nextLine();
		int y = oldScanner.nextInt();
		double num = oldScanner.nextDouble();
		float i = oldScanner.nextFloat();
		boolean value = oldScanner.nextBoolean();
		
		System.out.println("Number");
		int x = oldScanner.nextInt();
		System.out.println("Word");
		String name1 = oldScanner.next();
		
		System.out.println(x + " " + name1);
		
		
		//Input all three numbers(int, double, float) -> Sum-Difference, Product/Quotient
		
		//Input a string -> Get the character at indices 2,4,6
		
		
		
		
		
	}//end main method

}//end public class
