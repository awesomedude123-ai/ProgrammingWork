package Situations;

import java.util.ArrayList;
import java.util.Scanner;

public class Infinite {
	static Scanner oldScanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = oldScanner.nextInt();
		String[][] array = new String[number][3];
		//ilter(number, array); new String[number][number][number];

	}//end main method 
	public static void filter(int number, String[][] old) {
		ArrayList<String> array=new ArrayList<String>();
		String[] array1;
		int rotations=0;
		for(int i=0;i<number;i++) {
			array.add(i, oldScanner.nextLine());
			array1=array.get(i).split(" ");
			for(int x=0;x<3;x++) {
				old[i][x]=array1[i+x];
			}//end for loop
		}//end for loop
		for(;;) {
		for(int i=0;i<number;i++) {
			if(old[i][0]=="E") {
				Integer num=Integer.parseInt(old[i][1]);
				num=num+1;
				old[i][1]=num.toString();
			}//end if statement
			if(old[i][0]=="N") {
				Integer num1=Integer.parseInt(old[i][2]);
				num1=num1+1;
				old[i][2]=num1.toString();
			}//end if statement
			rotations++;
		}//end for loop
		
		}//end for loop
		if(old[i][0]=="E") {
			Integer z=Integer.parseInt(old[i][1]);
			if(old[i+1][1]=="N") {
				if(z==Integer.parseInt(old[i+1][1]) && Integer.parseInt(old[i][2])<Integer.parseInt(old[i+1][2]) 
						&& Integer.parseInt(old[i][2]) >Integer.parseInt(old[i+1][1])-1) {
					int first=rotations;
				}
			}
		}//end if statement
		System.out.println();

	}//end filter method

}
