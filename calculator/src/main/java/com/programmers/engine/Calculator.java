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
            output.printStart();
            String selectionResult = input.choose();
            if (selectionResult.equals(CALCULATION)) {
                output.printResult(Operation.calculate(input.input()));
                continue;
            }
            if (selectionResult.equals(HISTORY)) {
                output.printHistory(storage.findHistory());
                continue;
            }
            break;
        }
    }
}
