package com.codehackerr.simple.bdd;

import java.util.HashSet;
import java.util.Set;

public class SimpleBDD {

    private static Set<StepLister> listeners = new HashSet<>();

    static Step given(String description, Runnable r) {
        return runStep(description, r);
    }

    static void when(String description, Runnable r) {
        runStep(description, r);
    }

    static void then(String description, Runnable r) {

        runStep(description, r);
    }

    public static void addStepListener(StepLister stepLister) {

        listeners.add(stepLister);
    }

    public static void setReporter(Reporter reporter) {
        SimpleBDD.listeners.remove(reporter);
        SimpleBDD.listeners.add(reporter);
    }

    private static Step runStep(String description, Runnable r) {

        listeners.forEach(l -> l.start(description));

        Step step = new Step(description, r).run();

        listeners.forEach(l -> l.finish(description));

        return step;
    }
}



