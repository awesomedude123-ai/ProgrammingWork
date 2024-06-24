package com.sri.advanced;

public class inheritance extends parent{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(age(68));
		picture("cool pic");
		
	}//end main method
	
	public static void cool() {
		System.out.println("hi");
	}

}//end inheritance

//Method Overriding-> Change the implementation-> Change the body
//Overloading-Change the signature and the body or create many instances


//Parent == BO3 Parent1 == BO2
class parent extends parent1{
	
	public static int age(int x) {
		return x-10;
	}//end age method
	
	public static int age(String x) {
		return 10;
	}//end age method
	
	public static void picture(String y) {
		System.out.println("This is a cool picture " + y);
	}
	
	
	
}//end class

class parent1{
	
	public static int age(int x) {
		return x-11;
	}//end age method
	
	public static void picture(String y) {
		System.out.println("This is a cool picture " + y);
	}
	
}//end class
