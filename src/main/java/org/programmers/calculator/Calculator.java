package org.programmers.calculator;

import org.programmers.Io.Console;

import java.lang.invoke.WrongMethodTypeException;

public class Calculator {


    private final Console console;

    public Calculator(Console console) {
        this.console = console;
    }

    boolean isRunning = true;

    public void run() {
        while (isRunning) {
            console.printOption();
            String inputNum = (console.inputNum());
            Option option = ChangeOption(inputNum);
            if (option == null)
                continue;

            switch (option){
                case QUERY:
                    System.out.println("console.printQuery();");
                    break;
                case CALC:
                    System.out.println("console.printCalc();");
                    break;
                case EXIT:
                    isRunning = false;
                    System.out.println("계산기 종료");
                    break;
            }

        }
    }

    //문자열을 이넘타입으로 변환하는 메서드
    private Option ChangeOption(String inputNum) {
        Option option = null;

        try {
            option = Option.findByNumber(inputNum);
        } catch (WrongMethodTypeException e) {
            console.printError(e.getMessage());
        }
        return option;
    }
}
