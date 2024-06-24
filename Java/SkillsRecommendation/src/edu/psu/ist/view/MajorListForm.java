package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class MajorListForm {
    private JPanel Panel;
    private JScrollPane scrollPanel;
    private JList majorList;
    private JButton cancelButton;
    private JButton applyButton;
    private JPanel panelButtons;

    public JPanel getPanel() {
        return Panel;
    }

    public void setPanel(JPanel panel) {
        Panel = panel;
    }

    public JScrollPane getScrollPanel() {
        return scrollPanel;
    }

    public void setScrollPanel(JScrollPane scrollPanel) {
        this.scrollPanel = scrollPanel;
    }

    public JList getMajorList() {
        return majorList;
    }

    public void setMajorList(JList majorList) {
        this.majorList = majorList;
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

    public JPanel getPanelButtons() {
        return panelButtons;
    }

    public void setPanelButtons(JPanel panelButtons) {
        this.panelButtons = panelButtons;
    }

    public void setUIDesign(){
        this.getMajorList().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        this.getMajorList().setForeground(Color.CYAN);
        this.getMajorList().setBackground(Color.BLACK);

        this.getApplyButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getApplyButton().setForeground(Color.CYAN);
        this.getApplyButton().setBackground(Color.BLACK);

        this.getCancelButton().setFont(new Font("Times New Roman", Font.ITALIC, 14));
        //this.getCancelButton().setForeground(Color.CYAN);
        this.getCancelButton().setBackground(Color.BLACK);
    }
}
