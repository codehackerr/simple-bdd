package com.codehackerr.simple.bdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.codehackerr.simple.bdd.scenario.SimpleBDD.scenario;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SimpleBDDStepTest {

    @Mock
    private TestSteps steps;

    @Test
    public void given_step_invocation() {
        scenario("").given("Step 1", () -> {
            steps.step1();
        });

        verify(steps).step1();
    }

    @Test
    public void when_step_invocation() {
        scenario("").when("Step 1", () -> {
            steps.step1();
        });

        verify(steps).step1();
    }

    @Test
    public void then_step_invocation() {
        scenario("").then("Step 1", () -> {
            steps.step1();
        });

        verify(steps).step1();
    }


    interface TestSteps {
        public void step1();
    }
}
