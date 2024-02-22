package com.codehackerr.simple.bdd.scenario;

import com.codehackerr.simple.bdd.step.Step;
import com.codehackerr.simple.bdd.step.StepListner;

import java.util.HashSet;
import java.util.Set;

public class Scenario {
    private final String description;
    private final Runnable r;
    private final Set<ScenarioListener> listeners;
    private final Set<StepListner> stepListners;

    private final Set<Step> steps = new HashSet<>();

    private Scenario(String description, Runnable r, Set<ScenarioListener> listeners, Set<StepListner> stepListners) {
        this.description = description;
        this.r = r;
        this.listeners = listeners;
        this.stepListners = stepListners;
    }

    Scenario scenario(String description, Runnable r, Set<ScenarioListener> listeners, Set<StepListner> stepListners) {
        return new Scenario(description, r, listeners, stepListners);
    }

    static Scenario scenario(String description, Set<ScenarioListener> listeners, Set<StepListner> stepListners) {
        return new Scenario(description, () -> {
        }, listeners, stepListners);
    }

    public Step given(String description, Runnable r) {
        return runStep(Step.GIVEN, description, r);
    }

    public Step when(String description, Runnable r) {
        return runStep(Step.WHEN, description, r);
    }

    public void then(String description, Runnable r) {
        runStep(Step.THEN, description, r);
        finish();
    }

    private Step runStep(String stepType, String stepDescription, Runnable r) {
        if (steps.isEmpty()) { // hack. need to separate definition of scenario from runtime
            listeners.forEach(l -> l.startScenario(this.description));
        }
        Step step = new Step(stepType, stepDescription, r, stepListners, this);
        Step run = step.run();

        return run;

    }

    public void addStep(Step step) {
        steps.add(step);
    }

    public void finish() {
        listeners.forEach(l -> l.finishScenario(this.description));
    }
}
