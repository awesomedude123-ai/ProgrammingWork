package com.sriwork.challenges;

public class Floor {
    private double width;
    private double length;

    public Floor(double width, double length) {
        if(width>=0){
            this.width = width;
        }else{
            this.width=0;
        }

        if(length<0){
            length=0;
        }else {
            this.length = length;
        }
    }//end constructor

    public double getArea(){
        return this.width*this.length;
    }

}//end class

class Carpet{
    private double cost;

    public Carpet(double cost){
        if(cost<0){
            this.cost=0;
        }else{
            this.cost=cost;
        }
    }//end constructor

    public double getCost() {
        return this.cost;
    }
}
class Calculator{
    private Floor floor;
    private Carpet carpet;

    public Calculator(Floor floor, Carpet carpet){
        this.floor=floor;
        this.carpet=carpet;
    }

    public double getTotalCost(){
        return floor.getArea()*carpet.getCost();
    }
}