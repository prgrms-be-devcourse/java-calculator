package com.programmers.java.calculator;

import com.programmers.java.calculator.calculate.Calculator;
import com.programmers.java.calculator.search.Searcher;
import com.programmers.java.view.Button;
import com.programmers.java.view.Input;
import com.programmers.java.view.Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    public void console(Calculator calculator, Searcher searcher) throws IOException {
        System.out.println("1.조회");
        System.out.println("2.계산");

        Input input = new Input();
        Output output = new Output();

        Button button = input.enterMenu();
        String menu = button.name();

        switch (menu) {
            case "CALCULATE":
                String expression = input.enterExpression();
                output.viewCalculateResult(calculator.getResult(expression));
                break;
            case "SEARCH":
                output.viewSearchResult(searcher.findAll());
                break;
        }

        console(calculator, searcher);
    }
}