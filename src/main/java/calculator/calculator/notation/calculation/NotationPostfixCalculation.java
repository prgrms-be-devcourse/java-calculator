package calculator.calculator.notation.calculation;

import calculator.calculator.operator.Operators;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

import static calculator.calculator.operator.Operators.isOperator;
import static calculator.exception.NotationException.NOTATION_POSTFIX_NULL_EXCEPTION;

public class NotationPostfixCalculation implements NotationCalculation {

    private final Deque<BigDecimal> operands = new ArrayDeque<>();

    @Override
    public BigDecimal calculate(List<String> formulas) {
        initCalculation();

        formulas.forEach(formula -> {
            handleOperator(formula);
            handleOperand(formula);
        });

        return getOperand();
    }

    private void initCalculation() {
        operands.clear();
    }

    private void handleOperand(String formula) {
        if (isOperand(formula)) {
            operands.addLast(
                    BigDecimal.valueOf(
                            Double.parseDouble(formula)));
        }
    }

    private void handleOperator(String formula) {
        if (isOperator(formula)) {
            BigDecimal rightOperand = getOperand();
            BigDecimal leftOperand = getOperand();
            operands.add(
                    Operators.calculate(leftOperand, formula, rightOperand)
            );
        }
    }

    private static boolean isOperand(String formula) {
        return !isOperator(formula);
    }

    private BigDecimal getOperand() {
        if (operands.isEmpty()) {
            throw new NullPointerException(NOTATION_POSTFIX_NULL_EXCEPTION.message);
        }
        return operands.pollLast();
    }

}
