package controller;

import model.NavigableDocModel;
import model.Pair;
import model.Side;
import view.NavigableDocView;

import javax.swing.*;

public class NavigableDocController {
    private NavigableDocModel model;
    private NavigableDocView view;

    public NavigableDocController(NavigableDocModel model, NavigableDocView view){
        this.model=model;
        this.view=view;

        this.view.form.getListLabel().setText(this.model.toString());
        this.view.form.getAddButton().addActionListener(x -> {
            if(this.view.form.getValueBox().getText().isEmpty()){
                JOptionPane.showMessageDialog(this.view,"There is nothing in text box to add","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                String value=this.view.form.getValueBox().getText().toString();
                this.model.insertNewItemRt(value);
                this.view.form.getValueBox().setText("");
                this.view.form.getListLabel().setText(this.model.toString());
            }//end if statement

        });

        this.view.form.getForwardButton().addActionListener(x ->{
            try{
                this.model.forward();
                this.view.form.getListLabel().setText(this.model.toString());
            }catch (Exception e){
                JOptionPane.showMessageDialog(this.view,"Nothing on the right side", "Error", JOptionPane.ERROR_MESSAGE);
            }//end try catch statement


        });

        this.view.form.getResetButton().addActionListener(x -> {
            this.model.reset();
            this.view.form.getListLabel().setText(this.model.toString());
        });

        this.view.form.getContainsButton().addActionListener(x -> {
            if(this.view.form.getValueBox().getText().isEmpty()){
                JOptionPane.showMessageDialog(this.view,"There is nothing in text box to check for","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                String value = this.view.form.getValueBox().getText().toString();
                Pair pair= this.model.contains(value);
                this.view.form.getValueBox().setText("");
                if(pair.first== Side.NONE){
                    JOptionPane.showMessageDialog(this.view,"Item: "+value+" cannot be found!");
                }else if(pair.first==Side.BOTH){
                    JOptionPane.showMessageDialog(this.view,"Item: "+value+" was found on both sides. Its left index: "+pair.second);
                }else if(pair.first==Side.LEFT){
                    JOptionPane.showMessageDialog(this.view,"Item: "+value+" was found on the left side at index: "+pair.second);
                }else{
                    JOptionPane.showMessageDialog(this.view,"Item: "+value+" was found on the right side at index: "+pair.second);
                }//end if else statement
            }

        });
    }
}
