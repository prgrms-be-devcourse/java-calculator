package com.programmers.java.calculator.io;

import java.util.List;

public class ConsoleOutput implements Output{
    @Override
    public void outputResult(double result) {
        System.out.println(result);
    }

    @Override
    public void outputHistory(List<String> history) {
        for(String s: history){
            System.out.println(s);
        }
    }
}
