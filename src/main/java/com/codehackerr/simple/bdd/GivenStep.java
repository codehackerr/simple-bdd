package com.codehackerr.simple.bdd;

public class GivenStep {
    static void given(Runnable r) {
        r.run();
    }
}
