package calculator.domain;

import calculator.exception.NotSolveEquationException;
import util.ValidationEquation;
import util.Brackets;
import util.OperatorMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostFixCalculator {
    public static Calculator parseCalculator(String equation) {
        validate(equation);

        double result = makeResult(equation);
        return new Calculator(equation, result);
    }

    private static void validate(String equation) {
        if (ValidationEquation.isDivByZero(equation)) {
            throw new NotSolveEquationException();
        }
    }

    private static double makeResult(String equation) {
        String[] equations = equation.split(" ");
        if (equations.length == 1) {
            return Double.parseDouble(equations[0]);
        }

        List<String> postFix = parseEquationToPostFix(equations);
        return calculate(postFix);
    }

    private static List<String> parseEquationToPostFix(String[] equations) {
        List<String> postFix = new ArrayList<>();
        Stack<String> operationList = new Stack<>();

        for (String input : equations) {
            eachInput(input, postFix, operationList);
        }

        while (!operationList.isEmpty()) {
            postFix.add(operationList.pop());
        }
        return postFix;
    }

    private static void eachInput(String input, List<String> postFix, Stack<String> operationList) {
        if (Brackets.isCloseBrackets(input)) {
            popOperates(postFix, operationList);
            return;
        }

        if (!(OperatorMap.contains(input) || Brackets.isOpenBrackets(input))) {
            postFix.add(input);
            return;
        }

        if (operationList.isEmpty()) {
            operationList.add(input);
            return;
        }

        int inputPriority = OperatorMap.priority(input);
        while (!operationList.isEmpty()) {
            if (Brackets.isOpenBrackets(operationList.peek())
                    || OperatorMap.priority(operationList.peek()) > inputPriority) {
                break;
            }

            postFix.add(operationList.pop());
        }
        operationList.add(input);
    }

    private static void popOperates(List<String> postFix, Stack<String> operationList) {
        while (!operationList.isEmpty()) {
            String operate = operationList.pop();

            if (Brackets.isOpenBrackets(operate)) {
                break;
            }

            postFix.add(operate);
        }
    }

    private static double calculate(List<String> postFix) {
        Stack<Double> result = new Stack<>();

        for (String data : postFix) {
            eachCalculate(data, result);
        }
        return result.pop();
    }

    private static void eachCalculate(String data, Stack<Double> result) {
        if (OperatorMap.contains(data)) {
            double back = result.pop();
            double front = result.pop();
            result.add(OperatorMap.calculate(data, front, back));
            return;
        }

        result.add(Double.parseDouble(data));
    }
}
