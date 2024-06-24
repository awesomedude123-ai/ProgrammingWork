package Tsa2022;

import java.util.*;

public class PartA_2152_901 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String> m = new HashMap<String,String>();
		Scanner oldScanner = new Scanner(System.in);
		String word = oldScanner.nextLine();
		
		m.put("0011001", "1");
		m.put("0010011", "2");
		m.put("0111101", "3");
		m.put("0100011", "4");
		m.put("0110001", "5");
		m.put("0101111", "6");
		m.put("0111011", "7");
		m.put("0110111", "8");
		m.put("0001011", "9");
		m.put("0001101", "0");
		//Adding the numbers and their corresponding binary digits
		for(int i=0;i<3;i++){
			//Getting the input from user
			String w = oldScanner.nextLine();
			String a="";
			//running a loop to get each individual 7-binary digits
			for(int x=0;x<=w.length()-7;x=x+7) {
				/*
				 * Since digit is 7 chars long, we start at 0 and go up to 7th index as end is not inclusive in sub string. 
				 * Loop adds 7 to starting index every rotation. We get number from hash map corresponding to binary digits and add it to answer of type string
				 */
				String p = m.get(w.substring(x,x+7));
				a=a+p;
			}//end for loop
			//Print out answer after looping through input
			System.out.println(a);
		}//end for loop
	}//end main method

}//end public class
