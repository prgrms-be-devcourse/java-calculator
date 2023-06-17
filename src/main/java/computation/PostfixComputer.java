package computation;

import validation.Validator;

import java.util.List;
import java.util.Stack;

public class PostfixComputer {
    public int calculate(List<String> postfixExpression) {
        Stack<Integer> calculationStack = new Stack<>();

        for (String item : postfixExpression) {
            if (Validator.isNumber(item)) {
                calculationStack.push(Integer.parseInt(item));
            } else if (Validator.isOperator(item)) {
                Integer operand2 = calculationStack.pop();
                Integer operand1 = calculationStack.pop();

                Operator operator = Operator.getOperator(item);
                calculationStack.push(operator.operate(operand1, operand2));
            }
        }
        return calculationStack.pop();
    }
}
