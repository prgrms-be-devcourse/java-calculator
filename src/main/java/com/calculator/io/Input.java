package com.calculator.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface Input {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int inputType() throws IOException;
    String inputNum() throws IOException;
}
