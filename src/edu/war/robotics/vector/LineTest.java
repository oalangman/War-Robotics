package edu.war.robotics.vector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void getSegments() {
        // create expected points [ (0,0), (1,1), (2,2), (3,3)]
        Point[] pointsExpected = new Point[4];
       // points[i] = new Point(segmentX, segmentY);
        pointsExpected[0] = new Point (0,0);
        pointsExpected[1] = new Point(1, 1);
        pointsExpected[2] = new Point(2,2);
        pointsExpected[3] = new Point(3,3);
        for ( Point pt : pointsExpected) {
            System.out.println("Point is: " + pt);
        }

        Point tail = new Point(0,0);
        Point head = new Point(3,3);
        Line testLine = new Line (tail,head);
        Point[] pointsActual = testLine.getSegments(3);

        System.out.println("Points Expected Size: "+ pointsExpected.length);
        System.out.println("Points Actual Size: " +pointsActual.length);

        for (int i = 0; i < pointsExpected.length; i++) {
            assertEquals(pointsExpected[i], pointsActual[i]);
        }

    }
}