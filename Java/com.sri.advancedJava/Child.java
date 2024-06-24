package com.sri.advancedJava;

public class Child extends ParentOne{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		num();

	}//end main method
	
	//Overloading-change the def, and method args
	//Overriding-You change the definition of the method
	
	
	public static String num(String name) {
		return name;
	}
	
	public static int num(int one) {
		return one + one;
	}
	 

}//end public class
