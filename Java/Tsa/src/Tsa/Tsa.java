package Tsa;

import java.util.ArrayList;
import java.util.Scanner;

public class Tsa {
	static Scanner oldScanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Prints out the outcome
		System.out.println(total());

	}// end main method

	public static char total() {
		//ArrayLists represent the respective teams 
		ArrayList<Integer> apple = new ArrayList<Integer>();
		ArrayList<Integer> banana = new ArrayList<Integer>();
		
		
		for (int i = 0; i < 2; i++) {
			for (int d = 0; d < 3; d++) {
				System.out.println("");
				if (i == 0) {
					apple.add(d, oldScanner.nextInt());
				} else {
					banana.add(d, oldScanner.nextInt());
				} // end if/else
			} // end for loop
		} // end for loop
		int aTotal = (apple.get(0) * 3) + (apple.get(1) * 2) + (apple.get(2) * 1);
		int bTotal = (banana.get(0) * 3) + (banana.get(1) * 2) + (banana.get(2) * 1);
		if (aTotal > bTotal) {
			return 'A';
		} else if (bTotal > aTotal) {
			return 'B';
		} else {
			return 'T';
		}

	}// end total method

}// end Tsa class
