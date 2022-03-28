package calculator.module.arithmetic;

import calculator.module.arithmetic.model.Operand;
import calculator.module.arithmetic.model.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
*
* PrefixConvertor 설명
* 중위 표기식을 후위표기식으로 변환해주는 클래스
*   1. 공백을 기준으로 수식을 문자열 토큰으로 분리
*   2. 분리한 모든 토큰에 대하여 반복
*       2.1 토큰이 피연산자일 경우 반환 리스트에 추가
*       2.2 토큰이 연산자일 경우 연산자 우선순위에 맞춰서 처리
*       2.3 토큰이 '('일 경우
*           2.3.1 괄호 내부의 식을 별도의 중위 표기식으로 추출
*           2.3.2 추출된 중위 표기식에 대하여 재귀 호출
*   3. 스택에 남아있는 모든 연산자를 반환 리스트에 추가
**/

public class PrefixConverter {
    private final static String EXPRESSION_DELIMITER = " ";

    public List<String> convertExpressionToPrefix(String expression){
        List<String> prefixExpression = new ArrayList<>();
        String[] expressionTokenArray = expression.split(EXPRESSION_DELIMITER);
        Stack<String> operatorStack = new Stack<>();
        int length = expressionTokenArray.length;
        int idx = -1;

        while(++idx < length){
            String token = expressionTokenArray[idx];
            if(Operand.isOperand(token)){
                prefixExpression.add(token);
            }
            else if(Operator.isOperator(token)){
                processingOperator(token,prefixExpression,operatorStack);
            }
            else if(token.equals("(")){
                String subExpression =  createSubExpression(idx,expressionTokenArray);
                List<String> subPrefixExpression =  convertExpressionToPrefix(subExpression);
                prefixExpression.addAll(subPrefixExpression);
                int cnt = subExpression.split(EXPRESSION_DELIMITER).length;
                idx = idx + cnt+1;
            }
        }

        while(!operatorStack.isEmpty()){
            prefixExpression.add(operatorStack.pop());
        }

        return prefixExpression;
    }

    private String createSubExpression(int idx,String [] expressionTokenArray){
        int innerIdx = idx;
        int bracketCount = 1;
        StringBuilder subExpression = new StringBuilder();
        while(bracketCount > 0){
            String newToken = expressionTokenArray[++innerIdx];
            if(newToken.equals(")")){
                bracketCount--;
                if(bracketCount == 0) break;
            }
            else if(newToken.equals("(")) bracketCount ++;
            subExpression.append(newToken);
            subExpression.append(EXPRESSION_DELIMITER);
        }
        return subExpression.toString();
    }

    private void processingOperator(String token,List<String> prefixExpression, Stack<String> operatorStack){
        if (operatorStack.isEmpty()) {
            operatorStack.push(token);
        }
        else {
            String target = operatorStack.peek();
            if (hasLowerPriority(token, target)) {
                prefixExpression.add(operatorStack.pop());
                operatorStack.add(token);
            }
            else {
                operatorStack.push(token);
            }
        }
    }

    private boolean hasLowerPriority(String token,String target) {
        return ((token.equals("+") || token.equals("-")) && (target.equals("*") || target.equals("/"))) ||
                (token.equals("+") || token.equals("-")) && (target.equals("+") || target.equals("-"));
    }
}
