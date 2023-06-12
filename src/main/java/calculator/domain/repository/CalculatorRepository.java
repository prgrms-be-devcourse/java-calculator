package calculator.domain.repository;

import calculator.domain.Expression;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorRepository {
    private final Map<Expression, Integer> history = new LinkedHashMap<>();

    public void save(Expression expression, int result) {
        history.put(expression, result);
    }

    public Map<Expression, Integer> findAll() {
        return Collections.unmodifiableMap(history);
    }
}
