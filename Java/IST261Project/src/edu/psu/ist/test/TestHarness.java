package edu.psu.ist.test;

import edu.psu.ist.controller.SkillController;
import edu.psu.ist.controller.SkillManager;
import edu.psu.ist.controller.UserController;
import edu.psu.ist.model.*;

import java.util.ArrayList;

public class TestHarness {
    public TestHarness(){

    }

    public void testMajor(){
        System.out.println("Creating new Major");
        Major major = new Major("Computer Science", "The study of computers and algorithmic processes, " +
                "including their principles, their hardware and software designs, their applications," +
                " and their impact on society",300,"IT");
        System.out.println("----------Name----------");
        System.out.println(major.getName());
        System.out.println("----------Description----------");
        System.out.println(major.getDescription());
        System.out.println("----------Credit Hours----------");
        System.out.println(major.getCreditHours());
        System.out.println("Modifying the Major");
        major.setName("Computer Sciences");
        major.setDescription("The study of computers and algorithmic processes");
        System.out.println(major.toString());

    }

    public void testInterest(){
        System.out.println("Creating new Interests");
        Interest interest = new Interest("Application Development", "The process of planning, designing, creating, " +
                "testing, and deploying a software application to perform various business operations", "Coding");
        System.out.println("----------Name----------");
        System.out.println(interest.getName());
        System.out.println("----------Description----------");
        System.out.println(interest.getDescription());
        System.out.println("Modifying the Major");
        interest.setName("Application Developments");
        interest.setDescription("The process of developing apps");
        System.out.println(interest.toString());
    }

    public void testClassHierarchy(){
        ArrayList<User> users = new ArrayList<User>();
        Major major = new Major("Cyber", "Security for internet", 30, "IT");
        ArrayList<Major> majors = new ArrayList<Major>();majors.add(major);
        Skill skill = new Skill("Java", "Coding",majors,null,null,"John");
        ArrayList<Skill> skills = new ArrayList<Skill>();skills.add(skill);
        Recommendation rec = new Recommendation("First",majors,null);
        rec.setSkills(skills);
        ArrayList<Recommendation> recs = new ArrayList<Recommendation>();recs.add(rec);
        User user = new StudentUser("Sri",2026, SchoolType.Undergraduate,"PSU",recs);
        User user1 = new ExpertUser("John", "Microsoft", 20,skills);
        users.add(user);
        users.add(user1);
        for(User user2 : users){
            System.out.println(user2.getType()+ "("+user2.printQuestions() +") Original");
            user2.support("What is the name of the student?","Sri",skill);
            System.out.println(user2.getType()+"("+user2.printQuestions() +") Modified");
        }
    }

    public void testInterface(){
        /*
        Creates all the foundational parameters needed to create functioning transactions
         */
        Major major = new Major("Cyber", "Security for internet", 30, "IT");
        ArrayList<Major> majors = new ArrayList<Major>();majors.add(major);
        Interest interest = new Interest("Programming","Computer Language","IT");
        ArrayList<Interest> interest2 = new ArrayList<Interest>();interest2.add(interest);
        ArrayList<String> waysToLearn = new ArrayList<String>();waysToLearn.add("Zoom");
        Skill skill = new Skill("Java", "Coding",majors,interest2,waysToLearn,"John");
        ArrayList<Skill> skills = new ArrayList<Skill>();skills.add(skill);
        Recommendation rec = new Recommendation("First",majors,interest2);
        rec.setSkills(skills);
        ArrayList<Recommendation> recs = new ArrayList<Recommendation>();recs.add(rec);

        ArrayList<SkillManager> sManager = new ArrayList<SkillManager>();
        SkillController skillController = new SkillController();
        UserController userController = new UserController();
        User user = new StudentUser("Sri",2026, SchoolType.Undergraduate,"PSU",recs);
        ArrayList<User> users = new ArrayList<User>();users.add(user);
        userController.setUsers(users);

        skillController.setSkills(skills);
        sManager.add(skillController);
        sManager.add(userController);

        for(int i = 0; i < 3; i++){//SkillManager Interface only has three methods
            if(i==0){
                System.out.println("-".repeat(10)+"VIEW METHOD"+"-".repeat(10));
                System.out.println("BASIC VIEW OF SKILL AND USER. LESS IN DEPTH THAN TOSTRING BUT USED TO DISPLAY IMPORTANT INFORMATION.");
                System.out.println(sManager.get(0).getClass().getTypeName());
                System.out.println(sManager.get(0).view());
                System.out.println("\n"+sManager.get(1).getClass().getTypeName());
                System.out.println(sManager.get(1).view());
            }else if(i==1){
                System.out.println("-".repeat(10)+"UPDATE METHOD"+"-".repeat(10));
                System.out.println("UPDATED SKILL NAME AND LIST OF SKILLS IN USER.");
                System.out.println(sManager.get(0).getClass().getTypeName());
                sManager.get(0).update(1,"Name","Python");
                System.out.println(sManager.get(0).view());
                System.out.println("\n"+sManager.get(1).getClass().getTypeName());
                sManager.get(1).update(1,"Name","John");
                System.out.println(sManager.get(1).view());
            }else{
                System.out.println("-".repeat(10)+"REMOVE METHOD"+"-".repeat(10));
                System.out.println("REMOVED SKILL AND USER!!!");
                System.out.println(sManager.get(0).getClass().getTypeName());
                sManager.get(0).remove("Python");
                System.out.println(sManager.get(0).view());
                System.out.println("\n"+sManager.get(1).getClass().getTypeName());
                sManager.get(1).remove("John");
                System.out.println(sManager.get(1).view());
            }
        }//end if statement
    }
}
