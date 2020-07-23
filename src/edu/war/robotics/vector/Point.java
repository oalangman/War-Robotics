package edu.war.robotics.vector;

import java.util.Objects;

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

    public Point getPointDelta(Point targetPoint){
        if (targetPoint == null) {
            return null;
        }
        double deltaX = this.x - targetPoint.getX();
        double deltaY = this.y - targetPoint.getY();
        return new Point(deltaX, deltaY);
    }

    public double getDistance (Point targetPoint) {
        Point deltaPoint = getPointDelta(targetPoint);
        return Math.sqrt(Math.pow(deltaPoint.getX(), 2) + Math.pow(deltaPoint.getY(), 2));
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
