package com.calculator.controller;

import com.calculator.common.BusinessException;
import com.calculator.common.MenuType;
import com.calculator.common.ValidatorHandler;
import com.calculator.io.Input;
import com.calculator.io.Output;
import com.calculator.service.CalculateService;

public class CalculateController {
    private final Input input;
    private final Output output;
    private final CalculateService calculateService;
    private final ValidatorHandler validatorHandler;

    private boolean isExited = false;

    public CalculateController(Input input, Output output, CalculateService calculateService, ValidatorHandler validatorHandler) {
        this.input = input;
        this.output = output;
        this.calculateService = calculateService;
        this.validatorHandler = validatorHandler;
    }

    public void run() {
        while (!isExited) {
            play();

            try {
                String inputType = input.command();
                MenuType menuType = MenuType.of(inputType);
                output.display("");

                switch (menuType) {
                    case FIND:
                        calculateService.getMap();
                        break;
                    case CAL:
                        String inputString = input.command();
                        validatorHandler.inputError(inputString);
                        String outputString = calculateService.calculate(inputString);
                        output.display(outputString);
                        break;
                    case END:
                        isExited = true;
                        break;
                }
            } catch (BusinessException businessException) {
                output.display(businessException.getMessage());
            }
        }
    }

    private void play() {
        System.out.println("\n1. 조회\n2. 계산\n3. 끝");
        System.out.print("\n선택 : ");
    }
}
