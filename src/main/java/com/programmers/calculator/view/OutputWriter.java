package com.programmers.calculator.view;

import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.repository.CalculationHistory;

import java.util.List;

public class OutputWriter implements Output {

    @Override
    public void write(String message) {
        System.out.print(message);
    }

    @Override
    public void write(List<CalculationHistory> calculationHistories) {
        calculationHistories.forEach(System.out::println);
    }

    @Override
    public void write(CalculationResult result) {
        System.out.println(result);
    }

}
