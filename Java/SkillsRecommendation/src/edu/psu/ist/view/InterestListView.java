package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class InterestListView extends JFrame{

    public final InterestListForm form;

    public InterestListView(){
        this.form = new InterestListForm();
        JPanel panel = this.form.getPanel();

        this.setContentPane(panel);
        this.pack();
        this.setTitle("Interest List");
        this.setSize(500,500);
        panel.setForeground(Color.CYAN);
        panel.setBackground(Color.BLACK);
        this.validate();
        this.repaint();
        this.form.setUIDesign();
        this.form.getInterestList().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

}
