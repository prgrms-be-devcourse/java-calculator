package calculator.domain;

import util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostFixCalculate implements Calculate{

    @Override
    public double calculate(String equation) {
        return makeResult(equation);
    }

    private double makeResult(String equation) {
        String[] equations = equation.split(" ");
        if (equations.length == 1) {
            return Double.parseDouble(equations[0]);
        }

        List<String> postFix = parseEquationToPostFix(equations);
        return solve(postFix);
    }

    private List<String> parseEquationToPostFix(String[] equations) {
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

    private void eachInput(String input, List<String> postFix, Stack<String> operationList) {
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

    private void popOperates(List<String> postFix, Stack<String> operationList) {
        while (!operationList.isEmpty()) {
            String operate = operationList.pop();

            if (Brackets.isOpenBrackets(operate)) {
                break;
            }

            postFix.add(operate);
        }
    }

    private double solve(List<String> postFix) {
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

            OperatorMap operatorMap = OperatorMap.getOperator(data);
            result.add(operatorMap.calculate(front, back));
            return;
        }

        result.add(Double.parseDouble(data));
    }


}
