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

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
