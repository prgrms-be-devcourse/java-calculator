package com.programmers.oop;

import com.programmers.oop.validation.Validation;
import java.io.IOException;
import java.util.List;

import com.programmers.oop.message.FrontMessage;
import com.programmers.oop.service.ComputeService;
import com.programmers.oop.service.LookUpService;
import com.programmers.oop.service.Service;
import com.programmers.oop.type.ServiceType;
import com.programmers.oop.utils.ParserUtils;
import com.programmers.oop.view.Console;
import com.programmers.oop.view.Input;
import com.programmers.oop.view.Output;

public class CalculatorMachine {

    private final Input input;
    private final Output output;
    private final ComputeService<String> computeService;
    private final LookUpService<String> lookUpService;
    private final Validation inputValidation;

    public CalculatorMachine(Console console, Validation validation, Service service) {
        input = console;
        output = console;
        inputValidation = validation;
        computeService = service;
        lookUpService = service;
    }

    public void start() throws IOException {
        while (true) {
            output.showMessage(FrontMessage.MENU_LIST.getMessage());
            String menu = input.readInput();
            if (ServiceType.LOOK_UP.isSameYn(menu)) {
                List<String> responses = lookUpService.findByAll();
                output.showMessage(responses == null ? FrontMessage.NOT_EXIST_DATA.getMessage()
                    : ParserUtils.toString(responses));
            } else if (ServiceType.COMPUTE.isSameYn(menu)) {
                output.showMessage(FrontMessage.FORMULA.getMessage());
                String formula = input.readInput();
                String validExpression = inputValidation.verifyExpression(formula);
                output.showMessage(computeService.computeExpression(validExpression)
                    + FrontMessage.RESULT_LINE.getMessage());
            } else if (ServiceType.EXIT.isSameYn(menu)) {
                break;
            } else {
                output.showMessage(FrontMessage.CLIENT_ERROR.getMessage());
            }
        }


    }

}
