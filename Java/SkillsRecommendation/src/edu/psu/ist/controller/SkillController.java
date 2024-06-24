package edu.psu.ist.controller;

import edu.psu.ist.model.Interest;
import edu.psu.ist.model.Major;
import edu.psu.ist.model.Skill;
import edu.psu.ist.view.InterestListView;
import edu.psu.ist.view.MajorListView;
import edu.psu.ist.view.SkillView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkillController implements SkillManager{
    private ArrayList<Skill> skills;

    private SkillsFilter filterType;

    private String filterText;

    private MajorController majorController = new MajorController();

    private InterestController interestController = new InterestController();

    private int index = 0;

    public final SkillView view;

    private MajorListView majorView;

    private InterestListView interestView;

    private SkillTableController skillTableController;

    public SkillController(){
        skills = new ArrayList<Skill>();
        filterType=null;
        filterText=null;
        view=new SkillView();
    }

    public SkillController(SkillView view, MajorController majorController, InterestController interestController, SkillTableController skillTableController){
        this.view = view;
        skills = new ArrayList<Skill>();
        this.majorController = majorController;
        this.interestController = interestController;
        this.skillTableController = skillTableController;
        this.majorView=new MajorListView();
        this.interestView = new InterestListView();
        filterType=null;
        filterText=null;
        this.skills.addAll(this.skillTableController.model.getSkills());

        this.view.form.getTextForSkill().setWrapStyleWord(true);
        this.view.form.getTextForSkill().setLineWrap(true);
        this.view.form.getInstructionsArea().setLineWrap(true);
        this.view.form.getInstructionsArea().setWrapStyleWord(true);
        this.view.form.getInstructionsArea().setText("Instructions\n" +
                "This is a simple view being used to create, modify, delete, view the skills. \n" +
                "While the real implementation may be different slightly,\n" +
                "this is the general idea of how it works.\n\n" +
                "To use the add button, you need to enter in values for each criterion. \n" +
                "If the skill is not present, then the skill will be added.\n" +
                "If it is, the new skill will not be added.\n\n" +
                "To use the delete button, simply enter the name of the skill you wish to delete. \n" +
                "If it is present, then it will delete it from the list.\n\n" +
                "To use the modify button, simply enter the name of the skill you wish to modify \n" +
                "and enter in one of the criteria. \n" +
                "If skill is present, then change will be made\n" +
                "i.e. Name Computer Science Description New description\n\n" +
                "Next button will simply move forward in the list and loop around the list if it is at the end.\n\n" +
                "Previous button will simply move backward in the last and loop around the list if it at the beginning.\n\n" +
                "The text area below will display your actions.\n" +
                "i.e. Adding a new skill will display the new skill, deleting the skill will display the last skill in the list, \n" +
                "updating will display the modified skill, etc\n\n" +
                "When entering the Ways to Learn information, please split the methodologies with ','.\n" +
                " i.e. Youtube,ChatGPT,Online courses");

        this.view.form.getTextForSkill().setText("There are no skills");
        String[] nm = new String[majorController.getMajors().size()];
        int y=0;
        for(Major major : majorController.getMajors()){
            nm[y]=major.getName();y++;
        }
        //HERE this.view.form.getListOfMajors().setListData(new Vector(Arrays.asList(nm)));
        nm = new String[interestController.getInterests().size()];
        y=0;
        for(Interest interest : interestController.getInterests()){
            nm[y]=interest.getName(); y++;
        }
        //HERE this.view.form.getListOfInterests().setListData(new Vector(Arrays.asList(nm)));

       /** this.view.form.getListOfMajors().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.view.form.getListOfInterests().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.view.form.getListOfInterests().setLayoutOrientation(JList.VERTICAL);
        this.view.form.getListOfMajors().setLayoutOrientation(JList.VERTICAL);**/

        this.view.form.getAddButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            String description = this.view.form.getDescriptionValue().getText();
            ArrayList<String> majors = new ArrayList<>(Arrays.asList(this.view.form.getListOfMajors().getText().split("\n")));
            ArrayList<String> interests = new ArrayList<>(Arrays.asList(this.view.form.getListOfInterests().getText().split("\n")));
            ArrayList<String> waysToLearn = new ArrayList<>(Arrays.asList(this.view.form.getWaysToLearnValue().getText().split(",")));
            String expertName = this.view.form.getExpertNameLabel().getText();
            if(name.isEmpty() || description.isEmpty() || majors.get(0).isEmpty() || interests.get(0).isEmpty() || waysToLearn.get(0).isEmpty() || expertName.isEmpty()) {
                JOptionPane.showMessageDialog(this.view, "You are missing some of the information, please fill it and add.", "Missing an input" ,JOptionPane.ERROR_MESSAGE);
            }else{
                boolean isContains = false;
                for(Skill skill: this.skillTableController.mainSkillList){
                    if(skill.getName().equalsIgnoreCase(name)) {
                        isContains = true;
                    }
                }
                if(!isContains){
                    add(name, description,majors,interests,waysToLearn,expertName);
                    this.skillTableController.setCurrentUserList(this.skills);

                    this.view.form.getTextForSkill().setText(skills.get(skills.size()-1).toString() + "\nCurrent Index: "+skills.size());
                    this.skillTableController.model.setSkills(this.skills);
                    this.skillTableController.model.fireTableRowsInserted(this.skills.size()-1, this.skills.size());
                    this.skillTableController.mainSkillList.add(skills.get(skills.size()-1));
                }else{
                    JOptionPane.showMessageDialog(this.view,"Skill Exists", "Please enter a new skill",JOptionPane.INFORMATION_MESSAGE);
                }

            }
            this.view.form.getNameValue().setText("");
            this.view.form.getDescriptionValue().setText("");
            this.view.form.getWaysToLearnValue().setText("");
            this.view.form.getListOfMajors().setText("");
            this.view.form.getListOfInterests().setText("");
        });

        this.view.form.getDeleteButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            Skill skill1 = null;
            int i = 0;
            for(Skill skill : skills){
                if(skill.getName().equalsIgnoreCase(name)){
                    skill1 = skill;
                    skills.remove(skill);
                    break;
                }
                i++;
            }
            if(remove(name)==false){
                JOptionPane.showMessageDialog(this.view, "The skill you entered is not in the list. Please enter a skill that is in the list.", "Skill Not Found", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(skills.isEmpty()){
                    this.view.form.getTextForSkill().setText("There are no skills");
                }else{
                    this.skillTableController.setCurrentUserList(this.skills);
                    this.view.form.getTextForSkill().setText(skills.get(skills.size()-1).toString()+ "\nCurrent Index: "+skills.size());
                    this.skillTableController.mainSkillList.remove(this.skillTableController.mainSkillList.indexOf(skill1));
                    this.skillTableController.model.setSkills(this.skills);
                    this.skillTableController.model.fireTableRowsDeleted(i, i+1);
                }//end if else statement
            }
            this.view.form.getNameValue().setText("");
            this.view.form.getDescriptionValue().setText("");
            this.view.form.getWaysToLearnValue().setText("");
            this.view.form.getListOfMajors().setText("");
            this.view.form.getListOfInterests().setText("");
        });

        this.view.form.getNextButton().addActionListener(x -> {
            if(skills.isEmpty()){
                JOptionPane.showMessageDialog(this.view,"There is no skills in the list!","No skills available", JOptionPane.INFORMATION_MESSAGE);
            }else{
                index++;
                if(index == skills.size()) {
                    index=0;
                }//end if statement
                this.view.form.getTextForSkill().setText(skills.get(index).toString()+ "\nCurrent Index: "+(index+1));
            }

        });

        this.view.form.getPreviousButton().addActionListener(x -> {
            if(skills.isEmpty()) {
                JOptionPane.showMessageDialog(this.view,"There is no skills in the list", "No skills available", JOptionPane.INFORMATION_MESSAGE);
            }else{
                index--;
                if(index<0){
                    index=skills.size()-1;
                }//end if statement
                this.view.form.getTextForSkill().setText(skills.get(index).toString()+ "\nCurrent Index: "+(index+1));
            }

        });

        this.view.form.getQuitButton().addActionListener(x -> {
            System.exit(0);
        });

        this.view.form.getUpdateButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            if(name.isEmpty()) {
                JOptionPane.showMessageDialog(this.view, "There is no name value entered.","Name is required",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                int index = -1;
                Skill skill = null;
                for(int i=0;i<this.skills.size();i++){
                    if(this.skills.get(i).getName().equalsIgnoreCase(name)){
                        index=i;
                        skill = this.skills.get(i);
                    }//end if statement
                    if(index!=-1)
                        break;
                }//end for loop
                if(index==-1){
                    JOptionPane.showMessageDialog(this.view, "The skill name you entered is not listed.", "Skill not found",JOptionPane.ERROR_MESSAGE);
                }else{
                    boolean isWorking = false;
                    String param = "";
                    String value = "";
                    //JOptionPane.showMessageDialog(this.view,"Need to enter the updated value","Error",JOptionPane.ERROR_MESSAGE);

                    if(!this.view.form.getWaysToLearnValue().getText().isEmpty()){
                        ArrayList<String> waysToLearn = new ArrayList<String>(Arrays.asList(this.view.form.getWaysToLearnValue().getText().split(",")));
                        value = "";
                        for(int i=0; i<waysToLearn.size(); i++){
                            if(i<waysToLearn.size()-1){
                                value = value + waysToLearn.get(i) + ", ";
                            }else{
                                value = value + waysToLearn.get(i);
                            }
                        }
                        isWorking = true; param = "Ways to Learn";
                        update(index, param, value);
                    }//end if statement

                    if(!this.view.form.getListOfInterests().getText().isEmpty()){
                        List<String> interestNames = new ArrayList<>(Arrays.asList(this.view.form.getListOfInterests().getText().split("\n")));
                        value="";
                        for(int i=0;i<interestNames.size();i++){
                            if(i<interestNames.size()-1){
                                value = value + interestNames.get(i) + ", ";
                            }else{
                                value = value + interestNames.get(i);
                            }
                        }
                        isWorking = true; param = "Interests";
                        update(index, param, value);
                    }//end if statement

                    if(!this.view.form.getListOfMajors().getText().isEmpty()){
                        value="";
                        List<String> majorNames = new ArrayList<>(Arrays.asList(this.view.form.getListOfMajors().getText().split("\n")));
                        for(int i =0; i<majorNames.size(); i++){
                            if(i<majorNames.size()-1){
                                value = value + majorNames.get(i) + ", ";
                            }else{
                                value = value + majorNames.get(i);
                            }
                        }
                        isWorking = true; param = "Majors";
                        update(index, param, value);
                    }//end if statement

                    if(!this.view.form.getDescriptionValue().getText().isEmpty()){
                        value = this.view.form.getDescriptionValue().getText();
                        isWorking = true; param = "Description";
                        update(index, param, value);
                    }//end if else

                    if(!isWorking){
                        JOptionPane.showMessageDialog(this.view, "There is no new value for any of the parameters", "No updated values", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        this.view.form.getTextForSkill().setText(skills.get(index).toString() + "\nCurrent Index: "+skills.size());
                        this.skillTableController.mainSkillList.set(this.skillTableController.mainSkillList.indexOf(skill),this.skills.get(index));
                        this.skillTableController.setCurrentUserList(this.skills);
                        this.skillTableController.model.setSkills(this.skills);
                        this.skillTableController.model.fireTableRowsUpdated(index, index+1);
                        this.view.form.getNameValue().setText("");
                        this.view.form.getDescriptionValue().setText("");
                        this.view.form.getWaysToLearnValue().setText("");
                        this.view.form.getListOfMajors().setText("");
                        this.view.form.getListOfInterests().setText("");
                    }
                }//end if statement
                }//end name if else statement

        });

        this.view.form.getChooseMajorsButton().addActionListener(x -> {
            String[] mn = new String[this.majorController.getMajors().size()];
            int i=0;
            for(Major major : this.majorController.getMajors()){
                mn[i]=major.getName();i++;
            }
            this.majorView.form.getMajorList().setListData(mn);
            this.view.setVisible(false);
            this.majorView.setVisible(true);
        });

        this.view.form.getChooseInterestsButton1().addActionListener(x -> {
            String[] mn = new String[this.interestController.getInterests().size()];
            int i = 0;
            for(Interest interest : this.interestController.getInterests()){
                mn[i] = interest.getName();i++;
            }
            this.interestView.form.getInterestList().setListData(mn);
            this.view.setVisible(false);
            this.interestView.setVisible(true);
        });

        //These next buttons are to be used when the panel is for the interest view and majors view
        this.interestView.form.getCancelButton().addActionListener(x -> {
            this.interestView.setVisible(false);
            this.view.setVisible(true);
        });

        this.majorView.form.getCancelButton().addActionListener(x -> {
            this.majorView.setVisible(false);
            this.view.setVisible(true);
        });

        this.interestView.form.getApplyButton().addActionListener(x -> {
            List interestName = this.interestView.form.getInterestList().getSelectedValuesList();
            String value = "";
            for(int i=0;i<interestName.size();i++){
                if(i==interestName.size()-1){
                    value = value + interestName.get(i);
                }else{
                    value = value + interestName.get(i) + "\n";
                }
            }//end for loop
            this.view.form.getListOfInterests().setText(value);
            this.interestView.setVisible(false);
            this.view.setVisible(true);
        });

        this.majorView.form.getApplyButton().addActionListener(x -> {
            List majorName = this.majorView.form.getMajorList().getSelectedValuesList();
            String value = "";
            for(int i=0;i<majorName.size();i++){
                if(i==majorName.size()-1){
                    value = value + majorName.get(i);
                }else{
                    value = value + majorName.get(i) + "\n";
                }//end if else statement
            }//end for loop
            this.view.form.getListOfMajors().setText(value);
            this.majorView.setVisible(false);
            this.view.setVisible(true);
        });

        this.view.form.getShowDetailList().addActionListener(x -> {
            this.view.setVisible(false);
            this.view.form.getNameValue().setText("");
            this.view.form.getDescriptionValue().setText("");
            this.view.form.getWaysToLearnValue().setText("");
            this.view.form.getListOfMajors().setText("");
            this.view.form.getListOfInterests().setText("");
            this.skillTableController.view.setVisible(true);
        });
    }//end controller

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public SkillsFilter getFilterType() {
        return filterType;
    }

    public void setFilterType(SkillsFilter filterType) {
        this.filterType = filterType;
    }

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }

    public ArrayList<Skill> filter(SkillsFilter filter, String filterText) {
        ArrayList<Skill> li = new ArrayList<>();
        switch (filter){
            case NAME -> {
                for(Skill skill : skills){
                    if(skill.getName().equalsIgnoreCase(filterText)){
                        li.add(skill);
                    }//end if statement
                }//end for loop
            }//end case NAME
            case MAJOR -> {
                for(Skill skill: skills){
                    for(Major major : skill.getMajors()){
                        if(major.getName().equalsIgnoreCase(filterText)){
                            li.add(skill);break;
                        }//end if statement
                    }//end for loop
                }//end for loop
            }//end case MAJOR
            case INTEREST -> {
                for(Skill skill: skills){
                    for(Interest interest: skill.getInterests()){
                        if(interest.getName().equalsIgnoreCase(filterText)){
                            li.add(skill);
                        }//end if statement
                    }//end for loop
                }//end for loop
            }//end case INTEREST
            case ID -> {
                for(Skill skill: skills){
                    if(skill.getId() == Integer.parseInt(filterText)){
                        li.add(skill);
                    }//end if statement
                }//end for loop
            }//end case ID

        }//end switch case statement
        return li;
    }

    public String toString() {
        //FilterType and FilterText are not needed in the ToString method so I did not add them.
        String answer = "";
        for(Skill skill : skills){
            answer = answer + skill.toString() + "-".repeat(20);
        }
        return answer;
    }

    public void add(String name, String description, ArrayList<String> majorName, ArrayList<String> interestNames, ArrayList<String> waysToLearn, String expertName){
        ArrayList<Major> majors = new ArrayList<>();
        for(String name1: majorName){
            for(Major major: majorController.getMajors()){
                if(major.getName().equalsIgnoreCase(name1)){
                    majors.add(major);
                    break;
                }
            }
        }//end for loop
        ArrayList<Interest> interests = new ArrayList<>();
        for(String name1: interestNames){
            for(Interest interest:interestController.getInterests()){
                if(interest.getName().equalsIgnoreCase(name1)){
                    interests.add(interest);
                    break;
                }
            }
        }
        Skill skill = new Skill(name,description,majors,interests,waysToLearn,expertName);
        skills.add(skill);
    }


    @Override
    public boolean remove(String name) { //Modified SkillManager Interface Method
        for(Skill skill : skills){
            if(skill.getName().equalsIgnoreCase(name)){
                skills.remove(skill);
                return true;
            }
        }
        return false;

    }//end remove method

    @Override
    public void update(int id, String param, String newValue) { //Modified SkillManager Interface Method
        Skill skill = skills.get(id);
        switch(param){
            case "Name" -> skill.setName(newValue);
            case "Description" -> skill.setDescription(newValue);
            case "Majors"->
            {
                ArrayList<Major> majors = new ArrayList<Major>();
                String[] majors1 = newValue.split(", ");
                for(String name : majors1){
                    for(Major maj : majorController.getMajors()){
                        if(maj.getName().equalsIgnoreCase(name)){
                            majors.add(maj);
                            break;
                        }
                    } // end for loop
                }//end for loop
                skill.setMajors(majors);
            }

            case "Interests" ->
            {
                ArrayList<Interest> interests = new ArrayList<Interest>();
                String[] interests1 = newValue.split(", ");
                for(String name : interests1){
                    for(Interest interest : interestController.getInterests()){
                        if(interest.getName().equalsIgnoreCase(name)){
                            interests.add(interest);
                            break;
                        }
                    }
                }//end for loop
                skill.setInterests(interests);
            }
            case "Ways to Learn" ->
            {
                ArrayList<String> waysToLearn = new ArrayList<>(Arrays.asList(newValue.split(", ")));
                skill.setWaysToLearn(waysToLearn);
            }
            case "Expert Name" -> skill.setExpertName(newValue);
        }//end switch case
        this.skills.set(id,skill);
    }//end method

    @Override
    public String view() { //Modified SkillManager Interface Method
        String value = "";
        for(Skill skill:skills){
            value=value+skill.toString()+"\n";
        }
        return value;
    }

    public void setIndex(int index) {
        this.index = index;
    }


}//end class
