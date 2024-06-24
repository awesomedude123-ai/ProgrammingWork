package com.sri.challenge.playlist;

public class Song {
    private String title;
    private double duration;
    public Song(String title,double duration){
        this.title=title;
        this.duration=duration;
    }

    public String getTitle(){
        return this.title;
    }//end title

    public String toString(){
        return this.title+": "+this.duration;
    }//end method
}
