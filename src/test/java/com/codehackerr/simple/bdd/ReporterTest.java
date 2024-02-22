package com.codehackerr.simple.bdd;

import com.codehackerr.simple.bdd.reporter.Reporter;
import com.codehackerr.simple.bdd.scenario.SimpleBDD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintWriter;

import static com.codehackerr.simple.bdd.scenario.SimpleBDD.scenario;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ReporterTest {

    @Mock
    private PrintWriter stream;

    @InjectMocks
    private Reporter reporter;

    @BeforeEach
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
