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
     * 계산식(중위표기식)을 파라미터로 받고 후위표기식으로 변환 후 계산하는 메서드
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

            if (!token.equals(MINUS_SIGN) && token.matches(REGEX)) {
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
     * 중위 표기식 -> 후위 표기식 변환 메서드
     * @param infixFormulaList : 중위표기식 토큰 리스트
     * @return 후위표기식 토큰 리스트
     */
    @Override
    public List<String> convertInfixToPostFix(List<String> infixFormulaList) {
        Stack<String> opStack = new Stack<>();
        List<String> postFixFormulaList = new ArrayList<>();

        for (int i = 0; i < infixFormulaList.size(); i++) {
            if (i % 2 == 0) {
                postFixFormulaList.add(infixFormulaList.get(i));
            } else {
                String infixOperator = infixFormulaList.get(i);
                AddOperatorToPostFixFormulaList(opStack, postFixFormulaList, infixOperator);

                opStack.push(infixFormulaList.get(i));
            }
        }

        while (!opStack.isEmpty()) {
            postFixFormulaList.add(opStack.pop());
        }

        return postFixFormulaList;
    }

    /**
     * 스택에 담겨 있는 연산자와 후위표기식 연산자의 우선순위를 비교하여 중위표기식 리스트에 추가하는 메서드
     * @param opStack : 연산자를 담는 스택
     * @param postFixFormulaList : 후위표기식 토큰 리스트
     * @param infixOperator : 중위표기식 연산자 토큰
     */
    private void AddOperatorToPostFixFormulaList(Stack<String> opStack, List<String> postFixFormulaList, String infixOperator) {
        while (!opStack.isEmpty() && Operator.comparePriority(opStack.peek(), infixOperator) >= 0) {
            postFixFormulaList.add(opStack.pop());
        }
    }
}