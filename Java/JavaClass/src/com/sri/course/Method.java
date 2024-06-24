package com.sri.course;

import java.util.*;

public class Method {

	//Main method
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * public-Access Modifier -> Identifies who has access -> Public, Private, Protected, Final
		 * static -> Prioritizes what goes first
		 * void -> Return Type -> Data Type -> int String float double char boolean 
		 * main -> name of the method -> firstWord
		 * (String[] args) -> parameters -> () -> (int x)
		 * {Body of the method}
		 */
		
		//Random Class-Generates a random Number, random boolean-> generates a random value
		//Method-Method Signature -> Signature -> Full Name, unique
		//control Structure- Tomorrow
		//Home Work-Scanner-> get 2 inputs -> add, subtract, divide, multiply, and find the remainder -> %
		//Use the method referencing
		//Create two classes -> Main method -> main1 -> use one of the methods in the other
		//
		
		
		float answer = add(1.9f, 2.9f);
		System.out.println(add(1.9f, 2.9f));
		Scanner oldScanner = new Scanner(System.in);
		Method1 method1 = new Method1();
		
		System.out.println(Method1.divide(9.5f, 0.5f));
		System.out.println(method1.subtract(9.5f, 0.5f));
		
		main1(10,9.5, method1);
		int x = oldScanner.nextInt();
		int y = oldScanner.nextInt();
		int remainder = remainder(x , y);
		
	}//end main method
	
	public static int remainder(int x, int y) {
		return x%y;
	}
	
	public static void main1(int x, double y, Method1 m) {
		System.out.println(m.subtract(x, (float) y));
		System.out.println(x * y);
	}//end main1 method
	
	public void main2() {
		System.out.println("This is so cool");
	}
	
	public static float add(float one, float two) {
		
		float answer = one + two;
		return answer;
		
	}//end add method
	
	
}//end public class


class Method1{
	public static float divide(float one, float two) {
		return one/two;
	}//end method
	
	public float subtract(float one, float two) {
		return one - two;
	}//end method
	
	public Method1() {
		
	}//end constructor
	
	public float combine(float one, float two) {
		return divide(subtract(one,two), one);
	}
	
}//end Method1