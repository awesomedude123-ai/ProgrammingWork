package com.sri.advanced;

import java.util.*;

public class FirstClass {
	
	//Input a number. 6
	// Output the sum and the answer to the 2nd exponenet
	
	//Oput 12 and 36
	
	//7+9-10 -> 6
	
	//Ask the User an operation(A,S,M,D,R)-> Take the input of the numbers and then provide the answer
	
	//9 + 7 -> S

	public static void main(String[] args) throws Exception {
		Scanner oldScanner = new Scanner(System.in);
		
		/**
		 * System.out.println("Enter a number");
		int x = oldScanner.nextInt();
		System.out.println("Enter second number");
		int y = oldScanner.nextInt();
		
		System.out.println("Addition: " + (x+y));
		System.out.println("Subtraction: " + (x-y));
		System.out.println("Multiplciation: " + (x*y));
		System.out.println("Divison: " + (x/y));
		System.out.println("Remainder: " + (x%y));
		
		System.out.println("Enter an expression");
		String 
		 */
		
		System.out.println("Enter a number");
		int num1 = oldScanner.nextInt();
		
		System.out.println("Enter an expression");
		String exp = oldScanner.next();
		
		System.out.println("Enter a number");
		int num2 = oldScanner.nextInt();
		
		System.out.println(calc(num1,exp,num2));
		
		

	}//end main method
	
	public static int calc(int num,String exp, int num2) throws Exception {
		if(exp.equals("*")) {
			return num*num2;
		}else if(exp.equals("-")) {
			return num-num2;
		}else if(exp.equals("%")) {
			return num%num2;
		}else if(exp.equals("/")) {
			return num/num2;
		}else if(exp.equals("+")){
			return num+num2;
		}else {
			throw new Exception("The operator you entered is not an operator"); 
		}
		
	}//end calc method
	

}//public class
