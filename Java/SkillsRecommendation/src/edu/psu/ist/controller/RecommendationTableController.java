package edu.psu.ist.controller;

import edu.psu.ist.model.Interest;
import edu.psu.ist.model.Major;
import edu.psu.ist.model.Recommendation;
import edu.psu.ist.model.RecommendationTableModel;
import edu.psu.ist.view.RecommendationListView;
import edu.psu.ist.view.RecommendationView;

import javax.swing.*;
import java.util.ArrayList;

public class RecommendationTableController {
    public final RecommendationListView view;
    public final RecommendationTableModel model;

    private SkillController skillController;

    public final RecommendationController recommendationController;

    private StudentUserController studentUserController;

    private ArrayList<Recommendation> recommendations;

    public RecommendationTableController(RecommendationListView view, RecommendationTableModel model, StudentUserController studentUserController) {
        this.view = view;
        this.model = model;
        this.studentUserController = studentUserController;
        if(this.studentUserController.getCurrentUser() == null){
            this.recommendations=new ArrayList<>();
        }else{
            recommendations=this.studentUserController.getCurrentUser().getRecommendations();
        }
        this.view.form.getRecommendationListTable().setModel(this.model);
        MajorController majorController = new MajorController();
        majorController.setMajors(populateMajors());
        InterestController interestController = new InterestController();
        interestController.setInterests(populateInterest());
        this.recommendationController = new RecommendationController(new RecommendationView(), majorController, interestController, this.skillController,this);

        recommendationController.view.validate();recommendationController.view.repaint();

        this.view.form.getNewButton().addActionListener(x -> {
            this.recommendationController.setRecommendationList(this.recommendations);
            if(this.recommendationController.getRecommendationList().size() == 0){
                this.recommendationController.view.form.getTextForRecommendation().setText("No Recommendations in list.");
            }else{
                this.recommendationController.view.form.getTextForRecommendation().setText(this.recommendationController.getRecommendationList().get(0).toString()+"\nCurrent Index: 1");
                RecommendationController.setIndex(1);
            }
            this.view.setVisible(false);
            recommendationController.view.setVisible(true);
        });

        this.view.form.getQuitButton().addActionListener(x -> {
            System.exit(1);
        });

        this.view.form.getShowDetailsButton().addActionListener(x -> {
            int value = this.view.form.getRecommendationListTable().getSelectedRow();
            if(value<0){
                JOptionPane.showMessageDialog(this.view, "No Row Selected", "No Row Selected", JOptionPane.INFORMATION_MESSAGE);
            }else{
                Recommendation rec = this.model.getRecommendation(value);
                this.recommendationController.view.form.getNameValue().setText(rec.getName());
                String majors = "";
                for(int i=0;i<rec.getMajors().size();i++){
                    if(i==rec.getMajors().size()-1){
                        majors=majors+rec.getMajors().get(i).getName();
                    }else{
                        majors=majors+rec.getMajors().get(i).getName()+"\n";
                    }
                }
                String interests = "";
                for(int i=0;i<rec.getInterests().size();i++){
                    if(i==rec.getInterests().size()-1){
                        interests=interests+rec.getInterests().get(i).getName();
                    }else{
                        interests=interests+rec.getInterests().get(i).getName()+"\n";
                    }
                }
                this.recommendationController.setRecommendationList(this.recommendations);
                this.recommendationController.view.form.getMajorTextArea().setText(majors);
                this.recommendationController.view.form.getInterestTextArea().setText(interests);
                this.recommendationController.view.form.getTextForRecommendation().setText(rec.toString()+"\nCurrent Index: "+(value+1));
                RecommendationController.setIndex(value+1);
                this.view.setVisible(false);
                this.recommendationController.view.setVisible(true);
            }
        });

        this.view.form.getBackToUserButton().addActionListener(x -> {
            this.studentUserController.getCurrentUser().setRecommendations(this.recommendations);
            this.view.setVisible(false);
            this.studentUserController.view.setVisible(true);
        });
    }

    public SkillController getSkillController() {
        return this.skillController;
    }

    public void setSkillController(SkillController skillController) {
        this.skillController = skillController;
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

    public RecommendationController getRecommendationController() {
        return recommendationController;
    }

    public ArrayList<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(ArrayList<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }
}
