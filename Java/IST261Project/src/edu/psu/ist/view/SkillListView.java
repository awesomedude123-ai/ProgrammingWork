package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class SkillListView extends JFrame {
    public final SkillListViewForm form;

    public SkillListView(){
        this.form = new SkillListViewForm();
        JPanel panel = this.form.getPanel();

        this.setContentPane(panel);
        this.pack();
        this.setTitle("Skills List");
        this.setSize(800,800);
        panel.setForeground(Color.CYAN);
        panel.setBackground(Color.BLACK);
        this.validate();
        this.repaint();
        this.setFont(new Font("Times New Roman", Font.ITALIC,14));
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.form.getScrollPane().setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
}
