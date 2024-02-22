package com.codehackerr.simple.bdd.step;

import com.codehackerr.simple.bdd.scenario.Scenario;

import java.util.Set;

public class Step {

    public static final String GIVEN = "Given";
    public static final String WHEN = "When";
    public static final String THEN = "Then";

    private String stepType;
    private String description;
    private final Runnable body;
    private Set<StepListner> listeners;
    private final Scenario scenario;

    public Step(String stepType, String description, Runnable r, Set<StepListner> listeners, Scenario scenario) {
        this.stepType = stepType;
        this.description = description;
        this.body = r;
        this.listeners = listeners;
        this.scenario = scenario;
        this.scenario.addStep(this);
    }

    public Step run() {
        listeners.forEach(l -> l.start(stepType, description));
        body.run();
        listeners.forEach(l -> l.finish(stepType, description));
        return this;
    }

    public Step when(String description, Runnable r) {
        return new Step(WHEN, description, r, listeners, this.scenario).run();
    }

    public Step then(String description, Runnable r) {
        Step run = new Step(THEN, description, r, listeners, this.scenario).run();
        scenario.finish();
        return run;

    }

}
