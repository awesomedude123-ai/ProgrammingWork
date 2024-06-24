package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class UserListView extends JFrame{
    public final UserListViewForm form;

    public UserListView(){
        this.form = new UserListViewForm();

        JPanel panel = this.form.getPanel();
        this.setContentPane(panel);
        this.pack();
        this.setTitle("User List");
        this.setSize(800,800);
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.CYAN);
        this.repaint();
        this.validate();
        this.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.form.getScrollPane().setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
}
