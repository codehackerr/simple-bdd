package com.codehackerr.simple.bdd;

import com.codehackerr.simple.bdd.reporter.Reporter;
import com.codehackerr.simple.bdd.scenario.SimpleBDD;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

import static com.codehackerr.simple.bdd.scenario.SimpleBDD.scenario;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
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
