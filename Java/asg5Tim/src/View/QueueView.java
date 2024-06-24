package View;

import javax.swing.*;

public class QueueView extends JFrame {
    public final QueueModelForm form;
    public QueueView(){
        this.form=new QueueModelForm();
        JPanel content=form.getMyPanel();
        this.setContentPane(content);
        this.pack();
        this.setSize(400,400);
        this.setTitle("Queue");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//end constructor
}//end class
