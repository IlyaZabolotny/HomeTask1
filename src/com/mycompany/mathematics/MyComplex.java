package com.mycompany.mathematics;

import java.util.Objects;

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

    public boolean equals(MyComplex number) {
        return (number.real == real) && (number.imag == imag);
    }

    public boolean equals(double real, double imag) {
        return (this.real == real) && (this.imag == imag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyComplex myComplex = (MyComplex) o;
        return Double.compare(myComplex.real, real) == 0 &&
                Double.compare(myComplex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
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
