package com.programmers.calculator;

import com.programmers.calculator.entity.Operation;
import com.programmers.calculator.io.Console;
import com.programmers.calculator.processor.Calculator;
import com.programmers.calculator.storage.OperationStorage;

public class ModeExecuter {
    public void excute(OperationStorage operationStorage, Calculator calculator, Console console, int mode) {
        switch (mode) {
            case 1:
                Operation operation = calculator.excute(console.inputStr());
                operationStorage.save(operation);
                System.out.println(operation);
            case 2:
                if (operationStorage.isEmpty()){
                    console.printNoOperation();
                } else {
                    console.printHistory(operationStorage);
                }
        }
    }
}
