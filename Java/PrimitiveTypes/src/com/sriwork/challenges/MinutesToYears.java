package com.sriwork.challenges;

public class MinutesToYears {
    public static void printYearsAndDays(long minutes){
        if(minutes<0){
            System.out.println("Invalid Value");
        }else{
            long hours=minutes/60;
            int years=(int)(hours/(24*365));
            hours-=years*24*365;
            int days=(int)(hours/24);
            if(hours%24>0){
                days++;
            }
            System.out.println(minutes+" min = "+years+" y and "+days+" d");
        }
    }//end method
}
