package com.programmers.calculator;

import com.programmers.calculator.entity.Operation;
import com.programmers.calculator.io.Console;
import com.programmers.calculator.processor.Calculator;
import com.programmers.calculator.processor.Validator;
import com.programmers.calculator.storage.OperationRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class Main {
    private final OperationRepository operationRepository;
    private final Console console;
    private final Calculator calculator;
    private final ModeExcuter modeExcuter;

    public Main(OperationRepository operationRepository, Console console, Calculator calculator, ModeExcuter modeExcuter) {
        this.operationRepository = operationRepository;
        this.console = console;
        this.calculator = calculator;
        this.modeExcuter = modeExcuter;
    }

    public void run() {
        while (true) {
            int mode = inputMode();
            try {
                modeExcuter.excute(operationRepository, calculator, console, mode);
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
