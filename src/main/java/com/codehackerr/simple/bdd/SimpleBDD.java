package com.codehackerr.simple.bdd;

import java.util.HashSet;
import java.util.Set;

public class SimpleBDD {

    private static Set<StepLister> listeners = new HashSet<>();

    public static Step given(String description, Runnable r) {
        return runStep(Step.GIVEN, description, r);
    }

    static void when(String description, Runnable r) {
        runStep(Step.WHEN, description, r);
    }

    static void then(String description, Runnable r) {

        runStep(Step.THEN, description, r);
    }

    public static void addStepListener(StepLister stepLister) {

        listeners.add(stepLister);
    }

    public static void setReporter(Reporter reporter) {
        SimpleBDD.listeners.remove(reporter);
        SimpleBDD.listeners.add(reporter);
    }

    private static Step runStep(String stepType, String description, Runnable r) {
        return new Step(stepType, description, r, listeners).run();
    }
}



