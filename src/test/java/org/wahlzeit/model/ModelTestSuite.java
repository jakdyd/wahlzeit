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
    TagsTest.class,
    UserStatusTest.class,
    GenderTest.class,
    ValueTest.class,
    GuestTest.class,
    FlagReasonTest.class,
    PhotoFilterTest.class,
    AccessRightsTest.class
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
