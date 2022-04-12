package calculator.module.arithmetic;

import calculator.model.expression.Expression;
import calculator.model.expression.ExpressionableToken;
import calculator.model.operand.Operand;
import calculator.model.operand.OperandPool;
import calculator.model.operator.Operator;

import java.util.List;

/**
 * StackArithmeticModule 설명
 * 스택을 이용해 산술을 수행하는 클래스
 * <p>
 * 기능
 * Expression을 인자로 받아 산술연산을 진행한다.
 * - 중위표기식으로 구성된 Expression을 후위 표기식으로 변경한다 -> PrefixConverter 클래스에 위임
 * - 산술을 진행한다 -> 각 Operator 클래스에게 위임
 **/
public class StackArithmeticModule implements ArithmeticModule {
    private final PrefixConverter convertor = new PrefixConverter();

    @Override
    public Double calculate(Expression expression) {
        List<ExpressionableToken> prefixExpression = convertor.convertExpressionToPrefix(expression.getTokenArray());
        OperandPool operandPool = new StackOperandPool();
        for (ExpressionableToken token : prefixExpression) {
            if (token instanceof Operand) {
                operandPool.addOperand((Operand) token);
            } else if (token instanceof Operator) {
                double result = ((Operator) token).calculate(operandPool);
                operandPool.addOperand(new Operand(Double.toString(result)));
            }
        }
        return operandPool.getOneOperand();
    }
}
