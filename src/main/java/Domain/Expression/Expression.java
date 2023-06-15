package Domain.Expression;

import Common.Exception.WrongExpressionException;
import Common.Exception.WrongValueException;
import Domain.Calculator.ArithmeticOperation;
import Domain.Expression.utils.InfixToPostfix;
import Domain.Expression.utils.Validator.NumberValidator;
import Domain.Expression.utils.Validator.OperationValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final String infix;
    private final List<String> infixExp;
    private final List<String> postfixExp;

    public Expression(String infix) throws WrongExpressionException, WrongValueException {
        this.infix = infix;
        this.infixExp = Arrays.asList(infix.split(" "));
        if (isWrongExpression()) {
            throw new WrongExpressionException();
        }
        this.postfixExp = new InfixToPostfix().convert(infix);
    }

    public SolvedExpression solve() {
        Stack<Double> stack = new Stack<>();
        for (String s : postfixExp) {
            if (NumberValidator.validate(s)) {
                stack.push(Double.parseDouble(s));
            } else if (OperationValidator.validate(s)) {
                Double a = stack.pop();
                Double b = stack.pop();
                ArithmeticOperation operation = ArithmeticOperation.from(s);
                Double calculated = operation.calculate(b, a);
                stack.push(calculated);
            }
        }
        Double result = stack.pop();
        return new SolvedExpression(infix, result);
    }

    public boolean isWrongExpression() {
        int cntNumber = 0;
        int cntOperation = 0;
        for (String s : infixExp) {
            if (NumberValidator.validate(s)) {
                cntNumber++;
            } else if (OperationValidator.validate(s)) {
                cntOperation++;
            }
        }
        return cntOperation != cntNumber - 1;
    }
}

