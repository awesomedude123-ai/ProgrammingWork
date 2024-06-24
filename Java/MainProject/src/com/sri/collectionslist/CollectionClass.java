package com.sri.collectionslist;

import java.util.ArrayList;

public class CollectionClass {
    public static void main(String[] args) {

    }
}

class Theater{
    private final String theaterName;
    private List<Seat> seats=new ArrayList<Seat>();

    public Theater(String theaterName, int numRows, int seatsPerRow){
        this.theaterName=theaterName;
        int lastRow='A'+(numRows-1);
        for( char row='A';row<=lastRow;row++){
            for(int seatNum = 1;seatNum<=seatsPerRow; seatNum++){
                Seat seat=new Seat(row + String.format("%02d",seatNum));
            }
        }
    }
}//end class
