package com.programmers.project;

public class Basic {
    public Double cal(Double num1, Double num2, String opt){
        switch (opt){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                return num1 / num2;
        }
    }
}
