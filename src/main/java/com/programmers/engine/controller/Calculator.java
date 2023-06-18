package com.programmers.engine.controller;

import com.programmers.engine.exception.CalculatorException;
import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;
import com.programmers.engine.model.command.SelectionCommand;
import com.programmers.engine.model.operation.Operation;
import com.programmers.engine.model.storage.Storage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable {
    private final Input input;
    private final Output output;
    private final Storage storage;
    private final Operation operation;

    @Override
    public void run() {
        while (true) {
            output.printStart();
            String selectionResult = input.choose();
            if (canNotOperation(selectionResult)) {
                continue;
            }
            break;
        }
    }

    private boolean canNotOperation(String selectionResult) {
        try {
            return operate(selectionResult);
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private boolean operate(String selectionResult) {
        return switch (SelectionCommand.getOption(selectionResult)) {
            case HISTORY -> {
                printCalculationHistory();
                yield true;
            }
            case CALCULATION -> {
                String calculationCommand = input.input();
                calculate(calculationCommand);
                yield true;
            }
        };
    }

    private void calculate(String calculationCommand) {
        try {
            Integer calculationResult = operation.calculate(calculationCommand);
            save(calculationCommand, calculationResult);
            printCalculationResult(calculationResult);
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printCalculationHistory() {
        output.printHistory(storage.findAll());
    }

    private void printCalculationResult(Integer calculationResult) {
        output.printResult(calculationResult);
    }

    private void save(String calculationCommand, Integer calculationResult) {
        storage.save(calculationCommand, calculationResult);
    }
}
