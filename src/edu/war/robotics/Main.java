package edu.war.robotics;

import edu.war.robotics.vector.Point;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(2.0,3.0);
        Point p2 = new Point(1.0, 7.0);
        System.out.println("Point: " + p1);
        System.out.println("Point: " + p2);
        System.out.println("P1 Distance from origin: " +p1.distanceFromOrigin());
        System.out.println("P2 Distance from origin: " +p2.distanceFromOrigin());
    }
}
