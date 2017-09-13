package com.codehackerr.simple.bdd;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
    public void start(String description) {
        stream.print(description);
    }

    @Override
    public void finish(String description) {
        stream.println("- OK");
    }
}
