package calculator.calculator.notation.parser;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static calculator.calculator.operator.OperatorPriority.*;
import static calculator.calculator.operator.OperatorPriority.isOperator;

public class NotationPostfixParser implements NotationParser {

    @Override
    public List<String> parseFrom(List<String> formulas) {
        Deque<String> operators = new ArrayDeque<>();
        List<String> notation = new ArrayList<>();

        formulas.forEach(formula -> {
            if (isOperator(formula)) {
                if (checkPopAll(operators, formula)) {
                    addOperatorsToNotation(operators, notation);
                }
                operators.add(formula);
            }
            if (!isOperator(formula)) {
                notation.add(formula);
            }
        });

        return notation;
    }

    private static void addOperatorsToNotation(Deque<String> operators, List<String> notation) {
        while (!operators.isEmpty()) {
            notation.add(operators.pollLast());
        }
    }

    private static boolean checkPopAll(Deque<String> operators, String formula) {
        return !operators.isEmpty() &&
                findOperator(operators.peekLast())
                        .isSameOrMoreImportantThan(formula);
    }
    
}
