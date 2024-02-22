package com.codehackerr.simple.bdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.codehackerr.simple.bdd.scenario.SimpleBDD.scenario;
import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
public class SimpleBDDStepSequenceTest {

    @Mock
    private TestSteps steps;

    @Test
    public void steps_invocation() {

        scenario("")
            .given("Step 1",
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
