package controller;

import model.NumbersModel;
import view.NumberView;

import javax.swing.*;

public class NumbersController {
    private NumbersModel model;
    private NumberView view;

    public NumbersController(NumbersModel model, NumberView view){
        this.model=model;
        this.view=view;
        int guesses=0;

        this.view.form.getScoreValue().setText(Integer.toString(this.model.getScore()));
        this.view.form.getGuessValue().setText("0");


        this.view.form.getGuessButton().addActionListener(x -> {
            if(this.view.form.getGuessField().getText().isBlank()){
                JOptionPane.showMessageDialog(this.view, "Text field is blank. Please enter a number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            int number = Integer.parseInt(this.view.form.getGuessField().getText().toString());
            int y = this.model.checkNumber(number);

            if(y==0){
                this.view.form.getScoreValue().setText(Integer.toString(this.model.getScore()));
                this.view.form.getGuessField().setText("");
                this.model.randomNumber();
                this.model.lowestGuesses(this.model.getCurrentGuess());
                this.view.form.getLowestGuessValue().setText(Integer.toString(this.model.getGuesses()));
                this.view.form.getGuessValue().setText("0");this.model.resetGuess();
                JOptionPane.showMessageDialog(this.view,"You got it right! The answer was "+number);
            }else if(y>0){
                this.model.wrong();this.view.form.getGuessValue().setText(Integer.toString(this.model.getCurrentGuess()));
                JOptionPane.showMessageDialog(this.view, "Your guessed number is larger than the right number");
            }else{
                this.model.wrong();this.view.form.getGuessValue().setText(Integer.toString(this.model.getCurrentGuess()));
                JOptionPane.showMessageDialog(this.view, "Your guessed number is smaller than the right number");
            }//end if else statement

        });


        this.view.form.getResetButton().addActionListener(x -> {
            this.model.reset();
            this.view.form.getGuessField().setText("");
            this.view.form.getLowestGuessValue().setText("0");
            this.view.form.getScoreValue().setText("0");
            this.view.form.getGuessValue().setText("0");
        });

        this.view.form.getRegenerateButton().addActionListener(x -> {
            this.model.randomNumber();
            this.view.form.getGuessField().setText("");
        });

        this.view.form.getInstructionsButton().addActionListener(x -> {
            String message = "A random number, between 0-100, will be generated and you have to guess the number.\nYour guesses will be notified if " +
                    "your guesses are too high or too low or correct.\nThe number of guesses taken will be recorded and your lowest guess mark" +
                    " will be recorded.\nHope you enjoy!";
            JOptionPane.showMessageDialog(this.view,message,"Instructions",JOptionPane.INFORMATION_MESSAGE);
        });



    }//end method
}//end public class
