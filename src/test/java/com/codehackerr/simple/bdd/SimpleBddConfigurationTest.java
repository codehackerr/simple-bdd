package com.codehackerr.simple.bdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class SimpleBddConfigurationTest {
    @Mock
    private StepLister stepLister;

    @Mock
    private Reporter reporter;

    @Test
    public void step_listener_callback() {
        SimpleBDD.addStepListener(stepLister);

        SimpleBDD.given("Step 1", () -> {
        });

        InOrder stepLifeCycle = inOrder(stepLister);
        stepLifeCycle.verify(stepLister).start("Step 1", description);
        stepLifeCycle.verify(stepLister).finish("Step 1", description);
    }

    @Test
    public void reporter_callback() {
        SimpleBDD.setReporter(reporter);

        SimpleBDD.given("Step 1", () -> {
        });

        InOrder stepLifeCycle = inOrder(reporter);
        stepLifeCycle.verify(reporter).start("Step 1", description);
        stepLifeCycle.verify(reporter).finish("Step 1", description);
    }
}
