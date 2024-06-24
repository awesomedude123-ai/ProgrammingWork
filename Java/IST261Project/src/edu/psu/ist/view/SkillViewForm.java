package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class SkillViewForm {
    private JPanel Panel;
    private JTextField nameValue;
    private JTextField descriptionValue;
    private JLabel waysToLearn;
    private JTextField waysToLearnValue;
    private JLabel expertName;
    private JTextField expertNameValue;
    private JButton quitButton;
    private JButton deleteButton;
    private JButton addButton;
    private JButton updateButton;
    private JButton previousButton;
    private JButton nextButton;
    private JTextArea textForSkill;
    private JTextArea instructionsArea;
    private JLabel Majors;
    private JLabel Interests;
    private JLabel Name;
    private JLabel Description;
    private JButton chooseMajorsButton;
    private JButton chooseInterestsButton1;
    private JTextArea listOfMajors;
    private JTextArea listOfInterests;
    private JButton ShowDetailList;


    public JPanel getPanel() {
        return Panel;
    }

    public void setPanel(JPanel panel) {
        Panel = panel;
    }

    public JLabel getDescription() {
        return Description;
    }

    public void setDescription(JLabel description) {
        Description = description;
    }

    public JLabel getMajors() {
        return Majors;
    }

    public void setMajors(JLabel majors) {
        Majors = majors;
    }

    public JLabel getInterests() {
        return Interests;
    }

    public void setInterests(JLabel interests) {
        Interests = interests;
    }

    public JLabel getName() {
        return Name;
    }

    public void setName(JLabel name) {
        Name = name;
    }

    public JTextField getNameValue() {
        return nameValue;
    }

    public void setNameValue(JTextField nameValue) {
        this.nameValue = nameValue;
    }

    public JTextField getDescriptionValue() {
        return descriptionValue;
    }

    public void setDescriptionValue(JTextField descriptionValue) {
        this.descriptionValue = descriptionValue;
    }

    public JLabel getWaysToLearn() {
        return waysToLearn;
    }

    public void setWaysToLearn(JLabel waysToLearn) {
        this.waysToLearn = waysToLearn;
    }

    public JTextField getWaysToLearnValue() {
        return waysToLearnValue;
    }

    public void setWaysToLearnValue(JTextField waysToLearnValue) {
        this.waysToLearnValue = waysToLearnValue;
    }

    public JLabel getExpertName() {
        return expertName;
    }

    public void setExpertName(JLabel expertName) {
        this.expertName = expertName;
    }

    public JTextField getExpertNameValue() {
        return expertNameValue;
    }

    public void setExpertNameValue(JTextField expertNameValue) {
        this.expertNameValue = expertNameValue;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public void setQuitButton(JButton quitButton) {
        this.quitButton = quitButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public void setPreviousButton(JButton previousButton) {
        this.previousButton = previousButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
    }

    public JTextArea getTextForSkill() {
        return textForSkill;
    }

    public void setTextForSkill(JTextArea textForSkill) {
        this.textForSkill = textForSkill;
    }

    public JTextArea getInstructionsArea() {
        return instructionsArea;
    }

    public void setInstructionsArea(JTextArea instructionsArea) {
        this.instructionsArea = instructionsArea;
    }

    public JButton getChooseMajorsButton() {
        return chooseMajorsButton;
    }

    public void setChooseMajorsButton(JButton chooseMajorsButton) {
        this.chooseMajorsButton = chooseMajorsButton;
    }

    public JButton getChooseInterestsButton1() {
        return chooseInterestsButton1;
    }

    public void setChooseInterestsButton1(JButton chooseInterestsButton1) {
        this.chooseInterestsButton1 = chooseInterestsButton1;
    }

    public JTextArea getListOfMajors() {
        return listOfMajors;
    }

    public void setListOfMajors(JTextArea listOfMajors) {
        this.listOfMajors = listOfMajors;
    }

    public JTextArea getListOfInterests() {
        return listOfInterests;
    }

    public void setListOfInterests(JTextArea listOfInterests) {
        this.listOfInterests = listOfInterests;
    }

    public JButton getShowDetailList() {
        return ShowDetailList;
    }

    public void setShowDetailList(JButton showDetailList) {
        ShowDetailList = showDetailList;
    }



    public void setUIDesign() {
        this.getName().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getTextForSkill().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getWaysToLearn().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getExpertName().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getMajors().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getInterests().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getInstructionsArea().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getDescription().setFont(new Font("Times New Roman",Font.ITALIC,14));

        this.getWaysToLearnValue().setFont(new Font("Times New Roman",Font.ITALIC,14));

        this.getNameValue().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getDescriptionValue().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getExpertNameValue().setFont(new Font("Times New Roman",Font.ITALIC,14));

        this.getListOfInterests().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getListOfMajors().setFont(new Font("Times New Roman",Font.ITALIC,14));

        this.getUpdateButton().setBackground(Color.CYAN);
        this.getUpdateButton().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getQuitButton().setBackground(Color.CYAN);
        this.getQuitButton().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getPreviousButton().setBackground(Color.CYAN);
        this.getPreviousButton().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getNextButton().setBackground(Color.CYAN);
        this.getNextButton().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getAddButton().setBackground(Color.CYAN);
        this.getAddButton().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getDeleteButton().setBackground(Color.CYAN);
        this.getDeleteButton().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getChooseMajorsButton().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getChooseInterestsButton1().setFont(new Font("Times New Roman",Font.ITALIC,14));
        this.getShowDetailList().setFont(new Font("Times New Roman",Font.ITALIC,14));

        this.getName().setForeground(Color.CYAN);
        this.getDescription().setForeground(Color.CYAN);
        this.getMajors().setForeground(Color.CYAN);
        this.getInterests().setForeground(Color.CYAN);
        this.getWaysToLearn().setForeground(Color.CYAN);
        this.getExpertName().setForeground(Color.CYAN);

        this.getInstructionsArea().setBackground(Color.BLACK);
        this.getInstructionsArea().setForeground(Color.CYAN);
        this.getTextForSkill().setBackground(Color.BLACK);
        this.getTextForSkill().setForeground(Color.CYAN);

    }//end method

}
