package com.programmers.calculator;

import com.programmers.calculator.io.Console;
import com.programmers.calculator.processor.Calculator;
import com.programmers.calculator.processor.Validator;
import com.programmers.calculator.storage.OperationStorage;

import java.util.regex.Pattern;

public class Main {
    private final OperationStorage operationStorage;
    private final Console console;
    private final Calculator calculator;
    private final ModeExecuter modeExecuter;

    public Main(OperationStorage operationStorage, Console console, Calculator calculator, ModeExecuter modeExecuter) {
        this.operationStorage = operationStorage;
        this.console = console;
        this.calculator = calculator;
        this.modeExecuter = modeExecuter;
    }

    public void run() {
        while (true) {
            int mode = inputMode();
            try {
                modeExecuter.excute(operationStorage, calculator, console, mode);
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputMode() {
        console.printlnString("");
        console.printlnString("1.조회");
        console.printlnString("2.계산");
        console.printlnString("");
        console.printString("선택 : ");

        String inputModeStr = console.inputStr();
        if (!Pattern.matches(Validator.NUMBER_REGEX, inputModeStr))
            throw new IllegalArgumentException("잘못된 기능을 입력하셨습니다.");

        return Integer.parseInt(inputModeStr);
    }
}
