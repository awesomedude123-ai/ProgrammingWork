package com.sri.course;

import java.util.Scanner;

public class HomeworkClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// We are eenrolling students into school. We provide information to the school and we loop through that if we have more students. 
		//Need to ask "Do you have more students" -> based on the answer we ask again, we loop, or we end? 
		
		//for/while/do while
		//if-else/switch-case
		
		Scanner oldScanner = new Scanner(System.in);
		
		boolean condition = false;
		
		while(condition==false) {
			//Enter student and then print the student
			
			System.out.println("What is your student's name?");
			String name = oldScanner.nextLine();
			System.out.println("What is your student's grade?");
			String grade = oldScanner.nextLine();
			System.out.println("What is your phone number?");
			String phone = oldScanner.nextLine();
			System.out.println("What is your student's address?");
			String address = oldScanner.nextLine();
			System.out.println("What is your student's age?");
			int age =oldScanner.nextInt();
			oldScanner.nextLine();
			
			System.out.println("Your student's name: " + name + "\nYour student's grade: " + grade
					+ "\nYour phone number: " + phone + "\nYour student's address: " + address 
					+ "\nYour student's age: " + age);
			
			System.out.println("Do you have any other students you need to enroll? Enter a Y for yes or a N for no!");
			
			String response = oldScanner.nextLine();

			if(response.equalsIgnoreCase("n")==true) {
				condition = true;
			}//end if statement
			
		}//end while loop
		
		System.out.println("This ended!");
		
	}//end main method
	
	/**
	 * Homework-> write code -> logic
	 * Data Structures -> Arrays, Lists, Arraylists, Hashmap, Maps, Collections
	 * String methods -> String -> wrapper -> primitive data wrapped around white  methods
	 */

}//end public class