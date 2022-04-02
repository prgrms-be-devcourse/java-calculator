package com.kimhunki.java.calculator;

import com.kimhunki.java.calculator.db.MemoryResultRepository;
import com.kimhunki.java.calculator.db.ResultRepository;
import com.kimhunki.java.calculator.engine.Selector;
import com.kimhunki.java.calculator.io.Input;
import com.kimhunki.java.calculator.io.Output;
import com.kimhunki.java.calculator.model.InfixCalculator;
import com.kimhunki.java.calculator.model.Parser;
import com.kimhunki.java.calculator.strategy.CalculatorStrategy;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        Parser parser = new Parser();
        ResultRepository resultRepository = new MemoryResultRepository(new ArrayList<>());
        new Selector(console, console, parser, resultRepository).run();
    }
}
