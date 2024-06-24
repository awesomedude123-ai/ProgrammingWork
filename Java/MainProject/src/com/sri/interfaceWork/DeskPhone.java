package com.sri.interfaceWork;

public class DeskPhone implements ITelephone{
    private int myNumber;
    private boolean isRinging;

    public DeskPhone(int myNumber, boolean isRinging){
        this.myNumber=myNumber;
        this.isRinging=isRinging;
    }
    @Override
    public void power() {
        System.out.println("No action taken, this phone has no power button");
    }

    @Override
    public void dial(int number) {
        System.out.println("Now ringing: "+number);
    }

    @Override
    public void answer() {
        if(this.isRinging){
            System.out.println("Answering the desk phone");this.isRinging=false;
        }
    }

    @Override
    public boolean callPhone(int number) {
        if(number==this.myNumber){
            isRinging=true;
        }else{
            isRinging=false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
