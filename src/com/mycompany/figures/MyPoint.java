package com.mycompany.figures;

import static java.lang.Math.*;

public class MyPoint {

    private int x = 0;
    private int y = 0;

    public MyPoint() {}

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        int[] coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double distance(int x, int y) {
        return sqrt(pow(this.x - x,2) + pow(this.y - y,2));
    }

    public double distance (MyPoint point) {
        double dist = distance();
        if (point != null) {
            dist = sqrt(pow(this.x - point.x,2) + pow(this.y - point.y,2));
        }
        return dist;
    }

    public double distance() {
        return sqrt(pow(x,2) + pow(y,2));
    }
}
