package calculator.module.arithmetic;

import calculator.module.arithmetic.model.Operand;
import calculator.module.arithmetic.model.Operator;

import java.util.List;
import java.util.Stack;

public class StackArithmeticModule implements ArithmeticModule{
    private final PrefixConverter convertor = new PrefixConverter();
    @Override
    public Double calculate(String expression) {
        List<String> prefixExpression  = convertor.convertExpressionToPrefix(expression);
        Stack<String> operandStack = new Stack<>();
        for(String token : prefixExpression){
            if(Operand.isOperand(token)){
                operandStack.push(token);
            }
            else if(Operator.isOperator(token)){
                double secondOperand = Double.parseDouble(operandStack.pop());
                double firstOperand = Double.parseDouble(operandStack.pop());
                double result = -1;
                switch (token){
                   case "+":
                       result = firstOperand + secondOperand;
                       break;
                    case "-":
                        result = firstOperand - secondOperand;
                        break;
                    case "/":
                        result = firstOperand / secondOperand;
                        break;
                    case "*":
                        result = firstOperand * secondOperand;
                        break;
                    default: System.out.println("Invalid Operator Exception");
                }
                operandStack.push(Double.toString(result));
            }
        }
        return Double.parseDouble(operandStack.peek());
    }
}
