package edu.psu.ist.controller;

import edu.psu.ist.model.Interest;
import edu.psu.ist.model.Major;
import edu.psu.ist.model.Skill;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SkillPersistenceController {

    private List<Skill> skills = new ArrayList<Skill>();
    private String fileName = "SkillsFile.txt";

    MajorController majorController = new MajorController();
    InterestController interestController = new InterestController();


    public SkillPersistenceController() {
        readSkillsFile();
        if(majorController.getMajors()==null && interestController.getInterests()==null) {
            majorController.setMajors(populateMajors());
            interestController.setInterests(populateInterest());
        }
    }

    public List<Skill> getSkills() {
        return this.skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void writeSkillsFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this.skills);
            oos.close();
            System.out.println("Successfully wrote into skill file");
        }catch(Exception e){
            System.out.println("caught exception while writing to skill file: "+e.getMessage());
        }
    }
    public void readSkillsFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            this.skills = (ArrayList) ois.readObject();
            ois.close();
            System.out.println("Successfully ready from the skill file");
        }catch(Exception e){
            System.out.println("caught exception while reading from skill file: "+e.getMessage());
        }//end try catch statement

    }


    private ArrayList<Major> populateMajors(){
        ArrayList<Major> majors = new ArrayList<Major>();
        majors.add(new Major("Data Science","Science of Data", 130, "IT"));
        majors.add(new Major("Computer Science", "Science of Computer", 130, "IT"));
        majors.add(new Major("Cyber-security", "Online Security", 130, "IT"));
        majors.add(new Major("Information Science", "Science of Information", 130, "IT"));
        return majors;
    }//end populateMajors

    private ArrayList<Interest> populateInterest(){
        ArrayList<Interest> interests = new ArrayList<Interest>();
        interests.add(new Interest("Programming","Coding","Technical"));
        interests.add(new Interest("Writing","Writing Reports","Non-Technical"));
        interests.add(new Interest("Cloud","Cloud Architecture","Technical"));
        interests.add(new Interest("Science","Learning about chem, phys, and bio","Non-Technical"));
        return interests;
    }
}
