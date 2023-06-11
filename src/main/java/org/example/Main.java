package org.example;

import org.example.domain.Calculator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.getInstance();
        System.out.println(calc.run("(50+50)*15"));
        System.out.println(calc.run("1+2*3+(4+2)/2"));
    }
}