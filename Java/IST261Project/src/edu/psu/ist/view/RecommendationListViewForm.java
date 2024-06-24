package edu.psu.ist.view;

import javax.swing.*;

public class RecommendationListViewForm {
    private JPanel Panel;
    private JScrollPane ScrollPane;
    private JTable recommendationListTable;
    private JButton showDetailsButton;
    private JButton newButton;
    private JButton quitButton;
    private JButton backToUserButton;


    public JPanel getPanel() {
        return Panel;
    }

    public void setPanel(JPanel panel) {
        Panel = panel;
    }

    public JScrollPane getScrollPane() {
        return ScrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        ScrollPane = scrollPane;
    }

    public JTable getRecommendationListTable() {
        return recommendationListTable;
    }

    public void setRecommendationListTable(JTable recommendationListTable) {
        this.recommendationListTable = recommendationListTable;
    }

    public JButton getShowDetailsButton() {
        return showDetailsButton;
    }

    public void setShowDetailsButton(JButton showDetailsButton) {
        this.showDetailsButton = showDetailsButton;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public void setNewButton(JButton newButton) {
        this.newButton = newButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public void setQuitButton(JButton quitButton) {
        this.quitButton = quitButton;
    }

    public JButton getBackToUserButton() {
        return backToUserButton;
    }

    public void setBackToUserButton(JButton backToUserButton) {
        this.backToUserButton = backToUserButton;
    }
}
