package edu.psu.ist.model;

import java.util.ArrayList;

public class Recommendation {
    private String name;
    private ArrayList<Skill> skills;
    private ArrayList<Major> majors;

    private ArrayList<Interest> interests;
    private int progress;
    private boolean isCompleted;

    public Recommendation(String name,ArrayList<Major> majors, ArrayList<Interest> interests){
        this.name = name;
        this.majors = majors;
        this.interests = interests;
        this.skills=new ArrayList<Skill>();
        this.progress=0;
        this.isCompleted=false;
    }//end constructor

    public void addSkill(Skill skill){
        this.skills.add(skill);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getProgress(){
        return this.progress;
    }

    public void setProgress(int progress){
        this.progress = progress;
    }

    public boolean isCompleted(){
        return this.isCompleted;

    }

    public void setCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }

    public ArrayList<Skill> getSkills(){
        return this.skills;
    }

    public void setSkills(ArrayList<Skill> skills){
        this.skills = skills;
    }

    public ArrayList<Major> getMajors(){
        return this.majors;
    }

    public void setMajors(ArrayList<Major> majors){
        this.majors = majors;
    }

    public ArrayList<Interest> getInterests(){
        return this.interests;
    }

    public void setInterests(ArrayList<Interest> interests){
        this.interests = interests;
    }



    public String toString() {
        String skill="";
        String major = "";
        String interest="";
        for(int i=0;i<this.skills.size();i++) {
            if(i<this.skills.size()-1){
                skill = skill + this.skills.get(i).getName()+", ";
            }else{
                skill = skill + this.skills.get(i).getName();
            }

        }
        for(int i=0;i<this.majors.size();i++) {
            if(i==this.majors.size()-1){
                major=major+this.majors.get(i).getName();
            }else{
                major=major+this.majors.get(i).getName() + ", ";
            }
        }
        for(int i=0;i<this.interests.size();i++) {
            if(i==this.interests.size()-1){
                interest=interest+this.interests.get(i).getName();
            }else{
                interest=interest+this.interests.get(i).getName() + ", ";
            }
        }

        return "List Name: "+this.name+"\nList Progress: "+this.progress+"\nIs Completed: "
                +this.isCompleted+"\nList of Majors: "+major+"\nList of Interests: "+interest
                +"\nList of Skills: "+skill;
    }

}
