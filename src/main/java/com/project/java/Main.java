package com.project.java;

import com.project.java.engine.Calculator;
import com.project.java.engine.converter.StringExpressionConverter;
import com.project.java.engine.io.Console;
import com.project.java.engine.repository.MemoryRepository;
import com.project.java.engine.solver.FourWayPriorityStrategy;
import com.project.java.engine.solver.StackSolver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        StackSolver solver = new StackSolver(new FourWayPriorityStrategy(), new StringExpressionConverter<>());
        MemoryRepository repository = new MemoryRepository();

        new Calculator(console, console, solver, repository).run();
    }
}