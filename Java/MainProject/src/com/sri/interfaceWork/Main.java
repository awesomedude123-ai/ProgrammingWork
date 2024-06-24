package com.sri.interfaceWork;

public class Main {
    public static void main(String[] args) {
        ITelephone timsPhone=new DeskPhone(123456,false);
        timsPhone.power();
        timsPhone.callPhone(12345);
        timsPhone.isRinging();

        ITelephone srisPhone=new MobilePhone(123456);
        srisPhone.isRinging();
        srisPhone.power();
        srisPhone.dial(123456);
        srisPhone.isRinging();
    }
}
