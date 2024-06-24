package com.sri.advanced;

import java.util.ArrayList;
import java.util.Scanner;

//Coding-> Being able to write code as well as think out the problem

		// Number Operaotr Numebr -> 0,1,2
		
		// 9 + 7 -- 10 + 8 -- 9 * 7 -- 7 - 9
		
		/*
		 * String - multiple characters //String
	int -whole numbers //Integer
	char-character //Character
	boolean-true/false //Boolean
	float -decimals //Float
	double-decimals //Double
		 */

public class Calculator {
	
	//Multiple Operations -> Only works for single digit numbers and plus/minus operator
	
	public static void main(String[] args) throws Exception {
		
		Scanner oldScanner = new Scanner(System.in);
		System.out.println("Provide an expression: ");
		String expression = oldScanner.nextLine();
		String[] array = expression.split("");
		ArrayList<String> expression1 = new ArrayList<String>();
		System.out.println("Hi");
		
		for(int i=0;i<array.length;i++) {
			if(array[i].equals(" ")==false) {
				expression1.add(array[i]);
			}//end if statement
		}//end for loop
		if(expression1.size()==3) {
			System.out.println(opr(expression1));
		}else {
			System.out.println(opr1(expression1));
		}
		
		
	}//end main method
	
	//8 * 9 - 10 -> 62
	//90 / 10 * (9+1) -> 90
	// 80 * 90 + (90/80)
	// 8 + 10 -> opr method
	// 8 + 10 + 9 -> opr1 method
	
	
	public static int opr(ArrayList<String> array) throws Exception {
		if(array.get(1).equals("+")) {
			return Integer.parseInt(array.get(0)) + Integer.parseInt(array.get((2)));
		}else if(array.get(1).equals("*")) {
			return Integer.parseInt(array.get(0)) * Integer.parseInt(array.get(2));
		}else if(array.get(1).equals("-")) {
			return Integer.parseInt(array.get(0)) - Integer.parseInt(array.get((2)));
		}else if(array.get(1).equals("%")) {
			return Integer.parseInt(array.get((0))) % Integer.parseInt(array.get((2)));
		}else if(array.get(1).equals("/")) {
			return Integer.parseInt(array.get((0))) / Integer.parseInt(array.get((2)));
		}else {
			throw new Exception("Syntax Error!");
		}//end if else statement
		
	}//end opr method
	
	// 9 + 8 - 7
	
	public static int opr1(ArrayList<String> array) throws Exception{
		int answer=Integer.parseInt(array.get(0));
		boolean value = false;
		for(int i=1;i<array.size();i++) {
			if(i%2==0) {
				int num = Integer.parseInt(array.get(i));
				if(value==false) {
					answer = answer + num;
				}else {
					answer = answer - num;
				}
			}else {
				if(array.get(i).equals("+")) {
					value=false;
				}else if(array.get(i).equals("-")){
					value=true;
				}else {
					throw new Exception("Sytnax Error");
				}//end else statement
			}//end if else
		}//end for loop
		
		return answer;
	}//end method

	
	//Code in java
	//Flip a coin: Randomly pick 0,1
	//If u get 0, that means its tails or false. If u get 1, its heads or true
}//end class
