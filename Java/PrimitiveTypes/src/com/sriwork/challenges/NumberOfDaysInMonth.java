package com.sriwork.challenges;

public class NumberOfDaysInMonth {

    public static boolean isLeapYear(int year){
        if(year>=1 && year<=9999){
            if(year%400==0){
                return true;
            }else if(year%4==0){
                if(year%100==0){
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public static int getDaysInMonth(int m, int y){
        if((m>=1 && m<=12) && (y>=1 && y<=9999)){
            boolean value = isLeapYear(y);
            switch(m){
                case 1:
                    return 30;
                case 2:
                    if(value==true){
                        return 29;
                    }else{
                        return 28;
                    }
                case 3:
                    return 31;
                case 4:
                    return 30;
                case 5:
                    return 31;
                case 6:
                    return 31;
                case 7:
                    return 31;
                case 8:
                    return 30;
                case 9:
                    return 31;
                case 10:
                    return 31;
                case 11:
                    return 30;
                case 12:
                    return 31;
                default:
                    return -1;
            }


        }else{
            return -1;
        }
    }
}
