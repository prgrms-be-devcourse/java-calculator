package calculator.calculator.notation.parser;

import calculator.calculator.formula.Formula;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static calculator.calculator.operator.Operators.isLeftSameOrMoreImportantThan;
import static calculator.calculator.operator.Operators.isOperator;

public class NotationPostfixParser implements NotationParser {

    private final Deque<String> operators = new ArrayDeque<>();

    @Override
    public Formula parseFrom(Formula formulas) {
        initParser();

        Formula notation = new Formula(new ArrayList<>());
        formulas.getFormulaPieces()
                .forEach(formula -> {
                    handleOperator(notation, formula);
                    handleOperand(notation, formula);
                });
        handleLastOperands(notation.getFormulaPieces());

        return notation;
    }

    private void handleLastOperands(List<String> notation) {
        while (!operators.isEmpty()) {
            notation.add(operators.pollLast());
        }
    }

    private void initParser() {
        operators.clear();
    }

    private void handleOperand(Formula notation, String formula) {
        if (!isOperator(formula)) {
            notation.add(formula);
        }
    }

    private void handleOperator(Formula notation, String formula) {
        if (isOperator(formula)) {
            addOperationsByComparingPriority(notation.getFormulaPieces(), formula);
            operators.add(formula);
        }
    }

    private void addOperationsByComparingPriority(List<String> notation, String formula) {
        if (checkPopAll(formula)) {
            addOperatorsToNotation(notation);
        }
    }

    private void addOperatorsToNotation(List<String> notation) {
        while (!operators.isEmpty()) {
            notation.add(operators.pollLast());
        }
    }

    private boolean checkPopAll(String operator) {
        return !operators.isEmpty()
                && isLeftSameOrMoreImportantThan(operators.peekLast(), operator);
    }

}
