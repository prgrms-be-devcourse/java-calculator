package com.programmers.java.service;

import com.programmers.java.tokenizer.Tokenizer;
import com.programmers.java.enums.Operator;

import java.util.*;

public class CalculateServiceImpl implements CalculateService {

    private final String REGEX = "[-]?\\d*(\\.\\d+)?";
    private final String MINUS_SIGN = "-";
    private final Tokenizer tokenizer;

    public CalculateServiceImpl(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    /**
     * 계산식(중위표기식)을 파라미터로 받고 후위표기식으로 변환 후 계산
     * @param formula
     * @return 계산 결과
     */
    @Override
    public int calculateFormula(String formula) {
        List<String> formulaList = tokenizer.tokenizeFormula(formula);
        List<String> postfixFormulaList = convertInfixToPostFix(formulaList);

        // 후위 표기식 계산
        Stack<Integer> numStack = new Stack<>();
        for (String token : postfixFormulaList) {

            if (!token.equals("MINUS_SIGN") && token.matches(REGEX)) {
                numStack.push(Integer.parseInt(token));
                continue;
            }

            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int result = Operator.calculate(token, num1, num2);

            numStack.push(result);
        }

        return numStack.pop();
    }

    /**
     * 중위 표기식 -> 후위 표기식 변환
     * @param infixFormulaList
     * @return 후위표기식
     */
    @Override
    public List<String> convertInfixToPostFix(List<String> infixFormulaList) {
        Stack<String> opStack = new Stack<>();
        List<String> postFixFormulaList = new ArrayList<>();

        Map<String, Integer> opPriorityMap = new HashMap<>();
        opPriorityMap.put("+", 1);
        opPriorityMap.put("-", 1);
        opPriorityMap.put("*", 2);
        opPriorityMap.put("/", 2);

        for (int i = 0; i < infixFormulaList.size(); i++) {
            if (i % 2 == 0) {
                postFixFormulaList.add(infixFormulaList.get(i));
            } else {
                while (!opStack.isEmpty() && Operator.comparePriority(opStack.peek(), infixFormulaList.get(i)) >= 0) {
                    postFixFormulaList.add(opStack.pop());
                }
                opStack.push(infixFormulaList.get(i));
            }
        }

        while (!opStack.isEmpty()) {
            postFixFormulaList.add(opStack.pop());
        }

        return postFixFormulaList;
    }
}

/*
opPriorityMap.get(opStack.peek()) >= opPriorityMap.get(infixFormulaList.get(i)
 */