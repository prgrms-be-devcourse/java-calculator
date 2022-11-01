package com.calculator.io;

import com.calculator.common.BaseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface Input {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String inputType() throws IOException;
    String inputNum() throws IOException, BaseException;
}
