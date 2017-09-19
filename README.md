# simple-bdd
### Status
[![Build Status](https://api.travis-ci.org/codehackerr/simple-bdd.png)](https://api.travis-ci.org/codehackerr/simple-bdd.png)

BDD from anywhere unit/integration tests or simply any java code

# Usage:
```
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

        given("Two little strings", () -> {

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
