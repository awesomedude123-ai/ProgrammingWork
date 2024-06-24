package edu.psu.ist.model;

import java.util.ArrayList;

public class StudentUser extends User{
    private int year;
    private SchoolType schoolType;
    private String schoolName;

    private ArrayList<Recommendation> recommendations;

    public StudentUser(String name, int year, SchoolType schoolType, String schoolName){
        super(name);
        this.year = year;
        this.schoolType = schoolType;
        this.schoolName = schoolName;
        this.recommendations = new ArrayList<Recommendation>();
        this.type=Type.STUDENT;
    }

    public StudentUser(String name, int year, SchoolType schoolType, String schoolName, ArrayList<Recommendation> recommendations){
        super(name);
        this.year = year;
        this.schoolType = schoolType;
        this.schoolName = schoolName;
        this.recommendations = recommendations;
        this.type=Type.STUDENT;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public SchoolType getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(SchoolType schoolType) {
        this.schoolType = schoolType;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public ArrayList<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(ArrayList<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    @Override
    public void support(String question, String answer, Skill skill) { //Overridden Method
        skill.addQuestion(question);
    }


    //This is another overriden method. However, it is being used to print.
    @Override
    public String printQuestions() {
        String value = "";
        for(Recommendation i : recommendations){
            for(Skill skill : i.getSkills()){
                value = value + skill.getName()+ " " +skill.getQuestions().toString();
            }
        }//end for loop
        return value;
    }

    @Override
    public String toString() {
        String value = "ID: "+super.getId()+"\nName: "+super.getName()+"\nSchool Type: "+schoolType+"\nSchool Name: "+schoolName+"\nYear: "+year+"\nType: Student";
        if(recommendations != null){
            for(Recommendation i : recommendations){
                value = value + "\n" + i.toString();
            }
        }

        return value;
    }
}
