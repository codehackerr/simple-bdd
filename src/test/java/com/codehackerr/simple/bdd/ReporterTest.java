package com.codehackerr.simple.bdd;

import com.codehackerr.simple.bdd.reporter.Reporter;
import com.codehackerr.simple.bdd.scenario.SimpleBDD;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintWriter;

import static com.codehackerr.simple.bdd.scenario.SimpleBDD.scenario;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReporterTest {

    @Mock
    private PrintWriter stream;

    @InjectMocks
    private Reporter reporter;

    @Before
    public void setUp() throws Exception {
        SimpleBDD.addStepListener(reporter);
    }

    @Test
    public void should_report_step_on_start() {
        scenario("")
            .given("Step 1", () -> {
        });

        verify(stream).print("Given: Step 1");
        verify(stream).println("- OK");
    }
}
