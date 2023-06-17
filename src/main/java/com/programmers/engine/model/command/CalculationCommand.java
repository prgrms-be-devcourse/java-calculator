package com.programmers.engine.model.command;

import com.programmers.engine.model.confirmation.Confirmation;

import java.util.Arrays;
import java.util.List;

public class CalculationCommand {

    private final Confirmation confirmation;

    private String calculationCommand;

    public CalculationCommand(String calculationCommand) {
        this.calculationCommand = calculationCommand;
        this.confirmation = new Confirmation();
        confirmation.validateCalculationCommand(calculationCommand);
    }

    public List<String> splitOperatorsAndOperands() {
        return Arrays.asList(this.calculationCommand.split(" "));
    }
}
