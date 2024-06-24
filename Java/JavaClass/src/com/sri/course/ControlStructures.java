package com.sri.course;

import java.util.Scanner;

public class ControlStructures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * /Method-Method Signatures -> Access Modifiers(Public, Private, Protected, Final) 
		 * static/""(What method to run first. It also means same value used) 
		 * Return Type=> Data Types -> int, char, float, double, String, boolean
		 * Name-> main
		 * Parameters-> are the data types or variables needed for the method to run successfully
		 */
		
		
		//Control Structures
		/*
		 * if statement
		 * for
		 * while
		 * do while
		 * switch case
		 */
		
		int num = 10; 
		int six = 6;
		
		boolean x = true, y=false;
		
		/*
		 * <
		>
		<=
		>=
		== -> is equal to
		 */
		
		if(num>=six) {
			if(num==0) {
				System.out.println("This worked");
			}else if(num==1){
				System.out.println("This worked but did not work");
			}else {
				System.out.println("This is cool");
			}
			
		}else {
			System.out.println("This did not work");
		}
		
		//A certain line of code to run first regardless of conditon
		
		
		
		do {
			System.out.println("Do While: "+num);
			num++;
		}while(num<15);
		
		num=10;
		
		System.out.println("Do While: "+num);
		
		while(num<15) {
			System.out.println("While: " + num);
			num++;
			
		}//end while loop
		
		for(int i = 0, p = 0;i<5;i++, p++) {
			System.out.println(i);
			System.out.println(p);
		}//end for loop
		
		switch(num+1) {
			case 10:
				System.out.println(10);
				break;
			case 11:
				System.out.println(11);
				break;
			case 12:
				System.out.println(12);
				break; //This one
			case 16:
				System.out.println("This worked");
				break;
			default:
				System.out.println(num);
				break;
		}//end switch case statement
		
		num++;
		if(num==10) {
			System.out.println(10);
		}else if(num==11) {
			System.out.println(11);
		}else if(num==12) {
			System.out.println(12);
		}else if(num==16) {
			System.out.println(16);
		}else {
			System.out.println(num);
		}
		
		
		
		//Take an input -> Number of times you want to loop
		
		//Create for loop to loop through print statement -> print i-variable
		//check if variable is equal to certain value -> if it is, print "My n umber was found" and then break the code
		
		
		//Enter the information for someone -> "is there anyone else you need to enter info for? Y or N" if Y -> Enter another person's info N -> "Have a good day"
		
		
		
		
		//Home Work

	}//end main method

}//end class
