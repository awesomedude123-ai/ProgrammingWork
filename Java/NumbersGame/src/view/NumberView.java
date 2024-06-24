package view;

import javax.swing.*;

public class NumberView extends JFrame {
    public final GameForm form = new GameForm();

    public NumberView(){
        JPanel content=this.form.getPanel();
        this.setContentPane(content);
        this.pack();
        this.setTitle("Numbers Game");
        this.setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
