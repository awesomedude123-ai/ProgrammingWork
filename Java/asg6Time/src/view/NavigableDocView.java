package view;

import javax.swing.*;

public class NavigableDocView extends JFrame {
    final public NavigableDocForm form;

    public NavigableDocView(){
        this.form=new NavigableDocForm();
        JPanel content=form.getPanel();
        this.setContentPane(content);
        this.pack();
        this.setTitle("Document Gator'");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
