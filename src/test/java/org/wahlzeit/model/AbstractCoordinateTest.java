package org.wahlzeit.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AbstractCoordinateTest {

    public AbstractCoordinateTest() {
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
     * Test of compareDoubles method, of class AbstractCoordinate.
     */
    @Test
    public void testCompareDoubles() {
        System.out.println("compareDoubles");
        double x = 0.0;
        double y = 0.0;
        double z = 1.0;
        AbstractCoordinate instance = new AbstractCoordinateImpl();
        boolean result1 = instance.compareDoubles(x, y);
        boolean result2 = instance.compareDoubles(x, z);
        assertEquals(true, result1);
        assertNotEquals(true, result2);
    }

    /**
     * Test of getCartesianDistance method, of class AbstractCoordinate.
     */
    @Test
    public void testGetCartesianDistance() {
        System.out.println("getCartesianDistance");
        Coordinate coordinate1 = CartesianCoordinate.create(0, 0, 0);
        Coordinate coordinate2 = CartesianCoordinate.create(0, 0, 0);
        Coordinate coordinate3 = CartesianCoordinate.create(1, 1, 1);
        double distance12 = coordinate1.getCartesianDistance(coordinate2);
        double distance13 = coordinate1.getCartesianDistance(coordinate3);
        assertEquals(0.0, distance12, Coordinate.THRESHOLD);
        assertEquals(Math.sqrt(3), distance13, Coordinate.THRESHOLD);
    }

    /**
     * Test of getCentralAngle method, of class AbstractCoordinate.
     */
    @Test
    public void testGetCentralAngle() {
        System.out.println("getCentralAngle");
        Coordinate coordinate1 = SphericCoordinate.create(0, Math.PI / 4, 1);
        Coordinate coordinate2 = SphericCoordinate.create(Math.PI, Math.PI / 4, 2);
        double result = coordinate1.getCentralAngle(coordinate2);
        assertEquals(Math.PI / 2, result, Coordinate.THRESHOLD);
    }

    /**
     * Test of isEqual method, of class AbstractCoordinate.
     */
    @Test
    public void testIsEqual() {
        System.out.println("isEqual");
        Coordinate coordinate1 = CartesianCoordinate.create(1, 1, 1);
        Coordinate coordinate2 = SphericCoordinate.create(Math.PI / 4, Math.atan(Math.sqrt(2)), Math.sqrt(3));
        boolean result = coordinate1.isEqual(coordinate2);
        assertEquals(true, result);
    }

    public class AbstractCoordinateImpl extends AbstractCoordinate {

        @Override
        public CartesianCoordinate asCartesianCoordinate() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public SphericCoordinate asSphericCoordinate() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isEqual(Coordinate coordinate) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
