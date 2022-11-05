package calculator.calculator.notation.calculation;

import calculator.calculator.formula.Formula;
import calculator.calculator.operator.Operators;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

import static calculator.calculator.operator.Operators.isOperator;
import static calculator.exception.NotationException.NOTATION_POSTFIX_NULL_EXCEPTION;

public class NotationPostfixCalculation implements NotationCalculation {

    private final Deque<BigDecimal> operands = new ArrayDeque<>();

    @Override
    public CalculationResult calculate(Formula formula) {
        initCalculation();

        formula.getFormulaPieces()
                .forEach(formulaPiece -> {
                    handleOperator(formulaPiece);
                    handleOperand(formulaPiece);
                });

        return new CalculationResult(getOperand().stripTrailingZeros().toPlainString());
    }

    private void initCalculation() {
        operands.clear();
    }

    private void handleOperand(String formula) {
        if (isOperand(formula)) {
            operands.addLast(new BigDecimal(formula));
        }
    }

    private void handleOperator(String formula) {
        if (isOperator(formula)) {
            BigDecimal rightOperand = getOperand();
            BigDecimal leftOperand = getOperand();
            BigDecimal calculatedOperand =
                    Operators.calculate(leftOperand, formula, rightOperand);
            operands.add(calculatedOperand);
        }
    }

    private boolean isOperand(String formula) {
        return !isOperator(formula);
    }

    private BigDecimal getOperand() {
        if (operands.isEmpty()) {
            throw new NullPointerException(NOTATION_POSTFIX_NULL_EXCEPTION.getMessage());
        }
        return operands.pollLast();
    }

}
