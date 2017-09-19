package com.codehackerr.simple.bdd;

import java.util.Set;

public class Step {

    public static final String GIVEN = "Given";
    public static final String WHEN = "When";
    public static final String THEN = "Then";

    private String stepType;
    private String description;
    private final Runnable body;
    private Set<StepLister> listeners;

    public Step(String stepType, String description, Runnable r, Set<StepLister> listeners) {
        this.stepType = stepType;
        this.description = description;
        this.body = r;
        this.listeners = listeners;
    }

    public Step run() {
        listeners.forEach(l -> l.start(stepType, description));
        body.run();
        listeners.forEach(l -> l.finish(stepType, description));
        return this;
    }

    public Step when(String description, Runnable r) {

        return new Step(WHEN, description, r, listeners).run();
    }

    public Step then(String description, Runnable r) {

        return new Step(THEN, description, r, listeners).run();
    }
}
