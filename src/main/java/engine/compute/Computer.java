package engine.compute;

import engine.compute.validator.ExpressionValidator;
import engine.model.InputExpressionFactory;
import engine.model.Token;

import java.util.List;


public class Computer {

    ExpressionValidator expressionValidator;
    InputExpressionFactory expressionFactory;

    public Computer(ExpressionValidator expressionValidator, InputExpressionFactory expressionFactory) {
        this.expressionValidator = expressionValidator;
        this.expressionFactory = expressionFactory;
    }

    public double compute(String input) {
        //1. 사용자가 입력한 연산식을 Token으로 분리(정규식 사용해서 +-*/로 split)
        List<Token> tokens = expressionFactory.convertUserInputToToken(input);

        //2. 검증 - 검증 결과 예외 발생 시 calculator 클래스에서 처리.
        List<Token> availTokens = expressionValidator.validateToken(tokens);

        //3. 후위연산식으로 변환
        expressionFactory.convertToPostFix(availTokens);

        //4. 연산

        return 0;
    }


}
