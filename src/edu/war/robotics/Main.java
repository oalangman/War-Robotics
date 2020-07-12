package edu.war.robotics;

import edu.war.robotics.vector.Line;
import edu.war.robotics.vector.Point;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(2.0,3.0);
        Point p2 = new Point(1.0, 7.0);
        System.out.println("Point: " + p1);
        System.out.println("Point: " + p2);
        System.out.println("P1 Distance from origin: " +p1.distanceFromOrigin());
        System.out.println("P2 Distance from origin: " +p2.distanceFromOrigin());
        String p1Quadrant = p1.getQuadrant();
        String p2Quadrant = p2.getQuadrant();
        System.out.println("Point 1 in Quadrant: " + p1Quadrant + " Point 2 in Quadrant: " + p2Quadrant);
        //(-4,1) and (8,7).
        Line snake = new Line(new Point(3,3), new Point(0,0));
        Point[] segments = snake.getSegments(3);
        for ( Point segment : segments) {
            System.out.println(segment);
        }
    }
}
