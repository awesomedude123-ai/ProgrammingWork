package com.sriwork.challenges;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary){
        this.real+=real;this.imaginary+=imaginary;
    }

    public void add(ComplexNumber cn){
        this.real+=cn.real;this.imaginary+=cn.imaginary;
    }

    public void subtract(double real,double imaginary){
        this.real+=real;this.imaginary+=imaginary;
    }
    public void subtract(ComplexNumber cn){
        this.real-=cn.real;this.imaginary-=cn.imaginary;
    }

}
