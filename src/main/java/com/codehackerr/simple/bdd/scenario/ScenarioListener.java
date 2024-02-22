package com.codehackerr.simple.bdd.scenario;

public interface ScenarioListener {
    default void startScenario(String description) {
    }

    default void finishScenario(String description) {
    }
}
