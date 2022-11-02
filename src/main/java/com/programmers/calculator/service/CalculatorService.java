package com.programmers.calculator.service;

import com.programmers.calculator.controller.io.ConsoleResponse;
import com.programmers.calculator.core.CalculatorProcessor;
import com.programmers.calculator.core.Expression;
import com.programmers.calculator.domain.CalculateHistory;
import com.programmers.calculator.repository.IdGenerator;
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

    public ConsoleResponse process(Expression expression) {
        Number calculateResult = calculatorProcessor.calculate(expression);

        String expressionString = expression.getExpressionString();

        CalculateHistory calculateHistory =
            new CalculateHistory(IdGenerator.getInstance().generateId(), expressionString, calculateResult);

        CalculateHistory savedHistory = repository.save(calculateHistory);

        return new ConsoleResponse(DecimalUtil.formatToString(savedHistory.getResult()));
    }

    public ConsoleResponse findAllOrderById() {
        List<CalculateHistory> calculateHistories = repository.findAllById();

        if (calculateHistories.isEmpty()) {
            return new ConsoleResponse("저장된 데이터가 없습니다.");
        }

        String result = calculateHistories.stream()
            .map(CalculateHistory::getHistory)
            .collect(Collectors.joining("\n"));

        return new ConsoleResponse(result);
    }

}
