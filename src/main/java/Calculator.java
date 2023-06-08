import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Calculator {
    private final Deque<Integer> operands;
    private final Deque<Operator> operators;

    public Calculator() {
        this.operands = new ArrayDeque<>();
        this.operators = new ArrayDeque<>();
    }

    public int calculate(String expression) {
        String[] arguments = expression.split(" ");
        checkEmptyArguments(arguments);

        Arrays.stream(arguments).forEach(argument -> {
            checkValidArgument(argument);
            pushOperator(argument);
            pushOperand(argument);
        });

        return getResult();
    }

    private void checkEmptyArguments(String[] arguments) {
        if (isNoExpression(arguments)) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자 혹은 연산자를 입력해주세요.");
        }
    }

    private void checkValidArgument(String argument) {
        if (!isValidArgument(argument)) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자 혹은 연산자를 입력해주세요.");
        }
    }

    private void pushOperator(String argument) {
        if (isOperator(argument)) {
            operators.push(Operator.getValue(argument));
        }
    }

    private void pushOperand(String argument) {
        if (isNumber(argument)) {
            operands.push(Integer.parseInt(argument));
        }
    }

    private int getResult() {
        while (!operators.isEmpty()) {
            Operator operator = operators.pop();
            checkPlusAndAdd(operator);
            checkMinusAndSub(operator);
        }

        checkValidCalculation();
        return operands.pop();
    }

    private void checkPlusAndAdd(Operator operator) {
        if (operator.equals(Operator.PLUS)) {
            addNumbers();
        }
    }

    private void checkMinusAndSub(Operator operator) {
        if (operator.equals(Operator.MINUS)) {
            subNumbers();
        }
    }

    private boolean isNoExpression(String[] arguments) {
        return arguments.length == 0;
    }

    private boolean isValidArgument(String argument) {
        return isNumber(argument) || isOperator(argument);
    }

    private void checkValidCalculation() {
        if (operands.size() != 1) {
            throw new RuntimeException("[ERROR] 올바른 결과를 얻을 수 없습니다.");
        }
    }

    private void addNumbers() {
        int rightOperand = operands.pop();
        int leftOperand = operands.pop();
        operands.push(leftOperand + rightOperand);
    }

    private void subNumbers() {
        int rightOperand = operands.pop();
        int leftOperand = operands.pop();
        operands.push(leftOperand - rightOperand);
    }

    private boolean isNumber(String argument) {
        try {
            Integer.parseInt(argument);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String argument) {
        return Operator.isValidOperator(argument);
    }
}
