package org.wahlzeit.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SphericCoordinateTest {
    
    public SphericCoordinateTest() {
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
     * Test of asCartesianCoordinate method, of class SphericCoordinate.
     */
    @Test
    public void testAsCartesianCoordinate() {
        System.out.println("asCartesianCoordinate");
        SphericCoordinate sphericCoordinate = SphericCoordinate.create(Math.PI / 4, Math.PI / 2, Math.sqrt(2));
        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.create(1, 1, 0);
        boolean result = sphericCoordinate.isEqual(cartesianCoordinate);
        assertEquals(true, result);
    }
    
    /**
     * Test of getCartesianDistance method, of class SphericCoordinate.
     */
    @Test
    public void testGetCartesianDistance() {
        System.out.println("getCartesianDistance");
        SphericCoordinate coordinate1 = SphericCoordinate.create(0, 0, 0);
        SphericCoordinate coordinate2 = SphericCoordinate.create(Math.PI / 2, Math.PI / 4, Math.sqrt(2));
        SphericCoordinate coordinate3 = SphericCoordinate.create(0, 0, 10);
        double expResult12 = Math.sqrt(2);
        double expResult13 = 10;
        double result12 = coordinate1.getCartesianDistance(coordinate2);
        double result13 = coordinate1.getCartesianDistance(coordinate3);
        assertEquals(expResult12, result12, Coordinate.THRESHOLD);
        assertEquals(expResult13, result13, Coordinate.THRESHOLD);
    }

    /**
     * Test of getCentralAngle method, of class SphericCoordinate.
     */
    @Test
    public void testGetCentralAngle() {
        System.out.println("getCentralAngle");
        SphericCoordinate instance = SphericCoordinate.create(Math.PI / 4, Math.PI / 2, 10);
        SphericCoordinate comparison = SphericCoordinate.create(Math.PI / 4, Math.PI, 10);
        double expResult = Math.PI / 2;
        double result = instance.getCentralAngle(comparison);
        assertEquals(expResult, result, Coordinate.THRESHOLD);
    }

    /**
     * Test of isEqual method, of class SphericCoordinate.
     */
    @Test
    public void testIsEqual() {
        System.out.println("isEqual");
        SphericCoordinate instance = SphericCoordinate.create(1, 2, 3);
        SphericCoordinate comparison = SphericCoordinate.create(1, 2, 3);
        boolean result = instance.isEqual(comparison);
        assertEquals(true, result);
    }

    /**
     * Test of equals method, of class SphericCoordinate.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        SphericCoordinate instance = SphericCoordinate.create(0, 0, 0);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class SphericCoordinate.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        SphericCoordinate instance = SphericCoordinate.create(1, 2, 3);
        SphericCoordinate other = SphericCoordinate.create(1, 2, 3);
        int instanceCode = instance.hashCode();
        int otherCode = other.hashCode();
        assertEquals(instanceCode, otherCode);
    }
    
}
