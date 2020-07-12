package edu.war.robotics.vector;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @org.junit.jupiter.api.Test
    void distanceFromOrigin() {
        assertEquals(5,new Point(3,4).distanceFromOrigin(),.00001);
        assertEquals(13,new Point(5,-12).distanceFromOrigin(),.00001);
        // Our testing that it breaks
//        assertEquals(3, new Point(3, 1).distanceFromOrigin());
        assertEquals(25,new Point(-7,24).distanceFromOrigin(),.00001);
        assertEquals(Math.sqrt(2),new Point(-1,-1).distanceFromOrigin(),.00001);
    }
}