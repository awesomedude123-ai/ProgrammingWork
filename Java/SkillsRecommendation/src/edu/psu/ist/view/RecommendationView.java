package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class RecommendationView extends JFrame {
    public final RecommendationViewForm form;

    public RecommendationView(){
        form = new RecommendationViewForm();
        JPanel panel = form.getPanel();

        this.setContentPane(panel);
        this.pack();

        this.setTitle("Recommendation View");
        this.setSize(800,800);
        panel.setFont(new Font("Times New Roman", Font.ITALIC,14));
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.CYAN);
        this.validate();
        this.repaint();
        this.form.setUIDesign();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//end constructor
}//end class RecommendationView
