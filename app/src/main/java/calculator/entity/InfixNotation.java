package calculator.entity;

import static calculator.entity.Operator.getOperatorWithSameSymbol;
import static calculator.utils.StringUtils.isNumeric;
import static calculator.utils.StringUtils.splitToElements;

import java.util.Optional;
import java.util.Stack;

public class InfixNotation implements Notation {

    @Override
    public String[] makeElements(String expression) {
        return splitToElements(expression);
    }

    @Override
    public Optional<Expression> makeExpression(Stack<Integer> operands, Stack<Operator> operators,
        String element) {
        if (!isNumeric(element)) {
            Operator operator = getOperatorWithSameSymbol(element);
            operators.push(operator);

            return Optional.empty();
        }

        if (operators.isEmpty()) {
            int operand = Integer.parseInt(element);
            operands.push(operand);

            return Optional.empty();
        }

        Operator operator = operators.pop();
        int operand1 = operands.pop();
        int operand2 = Integer.parseInt(element);

        return Optional.of(new Expression(operator, operand1, operand2));
    }
}
