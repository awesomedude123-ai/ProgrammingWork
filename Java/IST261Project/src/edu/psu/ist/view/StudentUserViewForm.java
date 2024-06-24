package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class StudentUserViewForm {
    private JPanel Panel;
    private JLabel nameLabel;
    private JTextField nameValue;
    private JLabel yearLabel;
    private JComboBox yearComboBox;
    private JLabel schoolTypeLabel;
    private JComboBox schoolTypeComboBox;
    private JLabel schoolNameLabel;
    private JTextField schoolNameValue;
    private JButton quitButton;
    private JButton deleteButton;
    private JButton addButton;
    private JButton updateButton;
    private JTextArea instructionsTextArea;
    private JButton previousButton;
    private JButton nextButton;
    private JButton showRecommendationListButton;
    private JButton showUserListButton;
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

    public JLabel getYearLabel() {
        return yearLabel;
    }

    public void setYearLabel(JLabel yearLabel) {
        this.yearLabel = yearLabel;
    }

    public JComboBox getYearComboBox() {
        return yearComboBox;
    }

    public void setYearComboBox(JComboBox yearComboBox) {
        this.yearComboBox = yearComboBox;
    }

    public JLabel getSchoolTypeLabel() {
        return schoolTypeLabel;
    }

    public void setSchoolTypeLabel(JLabel schoolTypeLabel) {
        this.schoolTypeLabel = schoolTypeLabel;
    }

    public JComboBox getSchoolTypeComboBox() {
        return schoolTypeComboBox;
    }

    public void setSchoolTypeComboBox(JComboBox schoolTypeComboBox) {
        this.schoolTypeComboBox = schoolTypeComboBox;
    }

    public JLabel getSchoolNameLabel() {
        return schoolNameLabel;
    }

    public void setSchoolNameLabel(JLabel schoolNameLabel) {
        this.schoolNameLabel = schoolNameLabel;
    }

    public JTextField getSchoolNameValue() {
        return schoolNameValue;
    }

    public void setSchoolNameValue(JTextField schoolNameValue) {
        this.schoolNameValue = schoolNameValue;
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

    public JTextArea getInstructionsTextArea() {
        return instructionsTextArea;
    }

    public void setInstructionsTextArea(JTextArea instructionsTextArea) {
        this.instructionsTextArea = instructionsTextArea;
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

    public JButton getShowRecommendationListButton() {
        return showRecommendationListButton;
    }

    public void setShowRecommendationListButton(JButton showRecommendationListButton) {
        this.showRecommendationListButton = showRecommendationListButton;
    }

    public JButton getShowUserListButton() {
        return showUserListButton;
    }

    public void setShowUserListButton(JButton showUserListButton) {
        this.showUserListButton = showUserListButton;
    }

    public JTextArea getUserTextArea() {
        return userTextArea;
    }

    public void setUserTextArea(JTextArea userTextArea) {
        this.userTextArea = userTextArea;
    }

    public void setUIDesign(){
        this.getNameLabel().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        this.getYearLabel().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        this.getSchoolNameLabel().setFont(new Font("Times New Roman", Font.ITALIC,14));
        this.getSchoolTypeLabel().setFont(new Font("Times New Roman", Font.ITALIC,14));
        this.getUserTextArea().setFont(new Font("Times New Roman", Font.ITALIC,14));
        this.getInstructionsTextArea().setFont(new Font("Times New Roman", Font.ITALIC,14));

        this.getNameLabel().setForeground(Color.CYAN);
        this.getYearLabel().setForeground(Color.CYAN);
        this.getSchoolNameLabel().setForeground(Color.CYAN);
        this.getSchoolTypeLabel().setForeground(Color.CYAN);
        this.getUserTextArea().setForeground(Color.CYAN);
        this.getInstructionsTextArea().setForeground(Color.CYAN);

        this.getUserTextArea().setBackground(Color.BLACK);
        this.getInstructionsTextArea().setBackground(Color.BLACK);

        this.getQuitButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getQuitButton().setForeground(Color.CYAN);
        this.getQuitButton().setBackground(Color.BLACK);

        this.getNextButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getNextButton().setForeground(Color.CYAN);
        this.getNextButton().setBackground(Color.BLACK);

        this.getPreviousButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getPreviousButton().setForeground(Color.CYAN);
        this.getPreviousButton().setBackground(Color.BLACK);

        this.getAddButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getAddButton().setForeground(Color.CYAN);
        this.getAddButton().setBackground(Color.BLACK);

        this.getDeleteButton().setFont(new Font("Times New Roman", Font.ITALIC,14));
        //this.getDeleteButton().setForeground(Color.CYAN);
        this.getDeleteButton().setBackground(Color.BLACK);

        this.getUpdateButton().setFont(new Font("Times New Roman", Font.ITALIC,14));
        //this.getUpdateButton().setForeground(Color.CYAN);
        this.getUpdateButton().setBackground(Color.BLACK);

        this.getShowUserListButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getShowUserListButton().setForeground(Color.CYAN);
        this.getShowUserListButton().setBackground(Color.BLACK);

        this.getShowRecommendationListButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getShowRecommendationListButton().setForeground(Color.CYAN);
        this.getShowRecommendationListButton().setBackground(Color.BLACK);

    }
}
