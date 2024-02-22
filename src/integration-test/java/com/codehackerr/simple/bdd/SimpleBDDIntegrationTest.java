package com.codehackerr.simple.bdd;

import com.codehackerr.simple.bdd.reporter.Reporter;
import com.codehackerr.simple.bdd.scenario.SimpleBDD;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static com.codehackerr.simple.bdd.scenario.SimpleBDD.scenario;
import static java.util.Arrays.copyOfRange;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SimpleBDDIntegrationTest {
    private final ArgumentCaptor<byte[]> captor = ArgumentCaptor.forClass(byte[].class);
    @Mock
    private PrintStream dummySystemOut;

    @Test
    public void console_reporter_print_step_status_to_console() {
        //given
        System.setOut(dummySystemOut);
        SimpleBDD.setReporter(Reporter.Console);

        //when
        scenario("test")
            .given("A Step", () -> {

        });

        //then
        verify(dummySystemOut).write(captor.capture(), eq(0), anyInt());

        String actual = new String(captor.getValue());
        assertTrue(actual.contains("Scenario: test\n"));
        assertTrue(actual.contains("Given: A Step- OK\n"));
    }
}
