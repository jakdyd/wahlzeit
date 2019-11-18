package org.wahlzeit.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CoordinateTest {
    
    public CoordinateTest() {
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
     * Test of compareDoubles method, of class Coordinate.
     */
    @Test
    public void testCompareDoubles() {
        System.out.println("compareDoubles");
        double x = 2.1;
        double y = 2.1;
        double z = 2.0;
        Coordinate instance = new CoordinateImpl();
        boolean result1 = instance.compareDoubles(x, y);
        boolean result2 = instance.compareDoubles(x, z);
        assertEquals(true, result1);
        assertEquals(false, result2);
    }

    public class CoordinateImpl implements Coordinate {

        @Override
        public CartesianCoordinate asCartesianCoordinate() {
            return null;
        }

        @Override
        public double getCartesianDistance(Coordinate coordinate) {
            return 0.0;
        }

        @Override
        public SphericCoordinate asSphericCoordinate() {
            return null;
        }

        @Override
        public double getCentralAngle(Coordinate coordinate) {
            return 0.0;
        }

        @Override
        public boolean isEqual(Coordinate coordinate) {
            return false;
        }
    }
    
}
