package org.wahlzeit.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.model.persistence.PersistenceTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    PersistenceTestSuite.class,
    AccessRightsTest.class,
    CartesianCoordinateTest.class,
    CoordinateTest.class,
    FlagReasonTest.class,
    GuestTest.class,
    PhotoFilterTest.class,
    SphericCoordinateTest.class,
    TagsTest.class,
    UserStatusTest.class,
    GenderTest.class,
    ValueTest.class
})
public class ModelTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
