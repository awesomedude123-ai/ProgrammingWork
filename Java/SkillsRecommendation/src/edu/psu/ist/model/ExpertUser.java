package edu.psu.ist.model;

import java.util.ArrayList;

public class ExpertUser extends User{
    private String company;

    private int yearsOfExperience;

    private ArrayList<Skill> skills;

    public ExpertUser(String name, String company, int yearsOfExperience) {
        super(name);
        this.company = company;
        this.yearsOfExperience = yearsOfExperience;
        this.skills = new ArrayList<Skill>();
        this.type=Type.EXPERT;
    }

    public ExpertUser(String name, String company, int yearsOfExperience, ArrayList<Skill> skills) {
        super(name);
        this.company = company;
        this.yearsOfExperience = yearsOfExperience;
        this.skills = skills;
        this.type=Type.EXPERT;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void support(String question, String answer, Skill skill) { //This is the method that is being overriden
        skill.getQuestions().replace(question,"",answer);
    }

    //This is another overriden method. However, it is being used to print.
    @Override
    public String printQuestions(){
        String value = "";
        for(Skill skill : skills){
            value = value + skill.getName() + " " +  skill.getQuestions().toString();
        }
        return value;
    }

    @Override
    public String toString() {
        String value = "ID: "+super.getId()+"\nName: "+super.getName()+"\nCompany: "+company+ "\nYears of Experience: "+this.yearsOfExperience;
        for(Skill i: skills){
            value=value +"\n"+i.getName();
        }
        return value;
    }
}
