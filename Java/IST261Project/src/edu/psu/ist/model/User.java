package edu.psu.ist.model;

import java.io.Serializable;

public class User implements Serializable {

    protected static int lastId=0;
    protected String name;


    protected Type type;

    protected int id=0;

    public User(){

    }

    public User(String name){
        this.name=name;
        lastId++;
        id=lastId;
    }//end constructor


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void support(String question, String answer, Skill skill){ //Method being used in sub-classes

    }

    public String printQuestions(){
        return "Questions";
    }

    public String toString() {
        return "Id: "+id+ "\nName: " + name;
    }
}//end class
