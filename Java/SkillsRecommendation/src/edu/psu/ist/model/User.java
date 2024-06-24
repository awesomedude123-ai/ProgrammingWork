package edu.psu.ist.model;

public class User {

    private static int lastId=0;
    private String name;


    protected Type type;

    private int id=0;

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
