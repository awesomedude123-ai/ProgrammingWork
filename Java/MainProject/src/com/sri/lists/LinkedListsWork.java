package com.sri.lists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListsWork {
    public static void main(String[] args) {
        /**
         * ArrayList<Integer> a=new ArrayList<Integer>();
         *         a.add(1);
         *         a.add(2);
         *         a.add(4);
         *         a.forEach(x -> System.out.println(x));
         *         a.add(2,3);//add the value at a certain index and pushes everything down.
         *         a.forEach(x -> System.out.println(x));
         */

        LinkedList<String> placesToVisit=new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add("Melvin");
        placesToVisit.add("Dubai");
        placesToVisit.add("Hyderabad");
        placesToVisit.add("Madrid");
        placesToVisit.add("Las Vegas");

        printList(placesToVisit);

        placesToVisit.add(1,"Seven Springs");
        printList(placesToVisit);

        placesToVisit.add("My House");

        /**
         * placesToVisit.remove(3);
         *         printList(placesToVisit);
         */

        LinkedList<String> placesWishToVisit=new LinkedList<String>();
        addInOrder(placesWishToVisit,"Sydney");
        addInOrder(placesWishToVisit,"Hyderabad");
        addInOrder(placesWishToVisit,"Madrid");
        addInOrder(placesWishToVisit,"Las Vegas");
        addInOrder(placesWishToVisit,"New York");
        addInOrder(placesWishToVisit,"Dubai");
        addInOrder(placesWishToVisit,"Melvin");
        printList(placesWishToVisit);
        addInOrder(placesWishToVisit,"Philadelphia");
        addInOrder(placesWishToVisit,"Madrid");
        printList(placesWishToVisit);

        visit(placesWishToVisit);


    }

    public static void printList(LinkedList<String> lists){
        Iterator<String> i=lists.iterator();
        while(i.hasNext()){
            System.out.println("Now visiting "+i.next());
        }//end while loop
        System.out.println("===================");
    }

    private static boolean addInOrder(LinkedList<String> lists,String newCity){
        ListIterator<String> stringListIterator=lists.listIterator();

        while(stringListIterator.hasNext()){
            int comparision=stringListIterator.next().compareTo(newCity);
            if(comparision==0){
                //equal do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            }else if(comparision>0){
                //New city should appear before this item
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
        }

        stringListIterator.add(newCity);return true;
    }

    private static void visit(LinkedList cities){
        Scanner oldScanner=new Scanner(System.in);
        boolean quit=false;
        boolean goingForward=true;
        ListIterator<String> listIterator=cities.listIterator();
        if(cities.isEmpty()){
            System.out.println("No cities in the itinerary");
        }else{
            System.out.println("Now Visiting "+listIterator.next());
            printMenu();
        }

        while(!quit){
            int action=oldScanner.nextInt();
            oldScanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Vacation Over");
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now Visiting "+listIterator.next());
                    }else{
                        System.out.println("Reached end of list");
                        goingForward=false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Visiting "+listIterator.previous());
                    }else{
                        System.out.println("We are at the start of the list");
                        goingForward=true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n"+"1 - go to next city\n"+"2 - go to previous city\n"+"3 - print menu options");
    }
}
