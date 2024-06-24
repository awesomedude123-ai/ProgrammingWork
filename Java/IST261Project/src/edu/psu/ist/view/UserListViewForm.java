package edu.psu.ist.view;

import javax.swing.*;

public class UserListViewForm {
    private JPanel panel;
    private JScrollPane scrollPane;
    private JTable userTable;
    private JButton showDetailsButton;
    private JButton addStudentButton;
    private JButton addExpertButton;
    private JButton quitButton;

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTable getUserTable() {
        return userTable;
    }

    public void setUserTable(JTable userTable) {
        this.userTable = userTable;
    }

    public JButton getShowDetailsButton() {
        return showDetailsButton;
    }

    public void setShowDetailsButton(JButton showDetailsButton) {
        this.showDetailsButton = showDetailsButton;
    }

    public JButton getAddStudentButton() {
        return addStudentButton;
    }

    public void setAddStudentButton(JButton addStudentButton) {
        this.addStudentButton = addStudentButton;
    }

    public JButton getAddExpertButton() {
        return addExpertButton;
    }

    public void setAddExpertButton(JButton addExpertButton) {
        this.addExpertButton = addExpertButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public void setQuitButton(JButton quitButton) {
        this.quitButton = quitButton;
    }


}
