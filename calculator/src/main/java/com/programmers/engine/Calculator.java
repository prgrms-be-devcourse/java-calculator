package com.programmers.engine;

import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;
import com.programmers.engine.model.Operation;
import com.programmers.engine.model.Storage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable {
    public static final String CALCULATION = "2";
    public static final String HISTORY = "1";

    private final Input input;
    private final Output output;
    private final Storage storage;

    @Override
    public void run() {
        while (true) {
            try {
                output.printStart();
                String selectionResult = input.choose();
                if (canCalculate(selectionResult)) continue;
                if (canFind(selectionResult)) continue;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean canFind(String selectionResult) {
        if (selectionResult.equals(HISTORY)) {
            output.printHistory(storage.findAll());
            return true;
        }
        return false;
    }

    private boolean canCalculate(String selectionResult) {
        if (selectionResult.equals(CALCULATION)) {
            String calculationCommand = input.input();
            Integer calculationResult = Operation.calculate(calculationCommand);
            storage.save(calculationCommand, calculationResult);
            output.printResult(calculationResult);
            return true;
        }
        return false;
    }
}
