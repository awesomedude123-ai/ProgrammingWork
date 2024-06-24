package com.sri.innerclass;

import java.util.ArrayList;

public class GearBox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int gearNumbers=0;
    private boolean clutchIsIn;

    public GearBox(int maxGears){
        this.maxGears=maxGears;
        this.gears=new ArrayList<Gear>();
        Gear neutral =new Gear(0,0.0);
        this.gears.add(neutral);

        for(int i=0;i<maxGears;i++){
            addGear(i,i*5.3);
        }
    }

    public void operateClutch(boolean y){
        this.clutchIsIn=y;
    }

    public void addGear(int number,double ratio){
        if((number>0)&&(number<this.maxGears)){
            this.gears.add(new Gear(number,ratio));
        }
    }

    public void changeGear(int newGear){
        if((newGear>=0)&& (newGear<this.gears.size())&& clutchIsIn){
            this.gearNumbers=newGear;
            System.out.println("Gear "+newGear+" selected.");
        }else{
            System.out.println("Grind!");
            this.gearNumbers=0;
        }
    }

    public double wheelSpeed(int rev){
        if(clutchIsIn){
            System.out.println("Scream!");
            return 0.0;
        }else{
            return rev*gears.get(gearNumbers).getRatio();
        }
    }

    //Inner class, a class within a class body. It can be used by the class but not by other classes unless they are referenced.
    private class Gear{
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio){
            this.gearNumber=gearNumber;
            this.ratio=ratio;
        }

        public double getRatio(){
            return this.ratio;
        }


        public double driveSpeed(int revs){
            return revs*this.ratio;
        }
    }
}
