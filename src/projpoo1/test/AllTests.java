package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestClasseGestion.class, 
				TestClasseMere.class, 
				TestClasseSalarie.class })

public class AllTests {

}
