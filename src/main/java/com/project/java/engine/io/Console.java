package com.project.java.engine.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements Input, Output{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public String getInput(String greeting) throws IOException {
        return "";
    }

    @Override
    public void output(String str) {

    }
}
