package edu.war.robotics.vector;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<WayPoint> wayPoints = new ArrayList<>();
    private double totalDistance = 0.0;

    public List<WayPoint> getWayPoints() {
        return wayPoints;
    }

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

    /**
     * @return total distance along the path
     */
    public double totalDistance() {
        return totalDistance;
    }
    /**
     * @return a point at the supplied distance along the path from the supplied robot position
     * Note that the point will usually be interpolated between the points that originally defined the Path
     */
    public WayPoint getTargetPoint(Point robotPosition, double lookAheadDistance) {
        Distance distanceToWayPoint = new Distance();
        WayPoint firstWayPoint = getClosestWayPoint (robotPosition, distanceToWayPoint);
        WayPoint lastWayPoint = getEndWayPoint (firstWayPoint, distanceToWayPoint.length, lookAheadDistance);
        Line segment = new Line(firstWayPoint.getPoint(), lastWayPoint.getPoint());
        Point[] points = segment.getSegments(2);
        Point targetPoint = points[1];
        Point deltaPoint = targetPoint.getPointDelta( points[0] );
        double distance = targetPoint.getDistance(points[0]);
        return new WayPoint(targetPoint, deltaPoint.getX(), deltaPoint.getY(), distance, distance);
    }

    private WayPoint getClosestWayPoint(Point robotPosition, Distance distanceToWayPoint) {
        WayPoint closestWayPoint = null;
        for ( WayPoint wayPoint : this.wayPoints ) {
            distanceToWayPoint.length = wayPoint.componentAlongPath(robotPosition);
            if (distanceToWayPoint.length > 0 ) {
                closestWayPoint = wayPoint;
                break;
            }
        }
        return closestWayPoint;
    }

    private WayPoint getEndWayPoint(WayPoint firstWayPoint, double distanceToClosestWayPoint, double lookAheadDistance) {
        WayPoint endWayPoint = null;
        double distanceFromCurrent = distanceToClosestWayPoint;
//        WayPoint[] wayPointArray = (WayPoint[]) wayPoints.toArray();
        WayPoint[] wayPointArray = new WayPoint[wayPoints.size()];
        wayPoints.toArray(wayPointArray);
        for (int i = wayPoints.indexOf(firstWayPoint)+1 ; i < wayPointArray.length; i++) {
            distanceFromCurrent += wayPointArray[i].getDistanceFromPrevious();
            if (distanceFromCurrent > lookAheadDistance ) {
                endWayPoint = wayPointArray[i];
                break;
            }
        }
        return endWayPoint;
    }

    private class Distance {
        public double length = 0.0;
    }
}