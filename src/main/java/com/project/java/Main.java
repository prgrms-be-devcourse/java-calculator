package com.project.java;

import com.project.java.engine.Calculator;
import com.project.java.engine.io.Console;
import com.project.java.engine.repository.AutoIncrementSequencer;
import com.project.java.engine.repository.MemoryRepository;
import com.project.java.engine.solver.FourWayPriorityStrategy;
import com.project.java.engine.solver.PostfixSolver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        PostfixSolver solver = new PostfixSolver(new FourWayPriorityStrategy());
        MemoryRepository repository = new MemoryRepository(new AutoIncrementSequencer());

        new Calculator(console, console, solver, repository).run();
    }
}