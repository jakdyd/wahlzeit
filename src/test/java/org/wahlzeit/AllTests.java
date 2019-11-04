package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.mailing.EmailServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({EmailAddressTest.class, EmailServiceTest.class})
public class AllTests {

}
