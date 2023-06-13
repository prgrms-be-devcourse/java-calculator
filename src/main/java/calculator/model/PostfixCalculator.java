package calculator.model;

import java.util.List;
import java.util.Stack;

public class PostfixCalculator implements BasicCalculator{

    public static final String OPERATOR_REGEX = "[-*/+]";
    @Override
    public Integer calculate(List<String> expression) {
        Stack<String> calcStack = new Stack<>();
        Operation operation = new Operation();

        int op1, op2;

        for(String s : expression){
            if(s.matches(OPERATOR_REGEX)){
                op2 = Integer.parseInt(calcStack.pop());
                op1 = Integer.parseInt(calcStack.pop());

                Integer result = operation.calculate(op1, s, op2);
                calcStack.push(String.valueOf(result));
            }
            else{
                calcStack.push(s);
            }
        }
        return Integer.valueOf(calcStack.pop());
    }
}
