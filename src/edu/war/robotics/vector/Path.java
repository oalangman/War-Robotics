package edu.war.robotics.vector;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<WayPoint> wayPoints = new ArrayList<>();
    private double totalDistance = 0.0;


    /**
     * Adding private default constructure to ensure that this class isn't initialized without
     * an array of raw points.
     */
    private Path() {
    }

    /**
     * @param pathPoints Array of X,Y points.  Consecutive duplicate points are discarded
     *                  A path must have at least 2 non-identical points
     * @throws IllegalArgumentException for paths with fewer than 2 non-duplicate points.
     */
    private Path(List<WayPoint> wayPoints) {
        this.wayPoints = wayPoints;
        for (WayPoint wayPoint : this.wayPoints) {
            this.totalDistance += wayPoint.getDistanceFromPrevious();
        }
    }

    /**
     * Factory method for creating a path.
     * @param pathPoints
     * @return
     * @throws IllegalArgumentException
     */
    public static Path createPath(Point[] pathPoints) throws IllegalArgumentException {
        if (pathPoints == null || pathPoints.length < 2) {
            throw new IllegalArgumentException("Point array must have more than one point.");
        }
        List<WayPoint> wayPoints = new ArrayList<>();
        // adding first waypoint to the list so that we can use the counter starting at one.
        wayPoints.add(new WayPoint(pathPoints [0], 0, 0, 0, 0));
        for (int i = 1; i < pathPoints.length; i++) {
            Point currentPoint = pathPoints[i];
            Point previousPoint = pathPoints[i - 1];
            if (!currentPoint.equals(previousPoint)){
                //Point point, double deltaXFromPrevious, double deltaYFromPrevious, double distanceFromPrevious, double distanceFromStart
                Point deltaPoint = currentPoint.getPointDelta(previousPoint);
                double distanceFromPrevious = currentPoint.getDistance(previousPoint);
                double distanceFromStart = currentPoint.getDistance(pathPoints[0]);
                WayPoint wayPoint = new WayPoint(currentPoint, deltaPoint.getX(), deltaPoint.getY(), distanceFromPrevious, distanceFromStart);
                wayPoints.add(wayPoint);
            }
        }
        if (wayPoints.size() == 1) {
            throw new IllegalArgumentException("Path must have at least two different points!");
        }
        return new Path(wayPoints);
    }

    private void validatePoints( Point[] rawPoints) throws IllegalArgumentException {

    }

    /**
     * @return total distance along the path
     */
    public double totalDistance() {
        return 0.0;
    }
    /**
     * @return a point at the supplied distance along the path from the supplied robot position
     * Note that the point will usually be interpolated between the points that originally defined the Path
     */
    public WayPoint getTargetPoint(Point robotPosition, double lookAheadDistance) {
//        return new TargetPoint(current, 0, 0);
        return null;
    }

//    List<TargetPoint> getPoints() {
//        return new ArrayList<>();
//    }

//    public static class TargetPoint {
//        public Point point;
//        public double distanceFromStart;
//        public double distanceToEnd;
//
//        private TargetPoint(Point point, double distanceFromStart, double distanceToEnd) {
//            this.point = point;
//            this.distanceFromStart = distanceFromStart;
//            this.distanceToEnd = distanceToEnd;
//        }
//
//        private TargetPoint(WayPoint wayPoint) {
//            this.point = wayPoint.point;
//            this.distanceFromStart = wayPoint.distanceFromStart;
//            this.distanceToEnd = wayPoint.getDistanceToEnd();
//        }
//    }
}


