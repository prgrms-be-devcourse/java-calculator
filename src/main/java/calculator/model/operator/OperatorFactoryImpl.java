package calculator.model.operator;

import calculator.model.operator.binary.DivideOperator;
import calculator.model.operator.binary.MinusOperator;
import calculator.model.operator.binary.PlusOperator;
import calculator.model.operator.binary.TimesOperator;
import calculator.model.operator.bracket.CloseBracketOperator;
import calculator.model.operator.bracket.OpenBracketOperator;
import calculator.module.validator.exception.InvalidOperatorTypeException;
import calculator.module.validator.exception.InvalidTokenException;

public class OperatorFactoryImpl implements OperatorFactory {
    @Override
    public Operator makeOperator(String operatorSymbol) throws InvalidTokenException {
        switch (operatorSymbol) {
            case "+":
                return new PlusOperator();
            case "-":
                return new MinusOperator();
            case "*":
                return new TimesOperator();
            case "/":
                return new DivideOperator();
            case "(":
                return new OpenBracketOperator();
            case ")":
                return new CloseBracketOperator();
            default:
                throw new InvalidOperatorTypeException("정의되지 않은 연산자가 연산자로 분류됨");
        }
    }
}
