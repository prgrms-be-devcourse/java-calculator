package com.programmers.engine.model.operation;

import com.programmers.engine.model.command.CalculationCommand;
import com.programmers.engine.model.confirmation.Confirmation;
import com.programmers.engine.model.stack.CalculationStack;

import java.util.List;
import java.util.Stack;

public class Operation {

    private CalculationStack calculationStack;
    private final Confirmation confirmation;

    public Operation(Confirmation confirmation) {
        this.confirmation = confirmation;
    }

    public Integer calculate(String command) {
        CalculationCommand calculationCommand = new CalculationCommand(command, confirmation);
        List<String> operatorsAndOperands = calculationCommand.splitOperatorsAndOperands();
        calculationStack = new CalculationStack(new Stack<>(), new Stack<>(), confirmation);
        return calculationStack.popAnswer(operatorsAndOperands);
    }
}
