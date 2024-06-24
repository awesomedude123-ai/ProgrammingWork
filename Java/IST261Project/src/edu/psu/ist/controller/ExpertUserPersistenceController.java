package edu.psu.ist.controller;

import edu.psu.ist.model.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExpertUserPersistenceController {

    private List<User> experts = new ArrayList<>();

    private String fileName = "ExpertsFile.txt";

    public ExpertUserPersistenceController() {
        readExpertsFile();
    }

    public List<User> getExperts() {
        return this.experts;
    }

    public void setExperts(List<User> experts) {
        this.experts = experts;
    }

    public void readExpertsFile(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            this.experts= (ArrayList) ois.readObject();
            ois.close();
            System.out.println("Successfully read from the expert file ");
        }catch (Exception e) {
            System.out.println("caught exception while reading from expert file: " + e.getMessage());
        }

    }

    public void writeExpertsFile(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(this.experts);
            oos.close();
            System.out.println("Successfuly wrote into expert file");
        }catch (Exception e){
            System.out.println("caught exception while writing to expert file: "+e.getMessage());
        }

    }

}
