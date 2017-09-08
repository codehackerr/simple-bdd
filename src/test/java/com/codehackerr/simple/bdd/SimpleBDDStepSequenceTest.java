package com.codehackerr.simple.bdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.codehackerr.simple.bdd.SimpleBDD.given;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class SimpleBDDStepSequenceTest {

    @Mock
    private TestSteps steps;

    @Test
    public void steps_invocation() {

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

    interface TestSteps {
        void step1();

        void step2();

        void step3();
    }
}
