package edu.psu.ist.view;

import javax.swing.*;

public class SkillListViewForm {
    private JPanel Panel;
    private JTable tableValues;
    private JButton quitButton;
    private JButton newButton;
    private JButton showDetailsButton;
    private JScrollPane scrollPane;
    private JButton backToUserButton;


    public JPanel getPanel() {
        return Panel;
    }

    public void setPanel(JPanel panel) {
        Panel = panel;
    }

    public JTable getTableValues() {
        return tableValues;
    }

    public void setTableValues(JTable tableValues) {
        this.tableValues = tableValues;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public void setQuitButton(JButton quitButton) {
        this.quitButton = quitButton;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public void setNewButton(JButton newButton) {
        this.newButton = newButton;
    }

    public JButton getShowDetailsButton() {
        return showDetailsButton;
    }

    public void setShowDetailsButton(JButton showDetailsButton) {
        this.showDetailsButton = showDetailsButton;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JButton getBackToUserButton() {
        return backToUserButton;
    }

    public void setBackToUserButton(JButton backToUserButton) {
        this.backToUserButton = backToUserButton;
    }
}
