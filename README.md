# simple-bdd
### Status
[![Build Status](https://api.travis-ci.org/codehackerr/simple-bdd.png)](https://api.travis-ci.org/codehackerr/simple-bdd.png)

A lightweight BDD framework for your unit tests. 
This implementation follows a gherkin style syntax.
The idea is to add expressiveness of a natural language to your unit tests.

A planned extension of this framework is to promote self contained test methods and test steps.
The benefit is neat and independent tests.
The idea is to pass system under test and dependencies as step parameters and not exposing them to outside scope.

# Usage:
```java
@RunWith(Suite.class)
@Suite.SuiteClasses(TestClass.class)
public class TestSuite {

    @BeforeClass
    public static void beforeSuite() {
        SimpleBDD.setReporter(Reporter.Console);
    }
}
    
public class TestClass {

    @Test
    public void string_building() {

        String hello = "hello";
        String world = "world";
        StringBuilder helloWorld = new StringBuilder();
        scenario("append strings")
            .given("Two non empty strings", () -> {

                assert hello.length() != 0;
                assert world.length() != 0;

            }).when("Appended", () -> {

                helloWorld.append(hello).append(world);

            }).then("Gives a bigger string!", () -> {

                assertThat(helloWorld.toString(), is("helloworld"));

            });
    }
}
```
# Console Report:
```bash
===========================
Scenario: string_building
Given: Two non empty strings- OK
When: Appended- OK
Then: Gives a bigger string!- OK
====== END SCENARIO ======
```

