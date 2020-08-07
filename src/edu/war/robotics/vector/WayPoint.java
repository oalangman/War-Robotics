package edu.war.robotics.vector;

import java.util.Objects;

class WayPoint {
    public Point point;
    private double deltaXFromPrevious;
    private double deltaYFromPrevious;
    private double distanceFromPrevious;
    private double distanceFromStart;


    public Point getPoint() {
        return point;
    }

    public double getDistanceFromStart() {
        return distanceFromStart;
    }

    public double getDistanceFromPrevious() {
        return distanceFromPrevious;
    }

    public void setDeltaXFromPrevious(double deltaXFromPrevious) {
        this.deltaXFromPrevious = deltaXFromPrevious;
    }

    public WayPoint(Point point, double deltaXFromPrevious, double deltaYFromPrevious, double distanceFromPrevious, double distanceFromStart) {
        this.point = point;
        this.deltaXFromPrevious = deltaXFromPrevious;
        this.deltaYFromPrevious = deltaYFromPrevious;
        this.distanceFromPrevious = distanceFromPrevious;
        this.distanceFromStart = distanceFromStart;
    }

    public double getDistanceToEnd(Path path) {
        return path.totalDistance() - distanceFromStart;
    }

    /**
     * Calculates the projection of the vector Vcurrent leading from the supplied robot
     * point to this WayPoint onto the vector Vpath leading from the previous point on the path
     * to this WayPoint.  If the return value is positive, it means that the WayPoint is
     * farther along the path from the robot position.  If the return value is negative, it means
     * that the WayPoint is before the robot position (earlier on the path).
     * The magnitude of the value tells the
     * distance along the path.  The value is computed as the dot product between Vcurrent and
     * Vpath, normalized by the length of vPath
     *
     * param current The source point to compare to the WayPoint
     */
    public double componentAlongPath(Point robotPosition) {
        double deltaXFromCurrent = point.getX() - robotPosition.getX();
        double deltaYFromCurrent = point.getY() - robotPosition.getY();

        double dp = deltaXFromCurrent * deltaXFromPrevious + deltaYFromCurrent * deltaYFromPrevious;
        return dp / distanceFromPrevious;
    }

    @Override
    public String toString() {
        return "WayPoint{" +
                "point=" + point +
                ", deltaXFromPrevious=" + deltaXFromPrevious +
                ", deltaYFromPrevious=" + deltaYFromPrevious +
                ", distanceFromPrevious=" + distanceFromPrevious +
                ", distanceFromStart=" + distanceFromStart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WayPoint wayPoint = (WayPoint) o;
        return point.equals(wayPoint.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
