package calculator.engine.repository;

import calculator.application.io.enums.Characters;
import calculator.application.io.enums.Message;
import calculator.engine.model.CalculationResult;
import calculator.engine.model.Expression;

import java.util.*;
import java.util.stream.Collectors;

public class CalculationHistory implements History {
    private final Map<Long, Map<Expression, CalculationResult>> history = new LinkedHashMap<>();
    private long sequence = 0L;

    @Override
    public void record(Expression infix, CalculationResult result) {
        Map<Expression, CalculationResult> operation = new HashMap<>();
        operation.put(infix, result);
        history.put(++sequence, operation);
    }

    @Override
    public List<String> getLiterals() {
        if (history.isEmpty()) {
            List<String> literal = new ArrayList<>();
            literal.add(Message.EMPTY_HISTORY_ALERT.toString());
            return literal;
        }

        return history.keySet().stream()
                .flatMap(sequence -> history.get(sequence).keySet().stream()
                        .map(expression ->
                                sequence.toString()
                                        + Characters.DOT
                                        + Characters.BLANK
                                        + expression.getLiteral()
                                        + Characters.BLANK
                                        + Characters.EQUALS_SIGN
                                        + Characters.BLANK
                                        + history.get(sequence).get(expression).getResult()
                        )
                )
                .collect(Collectors.toList());
    }

    public Map<Long, Map<Expression, CalculationResult>> getHistory() {
        return history;
    }
}
