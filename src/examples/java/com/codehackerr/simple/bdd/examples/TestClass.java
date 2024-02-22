package com.codehackerr.simple.bdd.examples;

import org.junit.Test;

import static com.codehackerr.simple.bdd.scenario.SimpleBDD.scenario;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestClass {

    @Test
    public void string_building() {

        String hello = "hello";
        String world = "world";
        StringBuilder helloWorld = new StringBuilder();

        scenario("string_building")
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
