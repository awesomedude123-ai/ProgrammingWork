package edu.psu.ist.test;

import edu.psu.ist.model.Interest;
import edu.psu.ist.model.Major;
import edu.psu.ist.model.Skill;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SkillTest_jUnit {
    ArrayList<Major> majors = new ArrayList<Major>(Arrays.asList(new Major("Computer Science", "The study of computers and algorithmic processes, " +
            "including their principles, their hardware and software designs, their applications," +
            " and their impact on society",20,"IT")));
    ArrayList<Interest> interests = new ArrayList<Interest>(Arrays.asList(new Interest("Computer Science", "The study of computers and algorithmic processes", "Coding")));

    ArrayList<String> waysToLearn = new ArrayList<String>(Arrays.asList("Linkedin Learning"));

    Skill skill = new Skill("Python","Coding Language", majors,interests,waysToLearn,"John");

    @Test
    @Order(1)
    @DisplayName("Get Name")
    public void testGetName(){
        assertEquals("Python", skill.getName());
    }

    @Test
    @Order(2)
    @DisplayName("Get Description")
    public void testGetDescription() {
        assertEquals("Coding Language", skill.getDescription());
    }
    
    @Test
    @Order(3)
    @DisplayName("Get Majors")
    public void testGetMajors() {
        assertEquals(majors, skill.getMajors());
    }

    @Test
    @Order(4)
    @DisplayName("Get Interests")
    public void testGetInterests(){
        assertEquals(interests, skill.getInterests());
    }

    @Test
    @Order(5)
    @DisplayName("Get Ways To Learn")
    public void testGetWaysToLearn(){
        assertEquals(waysToLearn, skill.getWaysToLearn());
    }

    @Test
    @Order(6)
    @DisplayName("Get Expert Name")
    public void testGetExpertName(){
        assertEquals("John",skill.getExpertName());
    }

    @Test
    @Order(7)
    @DisplayName("Set Name")
    public void testSetName(){
        skill.setName("php");
        assertEquals("php", skill.getName());
    }

    @Test
    @Order(8)
    @DisplayName("Set Description")
    public void testSetDescription() {
        skill.setDescription("Scripting");
        assertEquals("Scripting", skill.getDescription());
    }

    @Test
    @Order(9)
    @DisplayName("Set Majors")
    public void testSetMajors() {
        Major major = new Major("Java", "Coding Language",20,"IT");
        majors.add(major);
        skill.setMajors(majors);
        assertEquals(majors, skill.getMajors());
    }

    @Test
    @Order(10)
    @DisplayName("Set Interests")
    public void testSetInterests(){
        Interest interest = new Interest("Writing", "Giving a report", "Writing");
        interests.add(interest);
        skill.setInterests(interests);
        assertEquals(interests, skill.getInterests());
    }

    @Test
    @Order(11)
    @DisplayName("Set Ways To Learn")
    public void testSetWaysToLearn(){
        waysToLearn.add("Online Courses");
        skill.setWaysToLearn(waysToLearn);
        assertEquals(waysToLearn, skill.getWaysToLearn());
    }

    @Test
    @Order(12)
    @DisplayName("Set Expert Name")
    public void testSetExpertName(){
        skill.setExpertName("Joe");
        assertEquals("Joe",skill.getExpertName());
    }

    @Test
    @Order(13)
    @DisplayName("To String")
    public void testToString(){
        String listOfMajors="";
        String listOfWays="";
        String liftOfInterests="";
        for(int i=0;i<this.majors.size();i++) {
            if(i==this.majors.size()-1){
                listOfMajors=listOfMajors+this.majors.get(i);
            }
            listOfMajors=listOfMajors+this.majors.get(i) + ", ";
        }

        for(int i=0;i<this.waysToLearn.size();i++) {
            if(i==this.waysToLearn.size()-1){
                listOfWays=listOfWays+this.waysToLearn.get(i);
            }
            listOfWays=listOfWays+this.waysToLearn.get(i) + ", ";
        }

        for(int i=0;i<this.interests.size();i++) {
            if(i==this.interests.size()-1){
                liftOfInterests=liftOfInterests+this.interests.get(i);
            }
            liftOfInterests=liftOfInterests+this.interests.get(i) + ", ";
        }
        String answer = "Skill Name: "+skill.getName()+"\nSkill Description: "+skill.getDescription()+"\nList of majors: "
                +listOfMajors+"\nList of Interests: "+liftOfInterests+"\nList of Learning Ways: "+listOfWays
                +"\nExpert Name: "+skill.getExpertName();

        assertEquals(answer, skill.toString());
    }
    }

