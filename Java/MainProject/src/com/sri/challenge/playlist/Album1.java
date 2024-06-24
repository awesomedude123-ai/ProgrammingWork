package com.sri.challenge.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album1 {
    private String name;
    private String artist;

    public SongList songs;
    public Album1(String name, String artist){
        this.name=name;
        this.artist=artist;
        this.songs=new SongList();
    }

    public boolean addSong(String title,double duration){
        return songs.add(new Song(title,duration));
    }

    public boolean addToPlayList(int num, LinkedList<Song> list1){
       Song c=songs.findSong(num);
       if(c==null){
           return false;
       }else{
           list1.add(c);
           return true;
       }
    }//end method

    public boolean addToPlaylist(String title, LinkedList<Song> list1){
        Song c=songs.findSong(title);
        if(c==null){
            return false;
        }else{
            list1.add(c);
            return true;
        }
    }//end method
    public static class SongList{
        private ArrayList<Song> songs;

        public SongList(){
            songs=new ArrayList<Song>();
        }

        public boolean add(Song song){
            if(songs.contains(song)){
                return false;
            }else{
                songs.add(song);return true;
            }
        }

        public Song findSong(String title){
            for(int i=0;i<songs.size();i++){
                if(songs.get(i).getTitle().equals(title)){
                    return songs.get(i);
                }
            }
            return null;
        }
        public Song findSong(int trackNumber){
            if(trackNumber>songs.size() || trackNumber<=0){
                return null;
            }else{
                return songs.get(trackNumber-1);
            }
        }
    }
}
