package com.programmers.calculator;

import com.programmers.calculator.entity.Operation;
import com.programmers.calculator.io.Console;
import com.programmers.calculator.processor.Calculator;
import com.programmers.calculator.storage.OperationRepository;

public class ModeExcuter {
    public void excute(OperationRepository operationRepository, Calculator calculator, Console console, int mode) {
        switch (mode) {
            case 1:
                Operation operation = calculator.excute(console.inputStr());
                operationRepository.save(operation);
                System.out.println(operation);
            case 2:
                if (operationRepository.isEmpty()){
                    console.printNoOperation();
                } else {
                    console.printHistory(operationRepository);
                }
        }
    }
}
