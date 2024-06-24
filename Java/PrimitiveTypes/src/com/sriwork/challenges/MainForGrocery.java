package com.sriwork.challenges;

import com.sriwork.GroceryList;

import java.util.Scanner;

public class MainForGrocery {
    public static GroceryList list1=new GroceryList();
    public static Scanner oldScanner=new Scanner(System.in);
    public static void main(String[] args) {
        boolean quit=false;
        int choice=0;
        printInstructions();
        while(!quit){
            System.out.println("Enter your chocie: ");
            choice=oldScanner.nextInt();
            oldScanner.nextLine();

            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    list1.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit=true;break;
                default:
                    System.out.println("Reenter a valid choice");
            }
        }
    }//end main mood

    public static void printInstructions(){
        System.out.println("\n Press");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the grocery list");
        System.out.println("\t 2 - To add an item to the list");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item from the list");
        System.out.println("\t 5 - To search for an item in the list");
        System.out.println("\t 6 - To quit the application");
    }
    public static void addItem(){
        System.out.println("Please enter the grocery item");
        list1.addGroceryItem(oldScanner.nextLine());
    }

    public static void modifyItem(){
        System.out.println("enter item number");
        int no1= oldScanner.nextInt();
        oldScanner.nextLine();
        System.out.println("Enter replacement item");
        list1.modifyGroceryList(no1-1,oldScanner.nextLine());
    }
    public static void removeItem(){
        System.out.println("enter item number");
        int no1= oldScanner.nextInt();
        oldScanner.nextLine();
        list1.removeGroceryItem(no1-1);
    }

    public static void searchItem(){
        System.out.println("Enter item to search for: ");
        String item= oldScanner.nextLine();
        if(list1.findItem(item)!=null){
            System.out.println(item +" is in the list");
        }else{
            System.out.println(item+" is not in the list");
        }
    }

}
