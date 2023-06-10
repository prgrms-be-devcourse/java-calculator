package org.programmers.java.console;

import org.programmers.java.message.FunctionSelect;
import org.programmers.java.message.Info;

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
    public String selectNumInput() {
        String numInput = scanner.nextLine();
        return numInput;
    }

    @Override
    public String formulaInput() {
        String formulaInput = scanner.nextLine();
        return formulaInput;
    }

    @Override
    public void menuMsg() {
        System.out.println(FunctionSelect.CHECK.getMsg());
        System.out.println(FunctionSelect.CALCULATION.getMsg());
        System.out.println(FunctionSelect.EXIT.getMsg());
    }

    @Override
    public void errorMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void selectMsg(String selectNum) {
        System.out.println(Info.SELECT_NUM.getMsg() + selectNum);
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
    public void getCalculationValues(Map<Long, String> calculationValues) {
        for (Long key : calculationValues.keySet()) {
            String value = calculationValues.get(key);
            System.out.println(value);
        }
    }

    @Override
    public void exitMsg() {
        System.out.println(Info.EXIT_INFO.getMsg());
    }
}
