package calculator.entity;

import java.util.Optional;
import java.util.Stack;

public interface Notation {

    String[] makeElements(String expression);

    Optional<Expression> makeExpression(Stack<Integer> operands, Stack<Operator> operators,
        String element);
}
