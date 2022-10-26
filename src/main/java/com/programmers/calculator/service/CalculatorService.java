package com.programmers.calculator.service;

import com.programmers.calculator.controller.io.ConsoleResponse;
import com.programmers.calculator.controller.io.Response;
import com.programmers.calculator.core.Expression;
import com.programmers.calculator.core.CalculatorProcessor;
import com.programmers.calculator.domain.CalculateHistory;
import com.programmers.calculator.repository.Repository;
import com.programmers.calculator.util.DecimalUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorService {

    private final Repository<Long, CalculateHistory> repository;

    private final CalculatorProcessor calculatorProcessor = new CalculatorProcessor();

    public CalculatorService(Repository<Long, CalculateHistory> repository) {
        this.repository = repository;
    }

    public Response process(Expression expression) {
        Number result = calculatorProcessor.calculate(expression);

        String expressionString = expression.getExpressionString();

        CalculateHistory calculateHistory = new CalculateHistory(expressionString, result);

        CalculateHistory savedHistory = repository.save(calculateHistory);

        return new ConsoleResponse(DecimalUtil.formatToString(savedHistory.getResult()));
    }

    public Response findAllOrderById() {
        List<CalculateHistory> calculateHistories = repository.findAll();

        if (calculateHistories.isEmpty()) {
            return new ConsoleResponse("저장된 데이터가 없습니다.");
        }

        String result = calculateHistories.stream()
                .sorted(Comparator.comparingLong(CalculateHistory::getId))
                .map(CalculateHistory::getHistory)
                .collect(Collectors.joining("\n"));

        return new ConsoleResponse(result);
    }

}
