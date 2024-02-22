package com.codehackerr.simple.bdd.reporter;

import com.codehackerr.simple.bdd.scenario.ScenarioListener;
import com.codehackerr.simple.bdd.step.StepListner;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Reporter implements ScenarioListener, StepListner {

    public static Reporter Console;
    static {
        try {
            Console = new Reporter(new PrintWriter(new OutputStreamWriter(System.out,"UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private PrintWriter stream;

    public Reporter(PrintWriter stream) {
        this.stream = stream;
    }

    @Override
    public void start(String stepType, String description) {
        stream.print(stepType + ": " + description);
    }

    @Override
    public void finish(String stepType, String description) {
        stream.println("- OK");
        stream.flush();
    }

    @Override
    public void startScenario(String description) {
        stream.println("===========================");
        stream.println("Scenario: " + description);
    }
    @Override
    public void finishScenario(String description) {
        stream.println("====== END SCENARIO =======");
    }
}
