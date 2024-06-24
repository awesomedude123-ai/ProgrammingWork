package com.sri;

import java.util.Scanner;

public class School {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner oldScanner = new Scanner(System.in);
		
		/*
		 * Scanner
		System.out.println
		operations->math
		
		Student(age,name,address, grade, gpa);
		 */
		System.out.println("Print age");
		int age = oldScanner.nextInt();
		System.out.println("Print name");
		String name = oldScanner.next();
		oldScanner.nextLine();
		System.out.println("Print address");
		String address = oldScanner.nextLine();
		System.out.println("Print grade");
		
		int grade=oldScanner.nextInt();
		System.out.println("Print gpa");
		double gpa=oldScanner.nextDouble();
		
		
		Student s1 = new Student(age,name,address, grade, gpa);
		System.out.println(s1.age);
		System.out.println(s1.name);
		System.out.println(s1.address);
		System.out.println(s1.grade);
		System.out.println(s1.gpa);
		
		
		//Input for the different parameters(age, name, address, grade, gpa)

	}

}
