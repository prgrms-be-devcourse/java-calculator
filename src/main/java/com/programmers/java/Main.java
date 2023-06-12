package com.programmers.java;

import com.programmers.java.calculator.Controller;
import com.programmers.java.calculator.calculate.Calculator;
import com.programmers.java.calculator.search.Searcher;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.console(new Calculator(), new Searcher());
    }
}