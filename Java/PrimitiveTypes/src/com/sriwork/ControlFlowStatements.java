package com.sriwork;

public class ControlFlowStatements {
    public static void main(String[] args) {
        int switchValue=4;
        switch(switchValue){
            case 1:
                System.out.println("1");break;
            case 2:
                System.out.println("2");break;
            case 3:
                System.out.println("3");break;
            case 4: case 5: case 6:
                System.out.println("4 or 5 or 6");break;
            default:
                System.out.println("Not a 1 or 2 or 3 or 4.");break;
        }
        char value='D';
        switch(value){
            case 'A': case 'B': case 'C': case 'D':
                System.out.println(value + " was found");break;
            default:
                System.out.println("ABCD have not been detected");break;
        }
    }
}
