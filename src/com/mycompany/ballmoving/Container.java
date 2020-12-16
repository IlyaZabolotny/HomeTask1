package com.mycompany.ballmoving;

public class Container {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        x1 = x;
        y1 = y;
        x2 = x + width;
        y2 = y + height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public boolean collides(Ball ball) {
        boolean isCallide = false;
        if ((x1 <= ball.getX() - ball.getRadius()) &&
                (ball.getRadius() + ball.getX() <= x2)) {
            if ((y1 <= ball.getY() - ball.getRadius()) &&
                    (ball.getY() + ball.getRadius() <= y2)) {
                isCallide = true;
            }
        }
        return isCallide;
    }

    @Override
    public String toString() {
        return "Container{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }
}