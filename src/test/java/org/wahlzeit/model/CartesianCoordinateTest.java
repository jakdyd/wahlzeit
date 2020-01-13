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
     * Test of asSphericCoordinate method, of class CartesianCoordinate.
     */
    @Test
    public void testAsSphericCoordinate() {
        System.out.println("asSphericCoordinate");
        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.create(1, 1, 0);
        SphericCoordinate sphericCoordinate = SphericCoordinate.create(Math.PI / 4, Math.PI / 2, Math.sqrt(2));
        boolean result = cartesianCoordinate.asSphericCoordinate().equals(sphericCoordinate);
        assertEquals(true, result);
    }

    /**
     * Test of getCentralAngle method, of class CartesianCoordinate.
     */
    @Test
    public void testGetCentralAngle() {
        System.out.println("getCentralAngle");
        CartesianCoordinate instance = CartesianCoordinate.create(1, 1, 0);
        CartesianCoordinate comparison = CartesianCoordinate.create(1, -1, 0);
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
        CartesianCoordinate instance = CartesianCoordinate.create(1, 1, 0);
        CartesianCoordinate comparison = CartesianCoordinate.create(1, 1, 0);
        boolean result = instance.isEqual(comparison);
        assertEquals(true, result);
    }

    /**
     * Test of equals method, of class CartesianCoordinate.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        CartesianCoordinate instance = CartesianCoordinate.create(0, 0, 0);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class CartesianCoordinate.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        CartesianCoordinate instance = CartesianCoordinate.create(1, 2, 3);
        CartesianCoordinate other = CartesianCoordinate.create(1, 2, 3);
        int instanceCode = instance.hashCode();
        int otherCode = other.hashCode();
        assertEquals(instanceCode, otherCode);
    }

}
