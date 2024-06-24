package com.sri.interfaceWork;
//Since the methods are being made in a class, the access modifiers are not needed since they need to be public if accessible by other classes
public interface ITelephone {
     void power();
     void dial(int number);
     void answer();
     boolean callPhone(int number);
     boolean isRinging();
}
