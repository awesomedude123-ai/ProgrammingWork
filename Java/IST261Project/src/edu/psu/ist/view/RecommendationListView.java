package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class RecommendationListView extends JFrame{
    public final RecommendationListViewForm form;

    public RecommendationListView(){
        this.form = new RecommendationListViewForm();
        JPanel panel = this.form.getPanel();
        this.setContentPane(panel);
        this.pack();

        this.setTitle("Recommendations List View");
        this.setSize(800,800);
        panel.setForeground(Color.CYAN);
        panel.setBackground(Color.BLACK);
        this.repaint();
        this.validate();
        this.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.form.getScrollPane().setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
}
