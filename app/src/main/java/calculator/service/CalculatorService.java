package calculator.service;

import calculator.domain.CalculationResultHistory;
import calculator.domain.Calculator;

import java.util.List;

public class CalculatorService {

    private final Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public String getAllData() {
        StringBuilder sb = new StringBuilder();
        List<CalculationResultHistory> histories = calculator.getAllData();
        for (CalculationResultHistory history : histories) {
            sb.append(history).append("\n");
        }
        if (histories.size() == 0)
            return "> 조회할 데이터가 없습니다";
        else {
            return sb.toString();
        }
    }

    public String calculate(String expression) {
        return calculator.calculate(expression);
    }

    public String exit() {
        return "> 계산기 프로젝트를 종료합니다";
    }
}
