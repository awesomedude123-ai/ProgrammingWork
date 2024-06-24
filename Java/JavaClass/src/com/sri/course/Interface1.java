package com.sri.course;

public class Interface1 implements Interface{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(remainder(10,20));

	}//end main method

	public static int remainder(int i, int j) {
		// TODO Auto-generated method stub
		return i%j;
		
	}

	@Override
	public int add() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int subtract() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int multiplication() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int division() {
		// TODO Auto-generated method stub
		return 0;
	}

}//end public class

interface Interface {
	
	public int add();
	public int subtract();
	public int multiplication();
	public int division();
	
	public static int remainder(int num, int num1) {
		return num%num1;
	}
	

}//end interfaces

