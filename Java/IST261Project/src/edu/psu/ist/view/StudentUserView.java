package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class StudentUserView extends JFrame {
    public final StudentUserViewForm form;

    public StudentUserView(){
        this.form = new StudentUserViewForm();
        JPanel panel = this.form.getPanel();

        this.setContentPane(panel);
        this.pack();

        this.setTitle("Student User View");
        this.setSize(800,800);
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.CYAN);
        this.repaint();
        this.validate();
        this.form.setUIDesign();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
}
