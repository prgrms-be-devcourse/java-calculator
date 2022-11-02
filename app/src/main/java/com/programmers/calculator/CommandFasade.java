package com.programmers.calculator;

import com.programmers.calculator.entity.Operation;
import com.programmers.calculator.io.Console;
import com.programmers.calculator.processor.Calculator;
import com.programmers.calculator.storage.OperationStorage;

import static com.programmers.calculator.CommandStatus.*;

public class CommandFasade {
    public void excute(OperationStorage operationStorage, Calculator calculator, Console console, CommandStatus command) {
        switch (command) {
            case CALCULATE: // 주어진 연산 수행
                Operation operation = calculator.excute(console.inputStr());
                operationStorage.save(operation);
                System.out.println(operation);
            case PRINT_LAST_ALL_OPERATION_RESULT: // 이전 모든 연산 결과 출력
                if (operationStorage.isEmpty()){
                    console.printNoOperation();
                } else {
                    console.printLastAllOperation(operationStorage);
                }
        }
    }
}
