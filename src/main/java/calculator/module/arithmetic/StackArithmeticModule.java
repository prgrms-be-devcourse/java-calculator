package calculator.module.arithmetic;

import calculator.model.expression.Expression;
import calculator.model.operand.Operand;
import calculator.model.operator.binary.BinaryOperator;
import calculator.model.expression.ExpressionableToken;
import java.util.List;
import java.util.Stack;

/**
*
* StackArithmeticModule 설명
*   스택을 이용해 산술을 수행하는 클래스
*
*  기능
*  Expression을 인자로 받아 산술연산을 진행한다.
*    - 중위표기식으로 구성된 Expression을 후위 표기식으로 변경한다 -> PrefixConverter 클래스에 위임
*    - 산술을 진행한다 -> 각 Operator 클래스에게 위임
*
*  중요하게 생각한 점
*  이 클래스를 구현하면서 가장 중요하게 생각했던 점은 새로운 연산자가 추가되어도 이 클래스의 코드를 수정할 필요가 없도록 하는것이었습니다.
*  연산 기능을 연산자 클래스에 위임하여 이후 다른 연산기능이 추가될 경우에 새로운 연산자 클래스를 만들어 쉽게 기능을 확장할 수 있도록 의도하였습니다.
*  저의 의도가 올바른지, 의도한대로 구조가 잡혔는지, 이러한 구조에 발생할 수 있는 문제가 무엇이 있을지,
*  instance of 연산자를 이런식으로 사용하는게 맞는지 궁금합니다.
**/
public class StackArithmeticModule implements ArithmeticModule{
    private final PrefixConverter convertor = new PrefixConverter();

    @Override
    public Double calculate(Expression expression) {
        List<ExpressionableToken> prefixExpression  = convertor.convertExpressionToPrefix(expression.getTokenArray());
        Stack<Operand> operandStack = new Stack<>();
        for(ExpressionableToken token : prefixExpression){
            if(token instanceof Operand ){
                operandStack.push((Operand) token);
            }
            else if(token instanceof BinaryOperator){
                double secondOperand = Double.parseDouble(operandStack.pop().getValue());
                double firstOperand = Double.parseDouble(operandStack.pop().getValue());
                double result = ((BinaryOperator) token).doBinaryCalculate(firstOperand,secondOperand);
                operandStack.push(new Operand(Double.toString(result)));
            }
        }
        return Double.parseDouble(operandStack.peek().getValue());
    }
}
