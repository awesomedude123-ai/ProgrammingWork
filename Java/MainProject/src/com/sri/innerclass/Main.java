package com.sri.innerclass;

import java.util.Scanner;

public class Main {
    private static Scanner oldScanner=new Scanner(System.in);
    private static Button button = new Button("Print");

    public static void main(String[] args) {
        /**
         * GearBox mcLaurin=new GearBox(6);
         *         //GearBox.Gear first=mcLaurin.new Gear(10,10.9);
         *         //GearBox.Gear second=mcLaurin.new Gear(11, 25.2);
         *         //System.out.println(first.driveSpeed(100));
         *         mcLaurin.operateClutch(true);
         *         mcLaurin.changeGear(1);
         *         mcLaurin.operateClutch(false);
         *         System.out.println(mcLaurin.wheelSpeed(1000));
         *         mcLaurin.changeGear(2);
         *         System.out.println(mcLaurin.wheelSpeed(2000));
         *         mcLaurin.operateClutch(true);
         *         mcLaurin.changeGear(3);
         *         mcLaurin.operateClutch(false);
         *         System.out.println(mcLaurin.wheelSpeed(3000));
         */

        /**Local Inner Class, can only be used in the block
         * class ClickListener implements Button.OnClickListener{
         *             public ClickListener(){
         *                 System.out.println("I've been clicked");
         *             }
         *             @Override
         *             public void onClick(String title) {
         *                 System.out.println(title + " was clicked");
         *             }
         *         }
         *         button.setOnClickListener(new ClickListener());
         */

        //Anonymous Inner Class has no name but is created like this. Only used where created but is easier to create.
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title +" was clicked");
            }
        });
        listen();
    }

    private static void listen(){
        boolean quit=false;
        while(!quit){
            int choice=oldScanner.nextInt();
            switch ((choice)){
                case 0:
                    quit=true;
                    break;
                case 1:
                    button.onClick();
                    break;
            }
        }
    }
}
