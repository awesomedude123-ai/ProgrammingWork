package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class SkillView extends JFrame{
    public final SkillViewForm form;

    public SkillView(){
        this.form = new SkillViewForm();
        JPanel panel = this.form.getPanel();

        this.setContentPane(panel);
        this.pack();

        this.setTitle("Skill View");
        this.setSize(800, 800);
        panel.setFont(Font.getFont("Times New Roman"));
        panel.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.CYAN);
        this.form.setUIDesign();
        this.validate();
        this.repaint();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }


}
