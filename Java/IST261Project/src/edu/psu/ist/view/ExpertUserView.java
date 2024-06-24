package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class ExpertUserView extends JFrame {
    public final ExpertUserViewForm form;

    public ExpertUserView(){
        this.form = new ExpertUserViewForm();

        JPanel panel = this.form.getPanel();

        this.setContentPane(panel);
        this.pack();

        this.setSize(800,800);
        this.setTitle("Expert User View");
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.CYAN);
        this.repaint();
        this.validate();
        this.form.setUIDesign();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
}
