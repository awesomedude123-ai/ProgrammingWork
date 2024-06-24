package com.sriwork.challenges;

public class Point {
    private int x;
    private int y;

    public Point(){

    }

    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(){
        return Math.sqrt(Math.pow((0-this.x),2)+Math.pow((0-this.y),2));
    }

    public double distance(int x1,int y1){
        return Math.sqrt(Math.pow((x1-this.x),2)+Math.pow((y1-this.y),2));
    }

    public double distance(Point p){
        return Math.sqrt(Math.pow((p.x-this.x),2)+Math.pow((p.y-this.y),2));
    }


}
