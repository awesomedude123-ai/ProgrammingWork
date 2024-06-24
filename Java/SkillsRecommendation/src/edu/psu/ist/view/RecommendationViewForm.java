package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class RecommendationViewForm {
    private JPanel Panel;
    private JLabel nameLabel;
    private JTextField nameValue;
    private JLabel majorLabel;
    private JButton chooseMajorsButton;
    private JTextArea majorTextArea;
    private JButton chooseInterestButton;
    private JTextArea interestTextArea;
    private JTextArea instructionArea;
    private JButton deleteButton;
    private JButton addButton;
    private JButton quitButton;
    private JButton updateButton;
    private JButton previousButton;
    private JButton nextButton;
    private JButton showDetailListButton;
    private JTextArea textForRecommendation;
    private JLabel interestsLabel;


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

    public JLabel getMajorLabel() {
        return majorLabel;
    }

    public void setMajorLabel(JLabel majorLabel) {
        this.majorLabel = majorLabel;
    }

    public JButton getChooseMajorsButton() {
        return chooseMajorsButton;
    }

    public void setChooseMajorsButton(JButton chooseButton) {
        this.chooseMajorsButton = chooseButton;
    }

    public JTextArea getMajorTextArea() {
        return majorTextArea;
    }

    public void setMajorTextArea(JTextArea majorTextArea) {
        this.majorTextArea = majorTextArea;
    }

    public JButton getChooseInterestButton() {
        return chooseInterestButton;
    }

    public void setChooseInterestButton(JButton chooseButton1) {
        this.chooseInterestButton = chooseButton1;
    }

    public JTextArea getInterestTextArea() {
        return interestTextArea;
    }

    public void setInterestTextArea(JTextArea interestTextArea) {
        this.interestTextArea = interestTextArea;
    }

    public JTextArea getInstructionArea() {
        return instructionArea;
    }

    public void setInstructionArea(JTextArea instructionArea) {
        this.instructionArea = instructionArea;
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

    public JButton getQuitButton() {
        return quitButton;
    }

    public void setQuitButton(JButton quitButton) {
        this.quitButton = quitButton;
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

    public JButton getShowDetailListButton() {
        return showDetailListButton;
    }

    public void setShowDetailListButton(JButton showDetailListButton) {
        this.showDetailListButton = showDetailListButton;
    }

    public JTextArea getTextForRecommendation() {
        return textForRecommendation;
    }

    public void setTextForRecommendation(JTextArea textForRecommendation) {
        this.textForRecommendation = textForRecommendation;
    }

    public JLabel getInterestsLabel() {
        return interestsLabel;
    }

    public void setInterestsLabel(JLabel interestsLabel) {
        this.interestsLabel = interestsLabel;
    }

    public void setUIDesign(){
        this.getNameLabel().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        this.getNameLabel().setForeground(Color.CYAN);

        this.getInterestsLabel().setFont(new Font("Times New Roman", Font.ITALIC,14));
        this.getInterestsLabel().setForeground(Color.CYAN);

        this.getMajorLabel().setFont(new Font("Times New Roman", Font.ITALIC,14));
        this.getMajorLabel().setForeground(Color.CYAN);

        this.getTextForRecommendation().setFont(new Font("Times New Roman", Font.ITALIC,14));
        this.getTextForRecommendation().setForeground(Color.CYAN);
        this.getTextForRecommendation().setBackground(Color.BLACK);

        this.getInstructionArea().setFont(new Font("Times New Roman", Font.ITALIC,14));
        this.getInstructionArea().setForeground(Color.CYAN);
        this.getInstructionArea().setBackground(Color.BLACK);

        this.getPreviousButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getPreviousButton().setForeground(Color.CYAN);
        this.getPreviousButton().setBackground(Color.BLACK);

        this.getNextButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getNextButton().setForeground(Color.CYAN);
        this.getNextButton().setBackground(Color.BLACK);

        this.getQuitButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getQuitButton().setForeground(Color.CYAN);
        this.getQuitButton().setBackground(Color.BLACK);

        this.getAddButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getAddButton().setForeground(Color.CYAN);
        this.getAddButton().setBackground(Color.BLACK);

        this.getUpdateButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getUpdateButton().setForeground(Color.CYAN);
        this.getUpdateButton().setBackground(Color.BLACK);

        this.getDeleteButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getDeleteButton().setForeground(Color.CYAN);
        this.getDeleteButton().setBackground(Color.BLACK);

        this.getChooseInterestButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getChooseInterestButton().setForeground(Color.CYAN);
        this.getChooseInterestButton().setBackground(Color.BLACK);

        this.getChooseMajorsButton().setFont(new Font("Times New Roman", Font.ITALIC,14));
        //this.getChooseMajorsButton().setForeground(Color.CYAN);
        this.getChooseMajorsButton().setBackground(Color.BLACK);

        this.getShowDetailListButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getShowDetailListButton().setForeground(Color.CYAN);
        this.getShowDetailListButton().setBackground(Color.BLACK);

        this.getMajorTextArea().setFont(new Font("Times New Roman", Font.ITALIC, 14));

        this.getInterestTextArea().setFont(new Font("Times New Roman", Font.ITALIC,14));

        this.getNameValue().setFont(new Font("Times New Roman", Font.ITALIC,14));

    }
}//end class
