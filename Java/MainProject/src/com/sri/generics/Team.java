package com.sri.generics;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
    private String teamName;
    int played=0;
    int won=0;
    int lose=0;
    int tie=0;

    private ArrayList<T> members=new ArrayList<>();

    public Team(String teamName){
        this.teamName=teamName;
    }

    public String getTeamName(){
        return this.teamName;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName()+" already on the team");return false;
        }else{
            members.add(player);
            System.out.println(player.getName()+" has been added on the team "+teamName);return true;
        }
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResult(Team<T> opponent,int ourScore, int theirScore){
        String message;
        if(ourScore==theirScore){
            tie++;
            message=" drew with ";
        }else if(ourScore>theirScore){
            won++;
            message=" beat ";
        }else{
            lose++;
            message=" lost to ";
        }

        played++;
        if(opponent!=null){
            System.out.println(this.getTeamName()+message+opponent.getTeamName());
            opponent.matchResult(null,theirScore,ourScore);
        }
    }

    public int ranking(){
        return (won*2)+tie;
    }

    @Override
    public int compareTo(Team<T> o) {
        if(this.ranking()>o.ranking()){
            return -1;
        }else if(this.ranking()<o.ranking()){
            return 1;
        }else{
            return 0;
        }
    }
}
