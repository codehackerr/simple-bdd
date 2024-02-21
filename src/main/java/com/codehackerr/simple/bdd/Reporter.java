package com.codehackerr.simple.bdd;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static com.codehackerr.simple.bdd.Step.GIVEN;
import static com.codehackerr.simple.bdd.Step.THEN;

public class Reporter implements StepLister {

    public static Reporter Console;
    static {
        try {
            Console = new Reporter(new PrintWriter(new OutputStreamWriter(System.out,"UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private PrintWriter stream;

    public Reporter(PrintWriter stream) {
        this.stream = stream;
    }

    @Override
    public void start(String stepType, String description) {
        if(stepType.equals(GIVEN)){
            stream.println("===========TEST===========");
        }
        stream.print(stepType + ": " + description);
    }

    @Override
    public void finish(String stepType, String description) {
        stream.println("- OK");
        if(stepType.equals(THEN)){
            stream.println("=========END TEST=========");
        }
        stream.flush();
    }
}
