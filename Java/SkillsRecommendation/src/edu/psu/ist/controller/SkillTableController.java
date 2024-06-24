package edu.psu.ist.controller;

import edu.psu.ist.model.*;
import edu.psu.ist.view.SkillListView;
import edu.psu.ist.view.SkillView;

import javax.swing.*;
import java.util.ArrayList;

public class SkillTableController {
    public final SkillTableModel model;
    public final SkillListView view;

    private ExpertUserController expertUserController;

    private SkillController skillController;

    public ArrayList<Skill> mainSkillList = new ArrayList<Skill>();

    private ArrayList<Skill> currentUserList;

    public SkillTableController(SkillTableModel model, SkillListView view, ExpertUserController expertUserController) {
        this.model = model;
        this.view = view;

        this.expertUserController = expertUserController;
        this.view.form.getTableValues().setModel(this.model);

        this.currentUserList =(ArrayList<Skill>) this.model.getSkills();
        MajorController majorController = new MajorController();
        majorController.setMajors(populateMajors());
        InterestController interestController = new InterestController();
        interestController.setInterests(populateInterest());
        SkillView skillView = new SkillView();
        skillController = new SkillController(skillView, majorController,interestController, this);
        skillView.revalidate();
        skillView.repaint();

        this.view.form.getTableValues().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        this.view.form.getQuitButton().addActionListener(x -> {
            System.exit(1);
        });

        this.view.form.getNewButton().addActionListener(x -> {
            this.view.setVisible(false);
            this.skillController.view.setVisible(true);
            this.skillController.view.form.getExpertNameLabel().setText(this.expertUserController.getCurrentUser().getName());
            this.currentUserList.clear();
            for(Skill skill : this.mainSkillList){
                if(skill.getExpertName().equals(this.expertUserController.getCurrentUser().getName())){
                    this.currentUserList.add(skill);
                }
            }
            this.skillController.setSkills(this.currentUserList);
            if(this.currentUserList.isEmpty()) {
                this.skillController.view.form.getTextForSkill().setText("No skills in the List");
            }else{
                this.skillController.view.form.getTextForSkill().setText(this.currentUserList.get(0).toString());
            }

        });

        this.view.form.getShowDetailsButton().addActionListener(x -> {
            int index = this.view.form.getTableValues().getSelectedRow();
            if(index<0){
                JOptionPane.showMessageDialog(this.view, "No row selected!", "Unselected row", JOptionPane.ERROR_MESSAGE);
            }else{
                Skill skill = this.model.getSkill(index);
                this.view.setVisible(false);
                skillController.view.setVisible(true);
                skillController.view.form.getNameValue().setText(skill.getName());
                skillController.view.form.getDescriptionValue().setText(skill.getDescription());
                String major = "";
                for(int i=0; i<skill.getMajors().size();i++){
                    if(i==skill.getMajors().size()-1){
                        major+=skill.getMajors().get(i).getName();
                    }else{
                        major=major + skill.getMajors().get(i).getName()+"\n";
                    }
                }//end for loop
                skillController.view.form.getListOfMajors().setText(major);
                String interest = "";
                for(int i=0; i<skill.getInterests().size();i++){
                    if(i==skill.getInterests().size()-1){
                        interest+=skill.getInterests().get(i).getName();
                    }else{
                        interest = interest + skill.getInterests().get(i).getName() + "\n";
                    }
                }//end for loop
                skillController.view.form.getListOfInterests().setText(interest);
                String waysToLearn = "";
                for(int i=0;i<skill.getWaysToLearn().size();i++){
                    if(i==skill.getWaysToLearn().size()-1){
                        waysToLearn+=skill.getWaysToLearn().get(i);
                    }else{
                        waysToLearn = waysToLearn + skill.getWaysToLearn().get(i) + ",";
                    }
                }//end for loop
                skillController.view.form.getWaysToLearnValue().setText(waysToLearn);
                skillController.view.form.getExpertNameLabel().setText(expertUserController.getCurrentUser().getName());
                skillController.view.form.getTextForSkill().setText(skill.toString() + "\nCurrent Index: "+(this.model.getSkills().indexOf(skill)+1));
                skillController.setIndex(this.model.getSkills().indexOf(skill));
            }

        });

        this.view.form.getBackToUserButton().addActionListener(x -> {
            this.view.setVisible(false);
            ExpertUser expert = this.expertUserController.getCurrentUser();
            expert.setSkills((ArrayList<Skill>) this.model.getSkills());
            this.expertUserController.setCurrentUser(expert);
            this.expertUserController.view.setVisible(true);
        });

    }//end controller

    public ArrayList<Skill> getCurrentUserList() {
        return this.currentUserList;
    }

    public void setCurrentUserList(ArrayList<Skill> currentUserList) {
        this.currentUserList = currentUserList;
    }

    private static ArrayList<Major> populateMajors(){
        ArrayList<Major> majors = new ArrayList<Major>();
        majors.add(new Major("Data Science","Science of Data", 130, "IT"));
        majors.add(new Major("Computer Science", "Science of Computer", 130, "IT"));
        majors.add(new Major("Cyber-security", "Online Security", 130, "IT"));
        majors.add(new Major("Information Science", "Science of Information", 130, "IT"));
        return majors;
    }//end populateMajors

    private static ArrayList<Interest> populateInterest(){
        ArrayList<Interest> interests = new ArrayList<Interest>();
        interests.add(new Interest("Programming","Coding","Technical"));
        interests.add(new Interest("Writing","Writing Reports","Non-Technical"));
        interests.add(new Interest("Cloud","Cloud Architecture","Technical"));
        interests.add(new Interest("Science","Learning about chem, phys, and bio","Non-Technical"));
        return interests;
    }


}
