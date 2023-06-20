package com.programmers.core.converter;

import com.programmers.core.Operators;
import com.programmers.core.Priority;
import com.programmers.core.data.CalculationRequest;
import com.programmers.util.StringUtil;
import com.programmers.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter implements Converter {
    private static final String SEPARATOR = " ";

    @Override
    public List<String> convert(CalculationRequest request) {
        String formula = request.getFormula();
        Validator.checkNull(formula);

        String[] splitFormula = formula.split(SEPARATOR);
        Validator.checkEmpty(splitFormula);

        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (int position = 0; position < splitFormula.length; position++) {
            String eachFormula = splitFormula[position];

            if (Validator.isOperatorCheck(position)) {
                putOperator(eachFormula, postfix, stack);
            } else {
                putOperand(eachFormula, postfix);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix;
    }

    private void putOperator(String operator, List<String> postfix, Stack<String> operatorStack) {
        if (!Operators.isOperator(operator)) ;

        if (operatorStack.isEmpty() || Priority.isNewOperatorPriorityHigher(operator, operatorStack)) {
            operatorStack.push(operator);
            return;
        }

        while (!operatorStack.isEmpty() && Priority.isNewOperatorPriorityLower(operator, operatorStack)) {
            postfix.add(operatorStack.pop());
        }

        operatorStack.push(operator);
    }

    private void putOperand(String operand, List<String> postfix) {
        if (!StringUtil.isNumber(operand)) {
            throw new NumberFormatException();
        }
        postfix.add(operand);
    }
}