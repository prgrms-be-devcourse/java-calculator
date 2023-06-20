package com.programmers.calculator.view;

import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.repository.CalculationHistory;

import java.util.List;

public class Console {

    private final Input input;
    private final Output output;
    private final String newLine = System.getProperty("line.separator");

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public String inputOption() {
        output.write(newLine + newLine + "선택 : ");
        return input.read();
    }

    public String inputExpression() {
        return input.read();
    }

    public void outputOption() {
        output.write(newLine + "0. 종료");
        output.write(newLine + "1. 조회");
        output.write(newLine + "2. 계산");
    }

    public void outputExit() {
        output.write("프로그램이 종료됩니다.");
    }

    public void outputHistory(List<CalculationHistory> calculationHistories) {
        output.write(calculationHistories);
    }

    public void outputCalculation(CalculationResult result) {
        output.write(result);
    }
}
