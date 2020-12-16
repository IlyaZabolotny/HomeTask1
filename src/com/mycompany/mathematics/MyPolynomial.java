package com.mycompany.mathematics;

import java.util.Arrays;

public class MyPolynomial {

    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        if (coeffs.length == 0) {
            throw new IllegalArgumentException();
        } else {
            this.coeffs = coeffs;
        }
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        int degree = this.getDegree();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = degree; i > 0; i--) {
            if (i == degree) {
                stringBuilder.append(coeffs[i] + "x^"+i);
            } else {
                stringBuilder.append(" + " + coeffs[i] + "x^"+i);
            }
        }
        if (degree == 0) {
            stringBuilder.append(coeffs[0]);
        } else {
            stringBuilder.append(" + " + coeffs[0]);
        }
        return stringBuilder.toString();
    }

    public double evaluate(double x) {
        int degree = this.getDegree();
        double result = coeffs[0];
        for (int i = 1;i <= degree; i++) {
            result += this.coeffs[i]*Math.pow(x, i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial polinomial) {
        int degree = this.getDegree();
        int newDegree = polinomial.getDegree();
        int max = Math.max(degree, newDegree), min = Math.min(degree, newDegree);
        double[] newCoeffs = new double[max + 1];
        MyPolynomial result = new MyPolynomial(newCoeffs);
        for (int i=0; i<=min; i++) {
            result.coeffs[i] = this.coeffs[i] + polinomial.coeffs[i];
        }
        if (degree > newDegree) System.arraycopy(this.coeffs, min+1, result.coeffs, min+1, max-min);
        else if (newDegree > degree) System.arraycopy(polinomial.coeffs, min+1, result.coeffs, min+1, max-min);
        return result;
    }

    public MyPolynomial multiply(MyPolynomial polinomial){
        int degree = this.getDegree();
        int newDegree = polinomial.getDegree();
        double[] newCoeffs = new double[degree + newDegree +1];
        MyPolynomial result = new MyPolynomial(newCoeffs);
        for (int i = degree; i>=0; i--) {
            for (int j = newDegree; j>=0 ; j--) {
                result.coeffs[i+j] += this.coeffs[i] * polinomial.coeffs[j];
            }
        }
        return result;
    }


}
