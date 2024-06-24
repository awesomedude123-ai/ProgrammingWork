package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class ExpertUserViewForm {
    private JPanel Panel;
    private JLabel nameLabel;
    private JTextField nameValue;
    private JLabel yearOfExperienceLabel;
    private JLabel companyLabel;
    private JTextArea instructionsTextArea;
    private JTextField companyValue;
    private JButton quitButton;
    private JButton deleteButton;
    private JButton addButton;
    private JButton updateButton;
    private JComboBox yearsOfExperienceValue;
    private JButton previousButton;
    private JButton nextButton;
    private JButton showUserListButton;
    private JButton showSkillListButton;
    private JTextArea userTextArea;

    public JPanel getPanel() {
        return Panel;
    }

    public void setPanel(JPanel panel) {
        Panel = panel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JTextField getNameValue() {
        return nameValue;
    }

    public void setNameValue(JTextField nameValue) {
        this.nameValue = nameValue;
    }

    public JLabel getYearOfExperienceLabel() {
        return yearOfExperienceLabel;
    }

    public void setYearOfExperienceLabel(JLabel yearOfExperienceLabel) {
        this.yearOfExperienceLabel = yearOfExperienceLabel;
    }

    public JLabel getCompanyLabel() {
        return companyLabel;
    }

    public void setCompanyLabel(JLabel companyLabel) {
        this.companyLabel = companyLabel;
    }

    public JTextArea getInstructionsTextArea() {
        return instructionsTextArea;
    }

    public void setInstructionsTextArea(JTextArea instructionsTextArea) {
        this.instructionsTextArea = instructionsTextArea;
    }

    public JTextField getCompanyValue() {
        return companyValue;
    }

    public void setCompanyValue(JTextField companyValue) {
        this.companyValue = companyValue;
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

    public JComboBox getYearsOfExperienceValue() {
        return yearsOfExperienceValue;
    }

    public void setYearsOfExperienceValue(JComboBox yearsOfExperienceValue) {
        this.yearsOfExperienceValue = yearsOfExperienceValue;
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

    public JButton getShowUserListButton() {
        return showUserListButton;
    }

    public void setShowUserListButton(JButton showUserListButton) {
        this.showUserListButton = showUserListButton;
    }

    public JButton getShowSkillListButton() {
        return showSkillListButton;
    }

    public void setShowSkillListButton(JButton showSkillListButton) {
        this.showSkillListButton = showSkillListButton;
    }

    public JTextArea getUserTextArea() {
        return userTextArea;
    }

    public void setUserTextArea(JTextArea userTextArea) {
        this.userTextArea = userTextArea;
    }

    public void setUIDesign(){
        this.getNameLabel().setFont(new Font("Times New Roman", Font.ITALIC,14));
        this.getNameLabel().setForeground(Color.CYAN);
        this.getNameLabel().setBackground(Color.BLACK);

        this.getCompanyLabel().setFont(new Font("Times New Roman", Font.ITALIC,14));
        this.getCompanyLabel().setForeground(Color.CYAN);
        this.getCompanyLabel().setBackground(Color.BLACK);

        this.getYearOfExperienceLabel().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        this.getYearOfExperienceLabel().setForeground(Color.CYAN);
        this.getYearOfExperienceLabel().setBackground(Color.BLACK);

        this.getUserTextArea().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        this.getUserTextArea().setForeground(Color.CYAN);
        this.getUserTextArea().setBackground(Color.BLACK);

        this.getInstructionsTextArea().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        this.getInstructionsTextArea().setForeground(Color.CYAN);
        this.getInstructionsTextArea().setBackground(Color.BLACK);

        this.getUpdateButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getUpdateButton().setForeground(Color.CYAN);
        this.getUpdateButton().setBackground(Color.BLACK);

        this.getDeleteButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getDeleteButton().setForeground(Color.CYAN);
        this.getDeleteButton().setBackground(Color.BLACK);

        this.getPreviousButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getPreviousButton().setForeground(Color.CYAN);
        this.getPreviousButton().setBackground(Color.BLACK);

        this.getNextButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getNextButton().setForeground(Color.CYAN);
        this.getNextButton().setBackground(Color.BLACK);

        this.getAddButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getAddButton().setForeground(Color.CYAN);
        this.getAddButton().setBackground(Color.BLACK);

        this.getQuitButton().setFont(new Font("Times New Roman", Font.ITALIC,14));
        //this.getQuitButton().setForeground(Color.CYAN);
        this.getQuitButton().setBackground(Color.BLACK);

        this.getShowUserListButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getShowUserListButton().setForeground(Color.CYAN);
        this.getShowUserListButton().setBackground(Color.BLACK);

        this.getShowSkillListButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getShowSkillListButton().setForeground(Color.CYAN);
        this.getShowSkillListButton().setBackground(Color.BLACK);
    }
}
