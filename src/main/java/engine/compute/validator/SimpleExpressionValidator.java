package engine.compute.validator;

import engine.model.InputExpression;

public class SimpleExpressionValidator implements InputExpressionValidator{
    @Override
    public void validate(InputExpression inputExpression) {
        //1. 길이가 0인지 검사하는 로직
        //2. 올바른 연산자를 사용했는지 검사하는 로직
        //3. 연산자, 피연산자의 순서를 검사하는 로직
        //4. 0으로 나누는 연산인지 검사하는 로직 .?
    }
}
