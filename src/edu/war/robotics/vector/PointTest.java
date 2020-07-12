package edu.war.robotics.vector;

import org.junit.jupiter.api.Test;

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

    @Test
    void getQuadrant() {
        assertEquals("Q1",new Point(3,4).getQuadrant());
        assertEquals("Q2",new Point(-4.5,6).getQuadrant());
        assertEquals("Q3",new Point(-1,-1).getQuadrant());
        assertEquals("Q4",new Point(19,-3.2215).getQuadrant());
        assertEquals("y-axis",new Point(0,-7).getQuadrant());
        assertEquals("x-axis",new Point(12,0).getQuadrant());
        assertEquals("Origin",new Point(0,0).getQuadrant());
    }
}