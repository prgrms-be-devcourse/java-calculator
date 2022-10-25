package engine.compute;

import engine.compute.validator.ExpressionValidator;
import engine.model.Token;
import engine.compute.converter.ExpressionConverter;
import engine.compute.operate.OperateMachine;

import java.util.List;


public class Computer {

    private ExpressionValidator expressionValidator;
    private ExpressionConverter expressionConverter;
    private OperateMachine operateMachine;


    public Computer(ExpressionValidator expressionValidator, ExpressionConverter expressionConverter) {
        this.expressionValidator = expressionValidator;
        this.expressionConverter = expressionConverter;
        operateMachine = new OperateMachine(expressionValidator);
    }

    public String compute(String input) {
        //1. 사용자가 입력한 연산식을 Token으로 분리(정규식 사용해서 +-*/로 split)
        List<Token> tokens = expressionConverter.convertUserInputToToken(input);

        //2. 검증 - 올바른 연산식인지 검증. 아닐 경우 NotValidInputException 발생 후 Calculator 클래스에서 처리
        List<Token> availTokens = expressionValidator.validateToken(tokens);

        //3. 후위연산식으로 변환
        List<Token> postFix = expressionConverter.convertToPostFix(availTokens);

        //4. 연산 후 값 반환
        return operateMachine.doCalculate(postFix);
    }
}
