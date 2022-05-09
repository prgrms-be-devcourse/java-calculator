package calculator.module.arithmetic;

import calculator.model.expression.ExpressionableToken;
import calculator.model.operand.Operand;
import calculator.model.operator.binary.BinaryOperator;
import calculator.model.operator.bracket.CloseBracketOperator;
import calculator.model.operator.bracket.OpenBracketOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
*
* PrefixConvertor 설명
* 중위 표기식을 후위표기식으로 변환해주는 클래스
*
* 후위표기식 변환 로직
*   1. 공백을 기준으로 수식을 문자열 토큰으로 분리
*   2. 분리한 모든 토큰에 대하여 반복
*       2.1 토큰이 피연산자일 경우 반환 리스트에 추가
*       2.2 토큰이 이항 연산자일 경우 연산자 우선순위에 맞춰서 반환 리스트에 추가
*       2.3 토큰이 '('일 경우
*           2.3.1 괄호 내부의 식을 별도의 중위 표기식으로 추출
*           2.3.2 추출된 중위 표기식에 대하여 재귀 호출
*   3. 스택에 남아있는 모든 연산자를 반환 리스트에 추가
**/

public class PrefixConverter {
    public List<ExpressionableToken> convertExpressionToPrefix(ExpressionableToken[] tokenArray){
        List<ExpressionableToken> prefixExpression = new ArrayList<>();
        Stack<BinaryOperator> operatorStack = new Stack<>();
        int length = tokenArray.length;
        int idx = -1;

        while(++idx < length){
            ExpressionableToken token = tokenArray[idx];
            if(token instanceof Operand){
                prefixExpression.add(token);
            }
            else if(token instanceof BinaryOperator){
                processingOperator((BinaryOperator) token,prefixExpression,operatorStack);
            }
            else if(token instanceof OpenBracketOperator){
                ExpressionableToken[] subExpression =  divideSubExpression(idx,tokenArray);
                List<ExpressionableToken> subPrefixExpression =  convertExpressionToPrefix(subExpression);
                prefixExpression.addAll(subPrefixExpression);
                int cnt = subExpression.length;
                idx = idx + cnt+1;
            }
        }

        while(!operatorStack.isEmpty()){
            prefixExpression.add(operatorStack.pop());
        }

        return prefixExpression;
    }

    private ExpressionableToken[] divideSubExpression(int startIndex, ExpressionableToken[] tokens){
        int idx = startIndex;
        int openedBracketCount = 1;
        List<ExpressionableToken> subExpression = new ArrayList<>();
        while(openedBracketCount > 0){
            ExpressionableToken token = tokens[++idx];
            if(token instanceof CloseBracketOperator){
                openedBracketCount--;
                if(openedBracketCount == 0) break;
            }
            else if(token instanceof OpenBracketOperator) openedBracketCount ++;
            subExpression.add(token);
        }
        return subExpression.toArray(new ExpressionableToken[0]);
    }

    private void processingOperator(BinaryOperator token, List<ExpressionableToken> prefixExpression, Stack<BinaryOperator> operatorStack){
        if (operatorStack.isEmpty()) {
            operatorStack.push(token);
        }
        else {
            BinaryOperator target = operatorStack.peek();
            if (token.hasLowerPriority(target)) {
                prefixExpression.add(operatorStack.pop());
                operatorStack.add(token);
            }
            else {
                operatorStack.push(token);
            }
        }
    }
}
