package edu.war.robotics.vector;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFromOrigin() {
        double xSquared = Math.pow(this.x, 2);
        double ySquared = Math.pow(this.y, 2);
        return Math.sqrt(xSquared + ySquared);
    }

    public String getQuadrant() {
        String result = null;

        if (x > 0 && y > 0) {
            result = "Q1";      // Finds Q1 if no then goes through others
        } else if (x < 0 && y > 0) {
            result = "Q2";
        } else if (x < 0 && y < 0) {
            result = "Q3";
        } else if (x > 0 && y < 0) {
            result = "Q4";
        } else if (x != 0 && y == 0 ) {
            result = "x-axis";
        } else if (x == 0 && y != 0) {
            result = "y-axis";
        } else if (x == 0 && y == 0) {
            result = "Origin";
        }

        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
