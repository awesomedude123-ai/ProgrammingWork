package Tsa;

import java.util.Scanner;

public class Runoff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner oldScanner = new Scanner(System.in);
		//get number
        int number = oldScanner.nextInt();
        //convert the number into a hexadecimal
        String word = Integer.toHexString(number);
       
        //print out the hexadecimal
        System.out.println("0x"+word);
        
	}//end main method

}//end public class