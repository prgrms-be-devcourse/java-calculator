package calculator.module.validator;

import calculator.model.expression.Expression;
import calculator.model.expression.ExpressionableToken;
import calculator.model.operand.Operand;
import calculator.model.operator.bracket.CloseBracketOperator;
import calculator.model.operator.bracket.OpenBracketOperator;
import calculator.module.validator.exception.InvalidExpressionException;

import java.util.Stack;

/**
*
* CommonExpressionValidator 설명
* Expression이 계산 가능한 유효한 수식인지 검증해주는 클래스
 *
 * 검증해야 할 목록
 *  - 수식의 길이가 0이 아닌지
 *  - 괄호의 쌍이 올바른지
 *  - 연산자, 피연산자, 괄호, 순서가 올바른지
**/

public class CommonExpressionValidator implements ExpressionValidator{
    private final static String BRACKET_PAIR_NOT_CORRECT_MESSAGE = "괄호가 올바르지 않습니다";
    private final static String EXPRESSION_SIZE_ZERO_MESSAGE = "한 글자 이상 입력해주세요";
    private final static String EXPRESSION_ORDER_INVALID_MESSAGE = "잘못된 수식입니다.";

    @Override
    public void validateExpression(Expression expression) throws InvalidExpressionException {
        ExpressionableToken[] tokens = expression.getTokenArray();
        checkExpressionLengthOverZero(tokens);
        checkIsBracketPairCorrect(tokens);
        checkExpressionOrder(tokens);
    }

    // 잘못된 괄호가 있는지 먼저 검증 필요.
    private void checkExpressionOrder(ExpressionableToken[] tokens) throws InvalidExpressionException {
        int length = tokens.length;
        checkStartWithOpenBracketOrOperand(tokens[0]);
        checkMiddleTokenOrder(tokens);
        checkEndWithCloseBracketOrOperand(tokens[length-1]);
    }

    private void checkStartWithOpenBracketOrOperand(ExpressionableToken token) throws InvalidExpressionException{
        if(!(token instanceof OpenBracketOperator || token instanceof Operand))
            throw new InvalidExpressionException(EXPRESSION_ORDER_INVALID_MESSAGE);
    }

    private void checkMiddleTokenOrder(ExpressionableToken[] tokens) throws InvalidExpressionException{
        int length = tokens.length;
        for(int i = 1; i < length-2; i++) {
            ExpressionableToken cur = tokens[i];
            ExpressionableToken next = tokens[i+1];
            if(!cur.couldOtherTokenComeNext(next))
                throw new InvalidExpressionException(EXPRESSION_ORDER_INVALID_MESSAGE);
        }
    }

    private void checkEndWithCloseBracketOrOperand(ExpressionableToken token) throws InvalidExpressionException{
        if(!(token instanceof CloseBracketOperator || token instanceof Operand))
            throw new InvalidExpressionException(EXPRESSION_ORDER_INVALID_MESSAGE);
    }

    private void checkExpressionLengthOverZero(ExpressionableToken[] tokens) throws InvalidExpressionException {
        if(tokens.length == 0) throw new InvalidExpressionException(EXPRESSION_SIZE_ZERO_MESSAGE);
    }

    private void checkIsBracketPairCorrect(ExpressionableToken[] tokens) throws InvalidExpressionException {
        Stack<String> stack = new Stack<>();
        for (ExpressionableToken token : tokens) {
            if(token instanceof OpenBracketOperator)
                stack.push("(");
            else if(token instanceof CloseBracketOperator){
                if(stack.empty())
                    throw new InvalidExpressionException(BRACKET_PAIR_NOT_CORRECT_MESSAGE);
                else if(stack.peek().equals("(")) {
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty())
            throw new InvalidExpressionException(BRACKET_PAIR_NOT_CORRECT_MESSAGE);
    }
}
