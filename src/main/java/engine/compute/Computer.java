package engine.compute;

import engine.compute.validator.InputExpressionValidator;
import engine.model.InputExpression;
import engine.model.InputExpressionFactory;

import java.beans.Expression;

public class Computer {

    InputExpressionValidator expressionValidator;
    InputExpressionFactory expressionFactory;

    public double compute(String input) {
        //0. String -> InputExpression 타입으로 변환
        InputExpression inputExpression = expressionFactory.createInputExpression(input);
        //1. 사용자 연산식 검사
        expressionValidator.validate(inputExpression);
        //validator에 의탁
        //2. 사용자 연산 식 계산 후 리턴

        return 0;
    }


}
