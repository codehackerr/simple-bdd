package com.codehackerr.simple.bdd;

import com.codehackerr.simple.bdd.reporter.Reporter;
import com.codehackerr.simple.bdd.scenario.SimpleBDD;
import com.codehackerr.simple.bdd.step.StepListner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.codehackerr.simple.bdd.scenario.SimpleBDD.scenario;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class SimpleBddConfigurationTest {
    @Mock
    private StepListner stepLister;

    @Mock
    private Reporter reporter;

    @Test
    public void step_listener_callback() {
        SimpleBDD.addStepListener(stepLister);

        scenario("")
            .given("Step 1", () -> {
        });

        InOrder stepLifeCycle = inOrder(stepLister);
        stepLifeCycle.verify(stepLister).start("Given", "Step 1");
        stepLifeCycle.verify(stepLister).finish("Given", "Step 1");
    }

    @Test
    public void reporter_callback() {
        SimpleBDD.setReporter(reporter);

        scenario("reporter_callback").then("Step 2", () -> {
        });

        InOrder stepLifeCycle = inOrder(reporter);
        stepLifeCycle.verify(reporter).start("Then", "Step 2");
        stepLifeCycle.verify(reporter).finish("Then", "Step 2");
    }
}
