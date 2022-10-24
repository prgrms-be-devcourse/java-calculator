package engine.compute.validator;

import engine.operate.Operator;
import engine.exception.NotValidInputException;
import engine.model.Token;

import java.util.List;
import java.util.Stack;

public class SimpleExpressionValidator implements ExpressionValidator {
    private final String errorMsg = "잘못된 수식이 입력되었습니다";

    @Override
    public List<Token> validateToken(List<Token> tokenList) {
        //Token으로 쪼개진 연산자, 피연산자를 검사한다.
        for (Token token : tokenList) {
            //숫자, 연산자 둘 다 아닌 문자인 경우 exception 발생
            if (!(isNumber(token) || isOperator(token))) {
                throw new NotValidInputException(errorMsg);
            }
        }

        checkFirstAndLastElement(tokenList);

        if (!isCorrectOrder(tokenList)) {
            throw new NotValidInputException(errorMsg);
        }

        return tokenList;
    }

    private void checkFirstAndLastElement(List<Token> tokenList) {
        if (!isNumber(tokenList.get(0))) {
            throw new NotValidInputException(errorMsg);
        }
        if (!isNumber(tokenList.get(tokenList.size() - 1))) {
            throw new NotValidInputException(errorMsg);
        }
    }

    @Override
    public boolean isNumber(Token token) {
        String tokenValue = token.getToken();
        try {
            Double.parseDouble(tokenValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isOperator(Token token) {
        return Operator.isOperator(token.getToken());
    }

    @Override
    public boolean isCorrectOrder(List<Token> tokenList) {
        Stack<Token> st = new Stack<>();

        for (Token token : tokenList) {
            if(isOperator(token)){
                if(st.isEmpty()){
                    return false;
                }
                st.pop();

            }else{
                st.push(token);
            }
        }

        return st.size() == 1 ? true : false;
    }
}
