package com.sri.highschool;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Default Values-> Preset Values
		
		/**
		 * String-> null
		 * char->\u000f -> 0 or nothing 
		 * boolean->false
		 * int->0
		 * double->0.0
		 * float-> 0.0f
		 */
		
		int i4;
		
		//Google it
		System.out.println("Hi buddy.\n This is really cool");
		
		//Data Types
		String names= "";
		int x = 5;
		double y = 9.0;
		float u = 0.0f;
		char i = 'p';
		boolean value = false;
		double j = 10.0;
		
		int p = 9;
		//System.out.println(x+p);
		//System.out.println(x-p);
		System.out.println(p/x);
		//System.out.println(p*x);
		//System.out.println(p%x);
		
		//Floor Divison <-> int/int <-> Modulus
		
		System.out.println(x%y);
		//Math 4 Main Operations
		/**
		 * Addition - +
		 * Subtraction -> -
		 * Multiplication -> *
		 * Division-> /
		 * Modulus-> Remainder -> %
		 */
		
		//TypeCasting -> Converting a data Type to another Data Type
		
		double d1 = 9.9;
		int i1 = 0;
		
		if(d1>=9.5) {
			i1 = (int) d1 + 1;
		}else {
			i1 = (int) d1;
		}
		
		System.out.println(d1 + " -> " + i1);
		int i2 = 10;
		float f1 = 9.9f;
		int i3 = (int) f1;
		double d2 = f1;
		System.out.println(f1 + " -> " + d2);
		System.out.println(f1 + " -> " + i3);
		
		System.out.println(i1 + f1 + d2 + " Here is the value");
		
		String name1 = i1+i2 + "";
		
		String name = i1 + f1 + d2 + ""; //Concatination
		
		System.out.println(name);
		
		System.out.println(i3);
		
		System.out.println(name + i3);
		
		//Type Cast: float -> int, double -> int, double -> float
		//Create two variables: int, doubles, float -> Print out all five operations
		//Explore the other data types. char, boolean
		
		
	}//end main method

}//end public class
