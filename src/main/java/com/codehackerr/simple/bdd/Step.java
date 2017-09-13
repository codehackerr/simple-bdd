package com.codehackerr.simple.bdd;

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

    public Step when(String description, Runnable r) {

        return new Step(description, r).run();
    }

    public Step then(String description, Runnable r) {

        return new Step(description, r).run();
    }
}
