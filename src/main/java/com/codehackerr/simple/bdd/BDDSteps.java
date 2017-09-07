package com.codehackerr.simple.bdd;

public class BDDSteps {
    static Step given(Runnable r) {
        return new Step(r).run();
    }

    static void when(Runnable r) {
        new Step(r).run();
    }

    static void then(Runnable r) {
        new Step(r).run();
    }
}

class Step {
    private final Runnable step;

    public Step(Runnable r) {
        this.step = r;
    }

    public Step run() {
        step.run();
        return this;
    }

    public Step when(Runnable r) {
        return new Step(r).run();
    }

    public Step then(Runnable r) {
        return new Step(r).run();
    }
}



