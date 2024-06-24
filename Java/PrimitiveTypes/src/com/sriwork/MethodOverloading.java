package com.sriwork;

public class MethodOverloading {
    public static void main(String[] args) {
        System.out.println(calculateScore("Sri",1000));
        System.out.println(calculateScore(500));
        System.out.println(calcFeetAndInchesToCentimeters(-3,9));
    }

    public static int calculateScore(String player,int score){
        System.out.println("Player "+player +" scored "+score+" points.");
        return score*1000;
    }
    public static int calculateScore(int score){
        System.out.println("Player Unnamed Player scored "+score+" points.");
        return score*1000;
    }

    public static double calcFeetAndInchesToCentimeters(double feet,double inch){
        if(feet<0 || inch<0 || inch>12){
            return -1;
        }else{
            return (feet*12 + inch)*2.54;
        }

    }
    public static double calcFeetAndInchesToCentimeters(double inch){
        if(inch<0){
            return -1;
        }else{
            return calcFeetAndInchesToCentimeters(inch/12,inch%12);
        }

    }


}
