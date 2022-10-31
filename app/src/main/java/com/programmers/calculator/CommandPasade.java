package com.programmers.calculator;

import com.programmers.calculator.entity.Operation;
import com.programmers.calculator.io.Console;
import com.programmers.calculator.processor.Calculator;
import com.programmers.calculator.storage.OperationStorage;

public class CommandPasade {
    public void excute(OperationStorage operationStorage, Calculator calculator, Console console, int command) {
        switch (command) {
            case 1: // 주어진 연산 수행
                Operation operation = calculator.excute(console.inputStr());
                operationStorage.save(operation);
                System.out.println(operation);
            case 2: // 이전 모든 연산 결과 출력
                if (operationStorage.isEmpty()){
                    console.printNoOperation();
                } else {
                    console.printLastAllOperation(operationStorage);
                }
        }
    }
}
