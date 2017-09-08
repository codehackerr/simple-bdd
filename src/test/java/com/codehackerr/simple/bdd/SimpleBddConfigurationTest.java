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

    @Test
    public void step_execution() {
        SimpleBDD.addStepListener(stepLister);

        SimpleBDD.given("Step 1", () -> {
        });

        InOrder stepLifeCycle = inOrder(stepLister);
        stepLifeCycle.verify(stepLister).start("Step 1");
        stepLifeCycle.verify(stepLister).finish("Step 1");
    }
}
