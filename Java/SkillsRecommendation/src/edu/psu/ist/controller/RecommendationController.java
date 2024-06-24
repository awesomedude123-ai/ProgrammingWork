package edu.psu.ist.controller;

import edu.psu.ist.model.Interest;
import edu.psu.ist.model.Major;
import edu.psu.ist.model.Recommendation;
import edu.psu.ist.model.Skill;
import edu.psu.ist.view.InterestListView;
import edu.psu.ist.view.MajorListView;
import edu.psu.ist.view.RecommendationView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecommendationController {

    public final RecommendationView view;

    private MajorController majorController;

    private InterestController interestController;

    private SkillController skillController;
    private ArrayList<Recommendation> recommendationList;

    private RecFilter filterType;

    private static int index = 0;

    private RecommendationTableController recommendationTableController;

    private String filterText;

    public RecommendationController(){
        recommendationList = new ArrayList<Recommendation>();
        view = new RecommendationView();
        filterType=null;
        filterText=null;
    }

    public RecommendationController(RecommendationView view, MajorController majorController, InterestController interestController, SkillController skillController, RecommendationTableController recommendationTableController){
        this.view = view;
        this.majorController = majorController;
        this.interestController = interestController;
        this.skillController = skillController;
        MajorListView majorListView = new MajorListView();
        majorListView.form.getMajorList().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        InterestListView interestListView = new InterestListView();
        interestListView.form.getInterestList().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        recommendationList = new ArrayList<>();
        this.recommendationTableController = recommendationTableController;

        this.view.form.getTextForRecommendation().setLineWrap(true);
        this.view.form.getTextForRecommendation().setWrapStyleWord(true);
        this.view.form.getInstructionArea().setLineWrap(true);
        this.view.form.getInstructionArea().setWrapStyleWord(true);

        this.view.form.getTextForRecommendation().setText("No recommendations in the list");

        this.view.form.getInstructionArea().setText("Instructions\n" +
                "This is a simple view being used to create, modify, delete, view the recommendations. \n" +
                "While the real implementation may be different slightly,\n" +
                "this is the general idea of how it works.\n\n" +
                "To use the add button, you need to enter in values for each criterion. \n" +
                "If the recommendation is not present, then the recommendation will be added.\n" +
                "If it is, the new recommendation will not be added.\n\n" +
                "To use the delete button, simply enter the name of the recommendation you wish to delete. \n" +
                "If it is present, then it will delete it from the list.\n\n" +
                "To use the modify button, simply enter the name of the recommendation you wish to modify \n" +
                "and enter in one of the criteria. \n" +
                "If recommendation is present, then change will be made\n" +
                "i.e. Name Rec 1 Major Computer Science\n\n" +
                "Next button will simply move forward in the list and loop around the list if it is at the end.\n\n" +
                "Previous button will simply move backward in the last and loop around the list if it at the beginning.\n\n" +
                "The text area below will display your actions.\n" +
                "i.e. Adding a new recommendation will display the new recommendation, deleting the recommendation will display the last recommendation in the list, \n" +
                "updating will display the modified recommendation, etc");

        this.view.form.getAddButton().addActionListener(x -> {
            if(this.view.form.getNameValue().getText().isEmpty()){
                JOptionPane.showMessageDialog(this.view, "Need to provide name for list","Name Value Missing", JOptionPane.INFORMATION_MESSAGE);
            }else if(this.view.form.getMajorTextArea().getText().isEmpty() && this.view.form.getInterestTextArea().getText().isEmpty()){
                JOptionPane.showMessageDialog(this.view,"Need to provide a major and/or interest","Major and/or interest missing",JOptionPane.INFORMATION_MESSAGE);
            }else{
                String name = this.view.form.getNameValue().getText();
                boolean isThere = false;
                for(Recommendation rec : this.recommendationList){
                    if(rec.getName().equals(name)){
                        JOptionPane.showMessageDialog(this.view, "Recommendation with Name already exists", "Recommendation Already Exists", JOptionPane.INFORMATION_MESSAGE);
                        isThere = true;
                        break;
                    }
                }

                if(!isThere) {
                    ArrayList<Major> majors = new ArrayList<>();
                    for(String majorName: Arrays.asList(this.view.form.getMajorTextArea().getText().split("\n"))){
                        for(Major major : this.majorController.getMajors()){
                            if(major.getName().equals(majorName)){
                                majors.add(major);break;
                            }
                        }
                    }
                    ArrayList<Interest> interests = new ArrayList<>();
                    for(String interestName : Arrays.asList(this.view.form.getInterestTextArea().getText().split("\n"))){
                        for(Interest interest : this.interestController.getInterests()){
                            if(interest.getName().equals(interestName)){
                                interests.add(interest);break;
                            }
                        }
                    }
                    Recommendation rec = createList(name,majors,interests);index++;
                    this.recommendationTableController.setRecommendations(this.recommendationList);
                    this.view.form.getNameValue().setText("");
                    this.view.form.getInterestTextArea().setText("");
                    this.view.form.getMajorTextArea().setText("");
                    this.view.form.getTextForRecommendation().setText(rec.toString() + "\nCurrent Index: "+index);
                    this.recommendationTableController.model.setRecommendations(this.recommendationList);
                    this.recommendationTableController.model.fireTableRowsInserted(this.recommendationList.size()-1,this.recommendationList.size());
                }
            }//end if statement
        });

        this.view.form.getUpdateButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(this.view,"No Name Entered", "No Name Value", JOptionPane.INFORMATION_MESSAGE);
            }else{
                Recommendation newRec = null;
                int indexHere = 0;
                for(Recommendation recommendation : this.recommendationList){
                    if(recommendation.getName().equals(name)){
                        newRec=recommendation;break;
                    }
                    indexHere++;
                }
                if(newRec==null){
                    JOptionPane.showMessageDialog(this.view,"There is no Recommendation List with the Name you entered","No List Found",JOptionPane.ERROR_MESSAGE);
                }else{
                    ArrayList<String> majorNames = new ArrayList<>(Arrays.asList(this.view.form.getMajorTextArea().getText().split("\n")));
                    ArrayList<Major> majorList = new ArrayList<>();
                    for(String majorName : majorNames){
                        for(Major major : this.majorController.getMajors()){
                            if(major.getName().equals(majorName) && !majorList.contains(major)){
                                majorList.add(major);
                            }//end if statement
                        }//end for loop
                    }//end for loop
                    ArrayList<String> interestNames = new ArrayList<>(Arrays.asList(this.view.form.getInterestTextArea().getText().split("\n")));
                    ArrayList<Interest> interestList = new ArrayList<>();
                    for(String interestName : interestNames){
                        for(Interest interest : this.interestController.getInterests()){
                            if(interest.getName().equals(interestName) && !interestList.contains(interest)){
                                interestList.add(interest);
                            }//end if statement
                        }//end for loop
                    }//end for loop
                    Recommendation rec1 = createList(name,majorList,interestList);
                    this.recommendationList.remove(rec1);
                    this.recommendationList.set(indexHere,rec1);
                    this.recommendationTableController.setRecommendations(this.recommendationList);
                    this.view.form.getNameValue().setText("");
                    this.view.form.getInterestTextArea().setText("");
                    this.view.form.getMajorTextArea().setText("");
                    this.view.form.getTextForRecommendation().setText(rec1.toString() + "\nCurrent Index: "+(indexHere+1));
                    index=indexHere+1;
                    this.recommendationTableController.model.setRecommendations(this.recommendationList);
                    this.recommendationTableController.model.fireTableRowsUpdated(indexHere,indexHere+1);
                }//end if else statement

            }//end if else statement
        });

        this.view.form.getDeleteButton().addActionListener(x -> {
            String name = this.view.form.getNameValue().getText();
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(this.view,"No Name Value Entered", "No Name Value", JOptionPane.INFORMATION_MESSAGE);
            }else{
                int indexHere = -1;boolean isFound = false;
                for(Recommendation recs : this.recommendationList){
                    indexHere++;
                    if(recs.getName().equals(name)){
                        isFound=true;break;
                    }//end if statement
                }//end for loop
                if(isFound==true){
                    this.recommendationList.remove(indexHere);
                    this.view.form.getNameValue().setText("");
                    this.view.form.getMajorTextArea().setText("");
                    this.view.form.getInterestTextArea().setText("");
                    index=indexHere--;
                    if(index==-1){
                        this.view.form.getTextForRecommendation().setText("No recommendations in the list");
                    }else{
                        this.view.form.getTextForRecommendation().setText(this.recommendationList.get(index).toString()+"\nCurrent Index: "+index);
                    }//end if else statement
                    this.recommendationTableController.setRecommendations(this.recommendationList);
                    this.recommendationTableController.model.setRecommendations(this.recommendationList);
                    this.recommendationTableController.model.fireTableRowsDeleted(indexHere,indexHere+1);
                }else{
                    JOptionPane.showMessageDialog(this.view,"No Recommendation List Found with the Name", "No Recommendation List Found", JOptionPane.INFORMATION_MESSAGE);
                }//end if else statement
            }//end if else statement
        });

        this.view.form.getQuitButton().addActionListener(x -> {
            System.exit(1);
        });

        this.view.form.getNextButton().addActionListener(x -> {
            index++;
            if(index>=this.recommendationList.size()){
                index=1;
            }
            this.view.form.getTextForRecommendation().setText(this.recommendationList.get(index-1).toString()+"\nCurrent Index: "+index);
        });

        this.view.form.getPreviousButton().addActionListener(x -> {
            index--;
            if(index<=-1){
                index = this.recommendationList.size();
            }
            this.view.form.getTextForRecommendation().setText(this.recommendationList.get(index-1).toString()+"\nCurrent Index: "+index);
        });

        this.view.form.getChooseMajorsButton().addActionListener(x -> {
            this.view.setVisible(false);
            majorListView.setVisible(true);
            String[] majorListNames = new String[this.majorController.getMajors().size()];
            for(int i=0;i<this.majorController.getMajors().size();i++){
                majorListNames[i]=this.majorController.getMajors().get(i).getName();
            }//end for loop
            majorListView.form.getMajorList().setListData(majorListNames);
        });


        this.view.form.getChooseInterestButton().addActionListener(x -> {
            this.view.setVisible(false);
            interestListView.setVisible(true);
            String[] interestListNames = new String[this.interestController.getInterests().size()];
            for(int i=0;i<this.interestController.getInterests().size();i++){
                interestListNames[i]=this.interestController.getInterests().get(i).getName();
            }//end for loop
            interestListView.form.getInterestList().setListData(interestListNames);
        });

        majorListView.form.getCancelButton().addActionListener(x -> {
            majorListView.setVisible(false);
            this.view.setVisible(true);
        });

        interestListView.form.getCancelButton().addActionListener(x -> {
            interestListView.setVisible(false);
            this.view.setVisible(true);
        });

        majorListView.form.getApplyButton().addActionListener(x -> {
            List majorList = majorListView.form.getMajorList().getSelectedValuesList();
            String value = "";
            for(int i=0;i<majorList.size();i++){
                if(i==majorList.size()-1){
                    value+=majorList.get(i);
                }else{
                    value = value + majorList.get(i) + "\n";
                }//end if else statement
            }//end for loop
            this.view.form.getMajorTextArea().setText(value);
            this.view.setVisible(true);
            majorListView.setVisible(false);
        });

        interestListView.form.getApplyButton().addActionListener(x -> {
            List interestList = interestListView.form.getInterestList().getSelectedValuesList();
            String value = "";
            for(int i=0;i<interestList.size();i++){
                if(i==interestList.size()-1){
                    value+=interestList.get(i);
                }else{
                    value = value + interestList.get(i) + "\n";
                }//end if else statement
            }//end for loop
            this.view.form.getInterestTextArea().setText(value);
            this.view.setVisible(true);
            interestListView.setVisible(false);
        });

        this.view.form.getShowDetailListButton().addActionListener(x -> {
            this.view.setVisible(false);
            this.recommendationTableController.view.form.getRecommendationListTable().setModel(this.recommendationTableController.model);
            this.recommendationTableController.view.setVisible(true);
        });
    }//end constructor



    public ArrayList<Recommendation> getList() {
        return recommendationList;
    }

    public void setList(ArrayList<Recommendation> list) {
        this.recommendationList = list;
    }

    public RecFilter getFilterType() {
        return filterType;
    }

    public void setFilterType(RecFilter filterType) {
        this.filterType = filterType;
    }

    public String getFilterText() {
        return filterText;
    }

    public void setFilterText(String filterText) {
        this.filterText = filterText;
    }

    public SkillController getSkillController() {
        return skillController;
    }

    public void setSkillController(SkillController skillController) {
        this.skillController = skillController;
    }

    public ArrayList<Recommendation> getRecommendationList() {
        return recommendationList;
    }

    public void setRecommendationList(ArrayList<Recommendation> recommendationList) {
        this.recommendationList = recommendationList;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        RecommendationController.index = index;
    }

    public Recommendation createList(String name, ArrayList<Major> majors, ArrayList<Interest> interests){
        ArrayList<Skill> skills = new ArrayList<Skill>();
        if(majors != null){
            for(Major major : majors){
                for(Skill skill : this.skillController.getSkills()) {
                    if(skill.getMajors().contains(major) && !skills.contains(skill)){
                        skills.add(skill);
                    }//end if statment
                }//end for loop
            }//end for loop
        }//end if statement
        if(interests != null){
            for(Interest interest : interests){
                for(Skill skill : this.skillController.getSkills()){
                    if(skill.getInterests().contains(interest) && !skills.contains(skill)){
                        skills.add(skill);
                    }//end if statemnet
                }//end for loop
            }//end for loop
        }//end if statement
        Recommendation rec = new Recommendation(name, majors, interests);
        rec.setSkills(skills);
        recommendationList.add(rec);
        return rec;
    }

    public boolean remove(Recommendation list) {
        if(this.recommendationList.contains(list)){
            this.recommendationList.remove(list);
            return true;
        }else{
            return false;
        }

    }

    public String toString() {
        //FilterType and FilterText are not needed in the ToString method so I did not add them.
        String answer="";
        for(Recommendation list : this.recommendationList){
            answer=answer+list.toString() + "-".repeat(20);
        }
        return answer;
    }

}//end class
