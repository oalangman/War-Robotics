package edu.war.robotics.vector;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

    @Test
    public void testRobotPathFinding() {
        Point[] points = new Point[]{new Point(0, 1), new Point(2, 1), new Point(4, 1), new Point(6, 1)};
        Point robotPosition = new Point(1, 0);
        Path squiggles =  Path.createPath(points);
        System.out.println("Course length: " + squiggles.totalDistance());
        double lookAheadDistance = 4.0;
        WayPoint targetPoint = squiggles.getTargetPoint(robotPosition, lookAheadDistance);
        System.out.println("Target Point is: " + targetPoint);
    }

    @Test
    public void testDuplicatesRemoved() {
        // Make some points
        Point[] points = new Point[] {new Point(0,0), new Point(3,4), new Point(3,4), new Point(5,5)};
        Path path = Path.createPath(points);
        assertEquals(3, path.getWayPoints().size());
        // Check to make sure that you got rid of the duplicates
       // List<Path.TargetPoint> results = path.getPoints();
        // Your code here!
    }

    @Test
    public void testPathHasMoreThanOnePoint() {
        // Make an empty point array and try to create a path
        Point[] points = new Point[2];
        points[0] = new Point( 2.4 , 5.7 );
        try {
            //Path path = new Path(points);  // should throw IllegalArgumentException
            Path path = Path.createPath(points);

            fail("Expected Path() to throw IllegalArgumentException for empty point array");
        } catch (IllegalArgumentException e) {
            // What we expected; do nothing and let the test pass.
        }
    }

    @Test
    public void testRejectZeroLengthPath() {
        // Make an empty point array and try to create a path
        Point[] points = new Point[0];
        try {
            Path path = Path.createPath(points);// should throw IllegalArgumentException
            fail("Expected Path() to throw IllegalArgumentException for empty point array");
        } catch (IllegalArgumentException e) {
            // What we expected; do nothing and let the test pass.
        }
    }

    @Test
    public void testTotalDistance() {
        Point[] points = new Point[] {new Point(0,0), new Point(3,4)};
        Path path = Path.createPath(points);
        assertEquals(5, path.totalDistance(), 0.00001);
    }


    @Test
    void createPath() {
        Point[] points = new Point[] {new Point(0,0), new Point(3,4)};
        Path path = Path.createPath(points);
        assertEquals(2,path.getWayPoints().size());
    }

    @Test
    void getTargetPoint() {
    }

    @Test
    void getPoints() {
    }
}