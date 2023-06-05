import java.util.Stack;

public class Calculator {

    public static double calculate(String infixExpression) {
        String postfixExpression = toPostfix(infixExpression.split(" "));
        Stack<Double> operandStack = new Stack<>();

        for (String value : postfixExpression.split(" ")) {
            if (isNumber(value)) {
                operandStack.push(Double.parseDouble(value));
            } else {
                double left = operandStack.pop();
                double right = operandStack.pop();
                double midResult = CalculateType.findBySymbol(value).calculate(left, right);
                operandStack.push(midResult);
            }
        }
        double result = operandStack.pop();

        return result;
    }

    private static String toPostfix(String[] infixExpression) {
        Stack<String> operatorStack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();

        for (String value : infixExpression) {

            if (isNumber(value)) {
                postfixExpression.append(value + " ");
            }
            else {
                //연산자라면 -> 스택에 담긴 연산자와 우선순위를 비교해 순서대로 넣음
                CalculateType calculateType = CalculateType.findBySymbol(value);
                while (!postfixExpression.isEmpty() && !operatorStack.isEmpty() &&
                        calculateType.getPriority() < CalculateType.findBySymbol(operatorStack.peek()).getPriority()) {
                    postfixExpression.append(operatorStack.pop() + " ");
                }
                operatorStack.push(value);
            }
        }
        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop() + " ");
        }
        return postfixExpression.toString();
    }

    private static boolean isNumber(String value) {
        if (value.matches("[0-9]+")) {
            return true;
        }
        return false;
    }
}
