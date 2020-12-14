package com.mycompany.mathematics;

public class MyComplex {

    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {}

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real + "+" + imag +"i)";
    }

    public boolean isReal() {
        return imag == 0;
    }

    public boolean isImaginary() {
        return real == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyComplex) {
            return this.real == ((MyComplex) obj).real && this.imag == ((MyComplex) obj).imag;
        }
        return false;
    }

    public boolean equals(double real, double imag) {
        return (this.real == real) && (this.imag == imag);
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double argument() {
        double arg = Math.atan(imag/real);
        if (real < 0){
            if (imag >= 0) {
                arg = arg + Math.PI;
            } else {
                arg = arg - Math.PI;
            }
        }
        return arg;
    }

    public MyComplex add(MyComplex number) {
        real = real + number.real;
        imag = imag + number.imag;
        return this;
    }

    public MyComplex addNew(MyComplex number) {
        MyComplex newNumber = new MyComplex();
        newNumber.real = this.real + number.real;
        newNumber.imag = this.imag + number.imag;
        return newNumber;
    }

    public MyComplex subtract(MyComplex number) {
        real = real - number.real;
        imag = imag - number.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex number) {
        MyComplex newNumber = new MyComplex();
        newNumber.real = this.real - number.real;
        newNumber.imag = this.imag - number.imag;
        return newNumber;
    }

    public MyComplex multiply(MyComplex number) {
        real = real * number.real;
        imag = imag * number.imag;
        return this;
    }

    public MyComplex divide(MyComplex number) {
        real = real / number.real;
        imag = imag / number.imag;
        return this;
    }

    public MyComplex conjugate() {
        imag = -imag;
        return this;
    }
}
