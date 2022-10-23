package calculator.operation;

import calculator.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OperationManager implements Service{

    private final Validator validator;

    public OperationManager(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<String> toPostFix(List<String> tokens) {

        Stack<String> stack = new Stack<>();
        List<String> postFix = new ArrayList<>();
        for (String s : tokens) {

            if (validator.isNumber(s)) {
                postFix.add(s);
            } else {
                Operation operation = Operation.getOperator(s);
                while (!stack.empty() && operation.getPriority().compareTo(Operation.getOperator(stack.peek()).getPriority()) < 0) {
                    postFix.add(stack.pop());
                }
                stack.push(s);
            }

        }
        while (!stack.empty()) {
            postFix.add(stack.pop());
        }
        return postFix;

    }

    @Override
    public String calculate(List<String> postFix) {

        Stack<String> stack = new Stack<>();
        for (String s : postFix) {
            if (validator.isNumber(s)) {
                stack.push(s);
            } else {
                if (stack.size() < 2) break;
                double second = Double.parseDouble(stack.pop());
                double first = Double.parseDouble(stack.pop());
                Operation operation = Operation.getOperator(s);
                String calculate = String.valueOf(operation.calculate(first, second));
                stack.push(calculate);
            }
        }

        return stack.pop();

    }

}

