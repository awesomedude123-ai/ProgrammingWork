package edu.psu.ist.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Skill {

    private static int id = 0;
    private String name;
    private String description;
    private ArrayList<Major> majors;

    private ArrayList<Interest> interests;
    private ArrayList<String> waysToLearn;

    private String expertName;

    private HashMap<String, String> questions;

    public Skill(String name, String description, ArrayList<Major> majors, ArrayList<Interest> interests,  ArrayList<String> waysToLearn, String expertName) {
        this.name=name;
        this.description=description;
        this.majors=majors;
        this.interests=interests;
        this.waysToLearn=waysToLearn;
        this.expertName=expertName;
        this.questions=new HashMap<String,String>();
        id++;
    }//end constructor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Skill.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Major> getMajors() {
        return majors;
    }

    public void setMajors(ArrayList<Major> majors) {
        this.majors = majors;
    }

    public ArrayList<Interest> getInterests() {
        return this.interests;
    }

    public void setInterests(ArrayList<Interest> interests) {
        this.interests = interests;
    }

    public ArrayList<String> getWaysToLearn() {
        return waysToLearn;
    }

    public void setWaysToLearn(ArrayList<String> waysToLearn) {
        this.waysToLearn = waysToLearn;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public HashMap<String,String> getQuestions() {
        return questions;
    }

    public void setQuestions(HashMap<String,String> questions) {
        this.questions = questions;
    }

    public void addQuestion(String question){
        questions.put(question,"");
    }

    public String toString() {
        String listOfMajors="{";
        String listOfWays="{";
        String listOfInterests="{";
        for(int i=0;i<this.majors.size();i++) {
            if(i==this.majors.size()-1){
                listOfMajors=listOfMajors+this.majors.get(i).getName();
            }else{
                listOfMajors=listOfMajors+this.majors.get(i).getName() + ", ";
            }
        }
        listOfMajors+="}";

        for(int i=0;i<this.waysToLearn.size();i++) {
            if(i==this.waysToLearn.size()-1){
                listOfWays=listOfWays+this.waysToLearn.get(i);
            }else{
                listOfWays=listOfWays+this.waysToLearn.get(i) + ", ";
            }
        }
        listOfWays+="}";
        for(int i=0;i<this.interests.size();i++) {
            if(i==this.interests.size()-1){
                listOfInterests=listOfInterests+this.interests.get(i).getName();
            }else{
                listOfInterests=listOfInterests+this.interests.get(i).getName() + ", ";
            }
        }
        listOfInterests+="}";
        return "Skill Name: "+this.name+"\nSkill Description: "+this.description+"\nList of Majors: "
                +listOfMajors+"\nList of Interests: "+listOfInterests+"\nList of Learning Ways: "+listOfWays
                +"\nExpert Name: "+this.expertName;
    }//end toString method
}//end class
