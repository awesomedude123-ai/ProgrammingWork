package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class InterestListForm {
    private JPanel Panel;
    private JList interestList;
    private JScrollPane scrollPane;
    private JButton cancelButton;
    private JButton applyButton;
    private JPanel buttonPanel;

    public JPanel getPanel() {
        return Panel;
    }

    public void setPanel(JPanel panel) {
        Panel = panel;
    }

    public JList getInterestList() {
        return interestList;
    }

    public void setInterestList(JList interestList) {
        this.interestList = interestList;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JButton getApplyButton() {
        return applyButton;
    }

    public void setApplyButton(JButton applyButton) {
        this.applyButton = applyButton;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public void setUIDesign(){
        this.getInterestList().setFont(new Font("Times New Roman", Font.ITALIC,14));
        this.getInterestList().setForeground(Color.CYAN);
        this.getInterestList().setBackground(Color.BLACK);

        this.getApplyButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getApplyButton().setForeground(Color.CYAN);
        this.getApplyButton().setBackground(Color.BLACK);

        this.getCancelButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getCancelButton().setForeground(Color.CYAN);
        this.getCancelButton().setBackground(Color.BLACK);
    }
}
