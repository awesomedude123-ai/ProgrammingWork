package com.sriwork.challenges;

public class NumberToWord {
    public static void numberToWords(int x){
        if(x<0){
            System.out.println("Invalid Value");
        }else{
            int count=getDigitCount(x),reversed=reverse(x);
            for(int i=0;i<count;i++){
                switch(reversed%10){
                    case 0:
                        System.out.println("Zero");break;
                    case 1:
                        System.out.println("One");break;
                    case 2:
                        System.out.println("Two");break;
                    case 3:
                        System.out.println("Three");break;
                    case 4:
                        System.out.println("Four");break;
                    case 5:
                        System.out.println("Five");break;
                    case 6:
                        System.out.println("Six");break;
                    case 7:
                        System.out.println("Seven");break;
                    case 8:
                        System.out.println("Eight");break;
                    case 9:
                        System.out.println("Nine");break;
                }//end switch case statement
                reversed=reversed/10;
            }//end for loop
        }

    }//end method
    public static int reverse(int x){

        if(x<0){
            x=x*-1;
            String y="";
            int count=getDigitCount(x);
            for(int i=0;i<count;i++){
                y+=(x%10);
                x/=10;
            }
            return -1*Integer.parseInt(y);
        }else{
            String y="";
            int count=getDigitCount(x);
            for(int i=0;i<count;i++){
                y+=(x%10);
                x/=10;
            }
            return Integer.parseInt(y);
        }

    }//end method
    public static int getDigitCount(int x){
        if(x<0){
            return -1;
        }else{
            int y=0;
            while(x!=(x%(int)Math.pow(10,y))){
                y+=1;
            }
            return y;
        }
    }//end method
}
