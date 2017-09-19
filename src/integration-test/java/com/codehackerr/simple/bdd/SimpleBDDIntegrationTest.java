package com.codehackerr.simple.bdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static com.codehackerr.simple.bdd.SimpleBDD.given;
import static java.util.Arrays.copyOfRange;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
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
        given("A Step", () -> {

        });

        //then
        String stepStatus = "Given: A Step- OK\n";

        verify(dummySystemOut).write(captor.capture(), eq(0), eq(stepStatus.length()));

        // the entire block may be written with 0 values for unused characters. We are interested only in the real content
        assertThat(copyOfRange(captor.getValue(), 0, stepStatus.length()), is(stepStatus.getBytes()));
    }
}
