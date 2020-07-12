package edu.war.robotics.vector;

public class Line {
    private Point head = null;
    private Point tail = null;

    private Line() {
    }

    public Line(Point head, Point tail) {
        this.head = head;
        this.tail = tail;
    }

     public Point[] getSegments(int numberSegments){
        // 1. initialize variables (especially your return variable)
         Point[] points = new Point[numberSegments + 1];
         double deltaX = (head.getX() - tail.getX())/numberSegments;
         double deltaY = (head.getY() - tail.getY())/numberSegments;
         Point deltaPoint = new Point(deltaX,deltaY);
         points[0] = tail;
         points[numberSegments] = head;
         for (int i = 1; i < numberSegments; i++) {
             Point previousPoint = points[i-1];
             double segmentX = previousPoint.getX() + deltaX;
             double segmentY = previousPoint.getY() + deltaY;
             points[i] = new Point(segmentX, segmentY);
         }
         return points;
     }
}
