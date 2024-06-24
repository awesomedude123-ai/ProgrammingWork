package com.sriwork.challenges;

public class StarShape {
    public static void printSquareStar(int x){
        if(x<5){
            System.out.println("Invalid Value");
        }else{
            for(int i=1;i<=x;i++){
                if(i==1 || i==x){
                    System.out.println("*".repeat(x));
                }else{
                    for(int y=1;y<=x;y++){
                        if(y==1 || y==x){
                            System.out.print("*");
                        }else{
                            if(y==i || y==x-i){
                                System.out.print("*"+(i+" "+(x-i)));
                            }else{
                                System.out.print(" ");
                            }
                        }
                    }//end big for loop
                    System.out.println();
                }//end if statement

            }//end main for loop
        }
    }
}
