package com.codehackerr.simple.bdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.codehackerr.simple.bdd.SimpleBDD.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class SimpleBDDStepSequenceTest {

    @Mock
    private TestSteps steps;

    @Test
    public void steps_sequential_invocation() {

        given("Step 1",
                () -> steps.step1()
        ).when("Step 2",
                () -> steps.step2()
        ).then("Step 3",
                () -> steps.step3()
        );

        InOrder stepInvocationOrder = inOrder(steps);
        stepInvocationOrder.verify(steps).step1();
        stepInvocationOrder.verify(steps).step2();
        stepInvocationOrder.verify(steps).step3();
    }

    @Test
    public void string_building() {
        String hello = "hello",
                world = "world";
        StringBuilder helloWorld = new StringBuilder();

        given("Step 1", () -> {

            assert hello.length() != 0;
            assert world.length() != 0;

        }).when("Step 2", () -> {

            helloWorld.append(hello).append(world);

        }).then("Step 3", () -> {

            assertThat(helloWorld.toString(), is("helloworld"));

        });
    }

    interface TestSteps {
        void step1();

        void step2();

        void step3();
    }
}
