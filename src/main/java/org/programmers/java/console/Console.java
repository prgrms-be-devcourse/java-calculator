package org.programmers.java.console;

import org.programmers.java.message.InfoMsg;
import org.programmers.java.validation.Validation;

import java.util.Map;
import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);

    private Console() {}

    private static class ConsoleSingleton {
        private static final Console consoleInstance = new Console();
    }

    public static Console getInstance(){
        return ConsoleSingleton.consoleInstance;
    }


    @Override
    public String numInput() {
        String numInput = scanner.nextLine();
        return numInput;
    }

    @Override
    public String calculationInput() {
        String calculationInput = scanner.nextLine();
        return calculationInput;
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
