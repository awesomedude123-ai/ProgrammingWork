package com.sri.course;

public class TypeCasting {
	
	//Review Data Types
	//Learn type cast
	//Practice
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Data Types
		/**
		 * String-"" -> used for words or multiple characters         null
		float - Mix of double and int     0f
		double - decimal numbers -> 9.0,99.0      0.0
		int - numbers -> whole numbers positive or negative      0
		char-'' -> a, b, c , d,e,f,g       /u00000f=0
		boolean-True, false          false
		
		
		
		
		* -> multiplication
		/ -> divison
		- -> subtraction
		% -> remainder
		+ -> addition
		
		10/20 -> 0
		10%20 -> 10
		
		10.0 / 20 -> 0.5
		10/20.0 -> 0.5
		10.0/20.0 -> 0.5
		
		String method -> Concatination -> Combination
		
		int/ int -> Floor Division
		
		String food = " Ice Cream ";
		String food1 = " Pizza ";
		String food2 = " Popsicles ";
		
		String num2 = "pop";
		
		char a = 'a'; 
		
		int num = 10;
		int num1 = 20;
		
		double num3 = 10.9;
		
		String word = "" + a + num + num3;
		
		String foods = food + food1 + food2 + a + (num*num1);
		
		
		
		System.out.println(foods);
		
		19.99999
		
		9.4999999999999999
		9.5000000000000001
		 */
		
		int y = (int) 9.8;
		
		int a = (int) 9.8f;
		
		
		float f = 1.8f; 
		
		/*
		 * double -> float
		double -> int
		float -> int
		float -> double
		 */
		
		double u = 1.5;
		
		//Calculator -> Result Type Cast
		// 2 doubles (ADD OR SUBTRACT OR MULTIPLY) -> int  2 floats-> int
		
		
		System.out.println((int)9.8/19.6);
		System.out.println((int)(9.8/19.6));
		
		System.out.println(9.8/(int)19.6);
		
		
		
		
		
		double b = f; 
		
		
		int conditon = (int) (f + f);

		
		
		int d = 0;
		
		if( f+f > conditon+0.5) {
			conditon=conditon + 1;
		}
		
		System.out.println(f);
		System.out.println(a);
		System.out.println(b);
		System.out.println(conditon);
		//d = 19
		//d -> 19, 20
		
		

	}//end main method

}//end public class
