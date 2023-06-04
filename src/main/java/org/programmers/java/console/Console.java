package org.programmers.java.console;

import org.programmers.java.message.InfoMsg;
import org.programmers.java.validation.Validation;

import java.util.Map;
import java.util.Scanner;

public class Console implements Input, Output {
    private Validation validation;
    private final Scanner scanner = new Scanner(System.in);

    public Console(Validation validation) {
        this.validation = validation;
    }

    @Override
    public String numInput() {
        String numInput = scanner.nextLine();
        return numInput;
    }

    @Override
    public String calculationInput() {
        String calculationInput = scanner.nextLine();
        Boolean validationCheck = validation.calculateValidation(calculationInput);
        return validationCheck == true ? calculationInput : "";
    }

    @Override
    public void menuMsg() {
        System.out.println(InfoMsg.SELECT_MESSGAE.getInfoMsg());
        System.out.println(InfoMsg.CALCULATION_MESSAGE.getInfoMsg());
        System.out.println(InfoMsg.EXIT_MESSAGE.getInfoMsg());
    }

    @Override
    public void errorMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void selectMsg(String selectNum) {
        System.out.println(InfoMsg.SELECT_NUM_MESSAGE.getInfoMsg() + selectNum);
    }

    @Override
    public void formulaMsg(String inputMsg) {
        System.out.println(inputMsg);
    }

    @Override
    public void calculationValue(String value) {
        System.out.println(value);
    }

    @Override
    public void getCalculationValues(Map<Long, String> values) {
        for (Long key : values.keySet()) {
            String value = values.get(key);
            System.out.println(value);
        }
    }

    @Override
    public void exitMsg() {
        System.out.println(InfoMsg.EXIT_INFO_MESSAGE.getInfoMsg());
    }
}
