package org.wahlzeit.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartesianCoordinateTest {
    
    public CartesianCoordinateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDistance method, of class CartesianCoordinate.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        CartesianCoordinate coordinate1 = new CartesianCoordinate(1, 1, 1);
        CartesianCoordinate coordinate2 = new CartesianCoordinate(1, 1, 1);
        CartesianCoordinate coordinate3 = new CartesianCoordinate(2, 2, 2);
        double expResult12 = 0.0;
        double expResult13 = Math.sqrt(3);
        double result12 = coordinate1.getDistance(coordinate2);
        double result13 = coordinate1.getDistance(coordinate3);
        assertEquals(expResult12, result12, Coordinate.THRESHOLD);
        assertEquals(expResult13, result13, Coordinate.THRESHOLD);
    }

    /**
     * Test of getCartesianDistance method, of class CartesianCoordinate.
     */
    @Test
    public void testGetCartesianDistance() {
        System.out.println("getCartesianDistance");
        testGetDistance();
    }

    /**
     * Test of asSphericCoordinate method, of class CartesianCoordinate.
     */
    @Test
    public void testAsSphericCoordinate() {
        System.out.println("asSphericCoordinate");
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(1, 1, 0);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(Math.PI / 4, Math.PI / 2, Math.sqrt(2));
        boolean result = cartesianCoordinate.equals(sphericCoordinate);
        assertEquals(true, result);
    }

    /**
     * Test of getCentralAngle method, of class CartesianCoordinate.
     */
    @Test
    public void testGetCentralAngle() {
        System.out.println("getCentralAngle");
        CartesianCoordinate instance = new CartesianCoordinate(1, 1, 0);
        CartesianCoordinate comparison = new CartesianCoordinate(1, -1, 0);
        double expResult = Math.PI / 2;
        double result = instance.getCentralAngle(comparison);
        assertEquals(expResult, result, Coordinate.THRESHOLD);
    }

    /**
     * Test of isEqual method, of class CartesianCoordinate.
     */
    @Test
    public void testIsEqual() {
        System.out.println("isEqual");
        CartesianCoordinate instance = new CartesianCoordinate(1, 1, 0);
        CartesianCoordinate comparison = new CartesianCoordinate(1, 1, 0);
        boolean result = instance.isEqual(comparison);
        assertEquals(true, result);
    }
    
}
