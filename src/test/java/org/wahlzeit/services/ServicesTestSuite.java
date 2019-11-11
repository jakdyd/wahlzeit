package org.wahlzeit.services;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.MailingTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    MailingTestSuite.class,
    EmailAddressTest.class,
    LogBuilderTest.class
})
public class ServicesTestSuite {

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
