package com.codehackerr.simple.bdd.examples;

import com.codehackerr.simple.bdd.Reporter;
import com.codehackerr.simple.bdd.SimpleBDD;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(TestClass.class)
public class TestSuite {

    @BeforeClass
    public static void beforeSuite() {
        SimpleBDD.setReporter(Reporter.Console);
    }

}