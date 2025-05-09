package Tsa2022;

import java.util.*;

public class PartB_2152_901 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner oldScanner = new Scanner(System.in);
		// Create a scanner for input
		for (int l = 0; l < 3; l++) {

			String word = oldScanner.nextLine();
			// Get Input

			for (int i = 0; i < word.length(); i++) {
				// Get the character at the specific index
				char a = word.charAt(i);
				
				//Convert character into hexadecimal
				int x = (int) a;
				//Convert hexadecimal to binary string
				String b = Integer.toBinaryString(x);
				boolean y = true;
				String bin = "";
				/*
				 * Since each binary number is 8 digits long, we need to fill the remaining indices with 0.
				 * Since binary conversion can get digits ranging from 6-7 long digits, we put while loop to help fill out the rest of binary number
				 */
				while (y == true) {
					
					//checks to make sure that the length of string is 8.
					if (8 - b.length() == bin.length()) {
						y = false;
					} else {
						bin = bin + "0";
					} // end 1 if/else loop
				} // end while loop
				bin = bin + b;
				
				//for loop to create byte representation of QR code
				for (int p = bin.length(); p >= 1; p--) {
					
					//checks to see if it is outputting second character on line so it can move cursor to next line
					if (p % 2 == 1) {
						//If char is 0 then it prints an _ on line... else it prints # and moves cursor to next line
						if (bin.charAt(p - 1) == '0') {
							System.out.print("_ \n");
						} else {
							System.out.print("# \n");
						}
					} else {
						//If char is 0 then it prints an _ on line... else it prints #. Does not move cursor to next line as this is first character in line
						if (bin.charAt(p - 1) == '0') {
							System.out.print("_ ");
						} else {
							System.out.print("# ");
						} // end 3 if/else statement

					} // end 2 if/else statement
				} // end for loop
			} // end for loop
		} // end for loop
		oldScanner.close();
		// Close the scanner
	}// end main method
}// end public class
