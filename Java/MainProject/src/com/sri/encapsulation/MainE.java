package com.sri.encapsulation;

public class MainE {
    public static void main(String[] args) {
        Player player=new Player("Sri",100,"Bow");
        System.out.println("initial health is "+ player.getHealth());

        Printer printer=new Printer(50,true);
        System.out.println("initial page count = "+printer.getPagesPrinted());
        int pagesPrinted=printer.printPages(4);
        System.out.println("Pages printed was "+ pagesPrinted + " new total print count for printer = "+ printer.getPagesPrinted());
        pagesPrinted=printer.printPages(2);
        System.out.println("Pages printed was "+ pagesPrinted + " new total print count for printer = "+ printer.getPagesPrinted());
    }
}
