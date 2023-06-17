package com.programmers.engine.model.command;

import com.programmers.engine.model.confirmation.Confirmation;

import java.util.Arrays;
import java.util.List;


public class CalculationCommand {

    private String calculationCommand;

    public CalculationCommand(String calculationCommand, Confirmation confirmation) {
        this.calculationCommand = calculationCommand;
        confirmation.validateCalculationCommand(calculationCommand);
    }

    public List<String> splitOperatorsAndOperands() {
        return Arrays.asList(this.calculationCommand.split(" "));
    }
}
