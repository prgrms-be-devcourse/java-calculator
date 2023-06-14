package com.programmers.calculator.view;

import com.programmers.calculator.repository.CalculationHistory;

import java.math.BigDecimal;
import java.util.List;

public class OutputConsole implements Output {

    @Override
    public void outputOption() {
        System.out.println("\n0. 종료");
        System.out.println("1. 조회");
        System.out.println("2. 계산");
    }

    @Override
    public void outputExit() {
        System.out.println("프로그램이 종료됩니다.");
    }

    @Override
    public void outputHistory(List<CalculationHistory> calculationHistories) {
        calculationHistories.forEach(System.out::println);
    }

    @Override
    public void outputCalculation(BigDecimal result) {
        System.out.println(result);
    }
}
