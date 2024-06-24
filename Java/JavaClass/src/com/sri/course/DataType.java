package com.sri.course;

public class DataType {
	
	public static void main(String[] args) {
		//Data Types
		
		/**
		 * String -> "Words" "" -> null
		char -> 'a' '' -> \\u 000
		int -> 9,10,-11 -> 0
		boolean -> true. false -> false
		double -> decimals , 9.09,-8.07 -> 0.0
		float ->  decimals, 8.08f , 9.76f , -9.0f -> 0.0f
		 */
		
		//Default Values -> Values that are stored in place if a variable is not given a value -> SOME VERSION OF NONE -> Temporary Values
		
		//Make Two variables, Print out the result of each math operation (*,/,+,-,%) -> Calculator
		//String Concatination 3-4 Add those strings together and then print them.  
		//Boolean print the boolean value
		//
		
		
		String name = "Surya";
		String name1 = "Varshini";
		String name2 = "Anvika";
		
		char a = 'a';
		
		String name3 = name + name1 + name2 + a; //String concatination
		
		boolean value = false;
		
		double y = 29.1;
		
		float f = 9;
		
		int x = 10;
		
		System.out.println(f + x);
		
		System.out.println("Printing all four operations for " + y + " and " + x);
		
		System.out.println(x/y);
		System.out.println(x*y);
		System.out.println(x-y);
		System.out.println(x+y);
		System.out.println(name3 + " " + value);
		
		
	}//end main method

}//end public class
