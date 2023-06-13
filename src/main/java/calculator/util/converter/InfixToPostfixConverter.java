package calculator.util.converter;

import calculator.model.Operation;
import calculator.util.ExpressionConverter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToPostfixConverter implements ExpressionConverter {
    private final ArrayList<String> postfix;
    private final Stack<String> opStack;
    private final Operation operation;

    private static final String EXPRESSION_DELIMITER = " ";
    public static final String OPERATOR_REGEX = "[-*/+]";
    public static final String OPERAND_REGEX = "^\\d+$";


    public InfixToPostfixConverter(){
        postfix = new ArrayList<>();
        opStack = new Stack<>();
        operation = Operation.getInstance();
    }

    @Override
    public ArrayList<String> convert(String infixExpression) {
        StringBuilder num = new StringBuilder();

        // 중위 표기식을 리스트로 변환
        String[] infix = infixExpression.split(EXPRESSION_DELIMITER);

        // 후위 표기식으로 전환
        for(String s : infix){
            if(s.matches(OPERATOR_REGEX)){
                if(!num.isEmpty()){
                    postfix.add(num.toString());
                    num = new StringBuilder();
                }
                if (opStack.isEmpty()) opStack.push(s);
                else {
                    if (Operation.getOperator(opStack.peek()).isPrioritySameOrGreater(Operation.getOperator(s))) {
                        postfix.add(opStack.pop());
                    }
                    opStack.push(s);
                }
            } else if (s.matches(OPERAND_REGEX)) {
                num.append(s);
            }
        }
        if(!num.isEmpty()) {
            postfix.add(num.toString());
        }
        while(!opStack.isEmpty()){
            postfix.add(opStack.pop());
        }
        return postfix;
    }
}
