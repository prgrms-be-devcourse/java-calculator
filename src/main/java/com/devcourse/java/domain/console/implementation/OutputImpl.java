package com.devcourse.java.domain.console.implementation;

import com.devcourse.java.domain.console.Output;

public class OutputImpl implements Output {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
