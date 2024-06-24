package com.sri.challenge.playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String name;
    private String artist;

    private ArrayList<Song> songs;
    public Album(String name, String artist){
        this.name=name;
        this.artist=artist;

    }

    public boolean addSong(String title,double duration){
        for(int i=0;i<songs.size();i++){
            if(songs.get(i).getTitle().equals(title)){
                return false;
            }
        }
        songs.add(new Song(title,duration));return true;
    }

    private boolean findSong(String title){
        for(int i=0;i<songs.size();i++){
            if(songs.get(i).getTitle().equals(title)){
                return true;
            }
        }//end loop
        return false;
    }

    public boolean addToPlayList(int num, LinkedList<Song> list1){
        ListIterator<Song> iterator=list1.listIterator();
        while(iterator.hasNext()){
            int y=iterator.next().getTitle().compareTo(songs.get(num).getTitle());
            if(y==0){
                return false;
            }else{
                if(y>0){
                    iterator.previous();
                    iterator.add(songs.get(num));
                    return true;
                }
            }
        }
        iterator.add(songs.get(num));return true;
    }//end method

    public boolean addToPlaylist(String title, LinkedList<Song> list1){
        boolean c=findSong(title);
        if(c==false){
            return false;
        }else{
            int u=0;
            for(int i=0;i<songs.size();i++){
                if(songs.get(i).getTitle().equals(title)){
                    u=i;
                }
            }//end loop
            ListIterator<Song> iterator=list1.listIterator();
            while(iterator.hasNext()){
                int y=iterator.next().getTitle().compareTo(songs.get(u).getTitle());
                if(y==0){
                    return false;
                }else{
                    if(y>0){
                        iterator.previous();
                        iterator.add(songs.get(u));
                        return true;
                    }
                }
            }
            iterator.add(songs.get(u));return true;
        }
    }
}
