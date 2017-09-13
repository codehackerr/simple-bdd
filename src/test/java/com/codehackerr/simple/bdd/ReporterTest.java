package com.codehackerr.simple.bdd;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintWriter;

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
        SimpleBDD.given("Step 1", () -> {
        });

        verify(stream).print("Step 1");
        verify(stream).println("- OK");
    }
}
