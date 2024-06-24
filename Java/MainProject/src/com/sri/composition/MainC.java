package com.sri.composition;

public class MainC {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20,20,5);
        Case theCase = new Case("220B","Dell","240",dimensions);

        Monitor theMonitor = new Monitor("27inch Beast","Acer",27, new Resolution(255,14));

        MotherBoard motherBoard=new MotherBoard("Bj-200","Asus",4,6,"v2.44");
        Computer pc=new Computer(theCase,theMonitor,motherBoard);
        pc.powerUp();

        Wall wall1=new Wall("West");
        Wall wall2=new Wall("South");
        Wall wall3=new Wall("East");
        Wall wall4=new Wall("North");
        Ceiling ceiling = new Ceiling(12,55);
        Bed bed=new Bed("Modern",4,3,2,1);
        Lamp lamp=new Lamp("Classic",false,75);

        Bedroom bedroom=new Bedroom("Sri", wall1,wall2,wall3,wall4,ceiling,bed,lamp);
        bedroom.makeBed();

        bedroom.getLamp().turnOn();
    }
}
