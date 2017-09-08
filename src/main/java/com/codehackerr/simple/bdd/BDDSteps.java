package com.codehackerr.simple.bdd;

public class BDDSteps {
    static Step given(String description, Runnable r) {
        return new Step(description, r).run();
    }

    static void when(String description, Runnable r) {
        new Step(description, r).run();
    }

    static void then(String description, Runnable r) {
        new Step(description, r).run();
    }
}

class Step {
    private String description;
    private final Runnable step;

    public Step(String description, Runnable r) {
        this.description = description;
        this.step = r;
    }

    public Step run() {
        step.run();
        return this;
    }

    public Step when(Runnable r) {
        return new Step(description, r).run();
    }

    public Step then(Runnable r) {
        return new Step(description, r).run();
    }
}



