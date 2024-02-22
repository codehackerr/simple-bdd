package com.codehackerr.simple.bdd.scenario;

import com.codehackerr.simple.bdd.reporter.Reporter;
import com.codehackerr.simple.bdd.step.StepListner;

import java.util.HashSet;
import java.util.Set;

public class SimpleBDD {

    public static Scenario scenario(String description, Runnable r) {
        return Scenario.scenario(description, scenarioListeners, stepListners);
    }

    public static Scenario scenario(String description) {
        return Scenario.scenario(description, scenarioListeners, stepListners);
    }

    public static void addStepListener(StepListner stepLister) {
        stepListners.add(stepLister);
    }

    public static void setReporter(Reporter reporter) {
        SimpleBDD.stepListners.remove(reporter);
        SimpleBDD.stepListners.add(reporter);
        SimpleBDD.scenarioListeners.remove(reporter);
        SimpleBDD.scenarioListeners.add(reporter);
    }

    private static Set<StepListner> stepListners = new HashSet<>();
    private static Set<ScenarioListener> scenarioListeners = new HashSet<>();

}



