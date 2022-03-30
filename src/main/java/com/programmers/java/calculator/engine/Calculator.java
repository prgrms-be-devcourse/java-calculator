package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.io.Input;
import com.programmers.java.calculator.engine.io.Output;
import lombok.AllArgsConstructor;

import java.util.Optional;

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

        while (true) {
            output.print("1. 조회");
            output.print("2. 계산");
            output.print("3. 종료");
            String selectString = input.select("선택 : ");
            Optional<Integer> selectNum = parse(selectString);
            if (selectNum.isEmpty()) {
                output.printError("알맞은 숫자를 입력해주세요.");
            }else if (SELECT_HISTORY == selectNum.get()) {
                historyStore.show(output);
            } else if(SELECT_CALCULATION == selectNum.get()) {
                String inputString = input.inputQuestion();
                Optional<Integer> result = calculation.calculate(inputString);
                if (result.isEmpty()) {
                    output.printError("잘못된 입력 형식입니다.");
                    continue;
                }
                output.printResult(result.get());
            } else{
                break;
            }
        }
    }

    private Optional<Integer> parse(String selectString) {
        try {
            int inputNumber = Integer.parseInt(selectString);
            if (inputNumber > 3 || inputNumber < 1) {
                throw new NumberFormatException();
            }
            return Optional.of(inputNumber);
        } catch(NumberFormatException e){
            return Optional.empty();
        }
    }
}
