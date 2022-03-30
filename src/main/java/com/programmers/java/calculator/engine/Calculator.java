package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.exception.CalculatorException;
import com.programmers.java.calculator.engine.exception.InputException;
import com.programmers.java.calculator.engine.io.Input;
import com.programmers.java.calculator.engine.io.Output;
import lombok.AllArgsConstructor;

import java.util.regex.Pattern;

@AllArgsConstructor
public class Calculator implements Runnable {
    private Calculation calculation;
    private HistoryStore historyStore;
    private Input input;
    private Output output;

    @Override
    public void run() {
        final int SELECT_HISTORY = 1;
        final int SELECT_CALCULATION = 2;
        final int SELECT_TERMINATE = 3;

        while (true) {
            output.print("1. 조회");
            output.print("2. 계산");
            output.print("3. 종료");
            String selectString = input.select("선택 : ");
            try {
                int selectNum = parse(selectString);
                if (selectNum == SELECT_HISTORY) {
                    historyStore.show(output);
                } else if (selectNum == SELECT_CALCULATION) {
                    String inputString = input.inputQuestion();
                    Integer result = calculation.calculate(inputString);
                    output.printResult(result);
                } else if (selectNum == SELECT_TERMINATE) {
                    output.print("계산기를 종료합니다.");
                    break;
                } else {
                    throw new CalculatorException("잘못된 입력을 잡아내지 못했습니다.");
                }
            } catch(InputException ex) {
                output.printInputException(ex.getMessage());
            } catch(CalculatorException ex) {
                output.printCalculatorException(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    private Integer parse(String selectString) {
        if (Pattern.matches("[^1-3]", selectString)) {
            throw new InputException("알맞은 번호를 선택해주세요.");
        }
        return Integer.parseInt(selectString);
    }
}
