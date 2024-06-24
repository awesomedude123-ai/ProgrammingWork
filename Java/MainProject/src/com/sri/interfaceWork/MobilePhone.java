package com.sri.interfaceWork;

public class MobilePhone implements ITelephone{

    private int myNumber;
    private boolean isRinging;
    private boolean isOn;

    public MobilePhone(int number){
        this.myNumber=number;
    }
    @Override
    public void power() {
        isOn=true;
        System.out.println("Phone now on");
    }

    @Override
    public void dial(int number) {
        if(isOn){
            System.out.println("Phone is dialing the number: "+number);
        }else{
            System.out.println("Phone is not on");
        }
    }

    @Override
    public void answer() {
        isRinging=false;
        System.out.println("Phone has stopped ringing");
    }

    @Override
    public boolean callPhone(int number) {
        if(number==this.myNumber){
            isRinging=true;
        }else{
            this.isRinging=false;
        }
        return this.isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
