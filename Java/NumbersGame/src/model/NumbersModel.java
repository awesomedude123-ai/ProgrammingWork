package model;

public class NumbersModel {
    private int generatedNumber;
    private int score;

    private int guesses;

    private int currentGuess;

    public NumbersModel(){
        randomNumber();
        score=0;
        guesses=0;
        currentGuess=0;
    }

    public void randomNumber(){
        this.generatedNumber= (int)(Math.random()*100) - (int)(Math.random()*10);
    }//end method

    public int checkNumber(int number){
        if(number-generatedNumber==0){
            score++;
        }
        return number-generatedNumber; //if positive, guessed number is larger. if negative, guessed number is smaller
    }//end method

    public int getScore(){
        return this.score;
    }

    public void reset(){
        this.score=0;
        guesses=0;
        currentGuess=0;
        randomNumber();
    }

    public void lowestGuesses(int guesses){
        if(this.guesses==0 || this.guesses>guesses){
            this.guesses=guesses;
        }
    }

    public int getGuesses(){
        return this.guesses;
    }
    public void wrong(){
        this.currentGuess++;
    }
    public int getCurrentGuess(){
        return this.currentGuess;
    }

    public void resetGuess(){
        this.currentGuess=0;
    }

}//end public class
