package engine.compute.validator;

import engine.exception.NotValidInputException;
import engine.model.Token;
import engine.compute.operate.Operator;

import java.util.List;
import java.util.Stack;

public class SimpleExpressionValidator implements ExpressionValidator {
    private final static String errorMsg = "잘못된 수식이 입력되었습니다";

    @Override
    public List<Token> validateToken(List<Token> tokenList) {
        for (Token token : tokenList) {
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
            if (isOperator(token)) {
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();

            } else {
                st.push(token);
            }
        }

        return st.size() == 1;
    }

    private void checkFirstAndLastElement(List<Token> tokenList) {
        if (!isNumber(tokenList.get(0))) {
            throw new NotValidInputException(errorMsg);
        }
        if (!isNumber(tokenList.get(tokenList.size() - 1))) {
            throw new NotValidInputException(errorMsg);
        }
    }
}
