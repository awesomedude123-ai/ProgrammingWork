package Controller;

import Model.QueueModel;
import View.QueueView;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class QueueController {
    private QueueModel model;
    private QueueView view;

    private Stack<QueueModel<Integer>> undoStack= new Stack<>();
    public QueueController(QueueView view, QueueModel model){
        this.view=view;
        this.model=model;

        this.view.form.getQueueContentsLabel().setText(this.model.toString());
        if(this.undoStack.size()==0){
            this.view.form.getUndoButton().setEnabled(false);
        }
        this.view.form.getEnqueueButton().addActionListener(x -> {
            try{
                int value = Integer.parseInt(this.view.form.getEnqueueTextField().getText().toString());
                undoStack.push(undoMethod(this.model));
                this.view.form.getUndoButton().setEnabled(true);
                this.model.enqueue(value);
                this.view.form.getQueueContentsLabel().setText(this.model.toString());
                this.view.form.getFrontLabelValue().setText(this.model.peekFront().toString());
                this.view.form.getRearLabelValue().setText(this.model.peekRear().toString());
                this.view.form.getEnqueueTextField().setText("");
            }catch (Exception e){
                this.view.form.getEnqueueTextField().setText("");
                JOptionPane.showMessageDialog(this.view,"Invalid Input" ,"Error" ,JOptionPane.ERROR_MESSAGE);
            }//end try/catch statement

        });

        this.view.form.getDequeueButton().addActionListener(x -> {
            undoStack.push(undoMethod(this.model));
            this.view.form.getUndoButton().setEnabled(true);
            this.model.dequeue();
            this.view.form.getQueueContentsLabel().setText(this.model.toString());
            if(this.model.getWrappedQueue().size()==0){
                this.view.form.getFrontLabelValue().setText("");
                this.view.form.getRearLabelValue().setText("");
            }else {
                this.view.form.getFrontLabelValue().setText(this.model.peekFront().toString());
                this.view.form.getRearLabelValue().setText(this.model.peekRear().toString());
            }//end if else statement
            this.view.form.getEnqueueTextField().setText("");
        });

        this.view.form.getSaveButton().addActionListener(x -> {
            try {
                FileWriter fw = new FileWriter("contents.txt");
                Queue sub = this.model.getWrappedQueue();
                String value="";
                for(Object i:sub){
                    value+=i+",";
                }//end for loop
                fw.append(value.substring(0,value.length()-1));
                fw.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this.view,"No File Found", "Error", JOptionPane.ERROR_MESSAGE);
            }//end try/catch statement
        });

        this.view.form.getClearLoadButton().addActionListener(x -> {
            try {
                File file=new File("contents.txt");
                Scanner scanner = new Scanner(file);
                this.model.clear();
                String[] array=scanner.nextLine().split(",");
                for(String i: array){
                    this.model.enqueue(Integer.parseInt(i));
                }
                this.view.form.getQueueContentsLabel().setText(this.model.toString());
                this.view.form.getRearLabelValue().setText(this.model.peekRear().toString());
                this.view.form.getFrontLabelValue().setText(this.model.peekFront().toString());
                scanner.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this.view,"No File Found", "Error", JOptionPane.ERROR_MESSAGE);
            }

        });

        this.view.form.getUndoButton().addActionListener(x -> {
            this.model.clear();
            QueueModel<Integer> sub = undoStack.pop();

            for(Object i: sub.getWrappedQueue()){
                this.model.enqueue(i);
            }//end for loop
            if(this.undoStack.size()==0){
                this.view.form.getUndoButton().setEnabled(false);
                this.view.form.getRearLabelValue().setText("");
                this.view.form.getFrontLabelValue().setText("");
            }else{
                this.view.form.getRearLabelValue().setText(this.model.peekRear().toString());
                this.view.form.getFrontLabelValue().setText(this.model.peekFront().toString());
            }
            this.view.form.getQueueContentsLabel().setText(this.model.toString());

        });
    }//end constructor

    private QueueModel<Integer> undoMethod(QueueModel<Integer> model1){
        QueueModel<Integer> sub = new QueueModel<>();
        for(Object i: model1.getWrappedQueue()){
            sub.enqueue((int)i);
        }
        return sub;
    }//end
}
