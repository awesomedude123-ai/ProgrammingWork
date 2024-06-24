package Tsa;

import java.util.Scanner;

public class Flip {
	static Scanner oldScanner = new Scanner(System.in);

	public static void main(String[] args) {
		/**
		 * int [] array= {1,2,3,4}; System.out.println(array[0] + " " +array[1]);
		 * System.out.println(array[2] + " " +array[3]);
		 **/
		System.out.print("This worked");
		String word = oldScanner.nextLine();
		k(word);
	}// end main method
	

	public static void k(String word) {
		int[][] graph = new int[][] { 
			{ 1, 2 }, 
			{ 3, 4 } 
			};
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == 'H') {
				int a = graph[0][0];
				int b = graph[0][1];
				graph[0][0]=graph[1][0];
				graph[0][1]=graph[1][1];
				graph[1][0]=a;
				graph[1][1]=b;
			} else if (c == 'V') {
				int a = graph[0][0];
				int b = graph[1][1];
				graph[1][1]=graph[1][0];
				graph[1][0]=b;
				graph[0][0]=graph[0][1];
				graph[0][1]=a;
			} // end if statement
		} // end for loop
		for(int rows=0;rows<2;rows++) {
			for(int columns=0;columns<2;columns++) {
				System.out.print(graph[rows][columns]);
				if(columns==0) {
					System.out.print(" ");
				}
				
			}//end for loop
			System.out.println();
			System.out.println("Hi");
		}//end row loop
	}// end method

}// end Flip class
